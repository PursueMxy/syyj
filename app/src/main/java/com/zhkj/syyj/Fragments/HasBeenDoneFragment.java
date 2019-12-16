package com.zhkj.syyj.Fragments;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhkj.syyj.Adapters.HasBeenDoneAdapter;
import com.zhkj.syyj.Adapters.TaskListAdapter;
import com.zhkj.syyj.Beans.DoneListBean;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.R;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HasBeenDoneFragment extends Fragment {


    private View inflate;
    private XRecyclerView mRecyclerView;
    private List<DoneListBean.DataBean> tasklist_item=new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private HasBeenDoneAdapter hasBeenDoneAdapter;
    private CustomProgressDialog progressDialog;

    public HasBeenDoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_has_been_done, container, false);
        mContext = getContext();
        InitUI();
        return inflate;
    }

    private void InitUI() {
        mRecyclerView = inflate.findViewById(R.id.fm_has_been_done_recyclerView);
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
        hasBeenDoneAdapter.setListAll(tasklist_item);
         mRecyclerView.setAdapter(hasBeenDoneAdapter);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
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

    public  void LoadingDialogShow(){
        try {
            if (progressDialog == null){
                progressDialog = CustomProgressDialog.createDialog(getContext());
            }
            progressDialog.show();
        }catch (Exception e){}
    }

    public void LoadingDialogClose(){
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }catch (Exception e){}
    }
}
