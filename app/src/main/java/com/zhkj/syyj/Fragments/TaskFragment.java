package com.zhkj.syyj.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhkj.syyj.Adapters.HasBeenDoneAdapter;
import com.zhkj.syyj.Adapters.OnItemClickListener;
import com.zhkj.syyj.Adapters.RecyclerLeftAdapter;
import com.zhkj.syyj.Adapters.TaskListAdapter;
import com.zhkj.syyj.Adapters.TaskTableAdapter;
import com.zhkj.syyj.Beans.TaskCategoryBean;
import com.zhkj.syyj.Beans.TaskListsBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.zhkj.syyj.Utils.MxyUtils.dpToPx;
import static com.zhkj.syyj.Utils.MxyUtils.getDimens;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskFragment extends Fragment {


    private View inflate;

    private List<Fragment> fragments=new ArrayList<>();
    private RadioGroup task_radioGroup;
    private RadioButton ckbtn_task;
    private RadioButton ckbtn_done;
    private XRecyclerView mRecyclerView;
    private List<TaskListsBean.DataBean.TaskListBean> tasklist_item=new ArrayList<>();
    private List<String> tasklist=new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private HasBeenDoneAdapter hasBeenDoneAdapter;
    private List<TaskCategoryBean.DataBean> taskCategoryList=new ArrayList<>();
    private RecyclerView table_recycler;
    private TaskTableAdapter taskTableAdapter;
    private XRecyclerView tasklist_recyclerView;
    private TaskListAdapter taskListAdapter;
    private LinearLayout ll_task;
    private SharedPreferences share;
    private String token;
    private String uid;
    private int TasklistPage=0;
    private int taskId;
    private int DonePage=0;
    private CustomProgressDialog progressDialog;

    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_task, container, false);
        mContext = getContext();
        share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        tasklist.add("112");
        tasklist.add("112");
        tasklist.add("112");
        tasklist.add("112");
        tasklist.add("112");
        InitUI();
        InitData();
        return inflate;
    }

    public void InitData() {
        if (progressDialog == null){
            progressDialog = CustomProgressDialog.createDialog(mContext);
        }
        progressDialog.show();
        OkGo.<String>get(RequstUrlUtils.URL.TaskCategory)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (progressDialog != null){
                            progressDialog.dismiss();
                            progressDialog = null;
                        }
                        TaskCategoryBean taskCategoryBean = new GsonBuilder().create().fromJson(response.body(), TaskCategoryBean.class);
                        if (taskCategoryBean.getCode()==1){
                            SltTitle(taskCategoryBean.getData());
                        }
                    }
                });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void InitUI() {
        ll_task = inflate.findViewById(R.id.fm_task_ll_task);
        task_radioGroup =  inflate.findViewById(R.id.fm_task_radioGroup);
        ckbtn_task =  inflate.findViewById(R.id.fm_task_ckbtn_task);
        ckbtn_done =  inflate.findViewById(R.id.fm_task_ckbtn_done);
        table_recycler = inflate.findViewById(R.id.fm_task_table_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        table_recycler.setLayoutManager(layoutManager);
        taskTableAdapter = new TaskTableAdapter(mContext, this.taskCategoryList);
        table_recycler.setAdapter(taskTableAdapter);
        mRecyclerView = inflate.findViewById(R.id.fm_task_recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        hasBeenDoneAdapter = new HasBeenDoneAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        , dpToPx(mContext, getDimens(mContext, R.dimen.dp_10)));
            }
        });
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        hasBeenDoneAdapter.setListAll(tasklist);
        mRecyclerView.setAdapter(hasBeenDoneAdapter);
        task_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.fm_task_ckbtn_task:
                        mRecyclerView.setVisibility(View.GONE);
                        ll_task.setVisibility(View.VISIBLE);
                        ckbtn_done.setBackground(getResources().getDrawable(R.drawable.nochoosed_color));
                        ckbtn_task.setBackground(getResources().getDrawable(R.drawable.choosed_color));
                        break;
                    case R.id.fm_task_ckbtn_done:
                        ll_task.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        ckbtn_done.setBackground(getResources().getDrawable(R.drawable.choosed_color));
                        ckbtn_task.setBackground(getResources().getDrawable(R.drawable.nochoosed_color));
                        GetDoneList();
                        break;
                }
            }
        });

        //任务列表
        tasklist_recyclerView = inflate.findViewById(R.id.fm_task_tasklist_recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        taskListAdapter = new TaskListAdapter(mContext);
        tasklist_recyclerView.setLayoutManager(mLayoutManager);
        tasklist_recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        , dpToPx(mContext, getDimens(mContext, R.dimen.dp_10)));
            }
        });
        tasklist_recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                tasklist_recyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                tasklist_recyclerView.loadMoreComplete();//加载动画完成
                tasklist_recyclerView.setNoMore(true);//数据加载完成
            }
        });
        taskListAdapter.setListAll(tasklist_item);
        tasklist_recyclerView.setAdapter(taskListAdapter);
    }


    //获取头部列表
    public void  SltTitle(final List<TaskCategoryBean.DataBean> taskCategoryList){
        this.taskCategoryList=taskCategoryList;
        taskTableAdapter = new TaskTableAdapter(mContext, this.taskCategoryList);
        table_recycler.setAdapter(taskTableAdapter);
        if (taskCategoryList.size()>0) {
            taskId = taskCategoryList.get(0).getId();
            GetTaskList(taskId);
        }
        taskTableAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                taskId = taskCategoryList.get(position).getId();
                taskTableAdapter.refreshData(position);
                taskTableAdapter.notifyDataSetChanged();
                GetTaskList(taskId);
            }
        });
    }


    //获取任务列表
    public void GetTaskList(int taskId){
                OkGo.<String>get(RequstUrlUtils.URL.TaskList)
                        .params("uid",uid)
                        .params("token",token)
                        .params("cat_id",taskId)
                        .params("page",TasklistPage)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                TaskListsBean taskListsBean = new GsonBuilder().create().fromJson(response.body(), TaskListsBean.class);
                                TaskListsBean.DataBean data = taskListsBean.getData();
                                List<TaskListsBean.DataBean.TaskListBean> taskList = data.getTaskList();
                                taskListAdapter.setListAll(taskList);
                                tasklist_recyclerView.setAdapter(taskListAdapter);
                            }
        });
    }

    //已完成任务
    public void GetDoneList(){
        OkGo.<String>get(RequstUrlUtils.URL.DoneList)
                .params("uid",uid)
                .params("token",token)
                .params("page",DonePage)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new GsonBuilder().create();
                        hasBeenDoneAdapter.setListAll(tasklist);
                        mRecyclerView.setAdapter(hasBeenDoneAdapter);
                    }
                });
    }
}
