package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhkj.syyj.Activitys.LoginActivity;
import com.zhkj.syyj.Adapters.TaskListAdapter;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskListFragment extends Fragment {


    private View inflate;
    private XRecyclerView tasklist_recyclerView;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private TaskListAdapter taskListAdapter;
    public static final String TRANSFER_PAGE = "page";
    private String mArgument;

    public TaskListFragment() {
        // Required empty public constructor
    }
    public static Fragment getIntance(int page){
        Bundle bundle = new Bundle();
        bundle.putInt(TRANSFER_PAGE,page);
        TaskListFragment pageFragment = new TaskListFragment();
        pageFragment.setArguments(bundle);
        return  pageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_task_list, container, false);
        mContext = getContext();
        InitUI();
        return inflate;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        return;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            mArgument = bundle.getString(TRANSFER_PAGE);
            Log.e("mArgument",mArgument);
       }
    }

    private void InitUI() {
        tasklist_recyclerView = inflate.findViewById(R.id.fm_tasklist_recyclerView);
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
        tasklist_recyclerView.setAdapter(taskListAdapter);
    }
    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public int dpToPx(Context context, float dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5f);
    }
    /**
     * 获得资源 dimens (dp)
     *
     * @param context
     * @param id      资源id
     * @return
     */
    public float getDimens(Context context, int id) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        float px = context.getResources().getDimension(id);
        return px / dm.density;
    }
}
