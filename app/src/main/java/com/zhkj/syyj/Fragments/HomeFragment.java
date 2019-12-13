package com.zhkj.syyj.Fragments;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.yyydjk.library.BannerLayout;
import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.Activitys.GoodsDetailActivity;
import com.zhkj.syyj.Activitys.HomeActivity;
import com.zhkj.syyj.Activitys.InformationChoiceActivity;
import com.zhkj.syyj.Activitys.InformationChoiceDetailActivity;
import com.zhkj.syyj.Activitys.ReMindActivity;
import com.zhkj.syyj.Activitys.ShopFmSearchActivity;
import com.zhkj.syyj.Adapters.ShopChoiceAdapter;
import com.zhkj.syyj.Beans.HomeIndexBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.CustView.GlideImageLoader;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private Context mContext;
    private XRecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private ShopChoiceAdapter shopChoiceAdapter;
    private View home_top;
    private ImageView home_choice_img;
    private TextView home_choice_tv_title;
    private TextView home_choice_tv_title_description;
    private BannerLayout bannerLayout;
    //轮播图
    final List<String> urls = new ArrayList<>();
    private NoScrollListView task_listv;
    private TaskAdapter taskAdapter;
    private List<HomeIndexBean.DataBean.TaskListBean> taskList=new ArrayList<>();
    private List<HomeIndexBean.DataBean.GoodsBean> goodsList=new ArrayList<>();
    private String article_id="";
    private CustomProgressDialog progressDialog;
    private int SHOPFMSEARCH_CODE=1001;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getContext();
        InitUI();
        InitData();
        return inflate;
    }

    public void InitData() {
        if (progressDialog == null){
            progressDialog = CustomProgressDialog.createDialog(getContext());
        }
        progressDialog.show();
        OkGo.<String>get(RequstUrlUtils.URL.HomeIndex)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (progressDialog != null){
                            progressDialog.dismiss();
                            progressDialog = null;
                        }
                        HomeIndexBean homeIndexBean = new GsonBuilder().create().fromJson(response.body(), HomeIndexBean.class);
                        if (homeIndexBean.getCode()==1){
                            HomeIndexBean.DataBean data = homeIndexBean.getData();
                            HomeIndexBean.DataBean.NewsBean news = data.getNews();
                            List<HomeIndexBean.DataBean.BannerBean> banner = data.getBanner();
                            if (banner!=null){
                                urls.clear();
                              for (int a=0;a<banner.size();a++){
                                  urls.add(RequstUrlUtils.URL.HOST+banner.get(a).getImg());
                              }
                                bannerLayout.setViewUrls(urls);
                            }
                            if (news!=null) {
                                Glide.with(mContext).load(RequstUrlUtils.URL.HOST + news.getThumb()).into(home_choice_img);
                                home_choice_tv_title.setText(news.getTitle());
                                home_choice_tv_title_description.setText(news.getDescription());
                                article_id = news.getArticle_id()+"";
                            }
                            taskList = data.getTaskList();
                            if (taskList.size()>0){
                                taskAdapter = new TaskAdapter();
                                task_listv.setAdapter(taskAdapter);
                            }
                            goodsList = data.getGoods();
                            if (goodsList.size()>0){
                                shopChoiceAdapter.setListAll(goodsList);
                                mRecyclerView.setAdapter(shopChoiceAdapter);
                            }
                        }
                    }
                });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    private void InitUI() {
        home_top = getLayoutInflater().inflate(R.layout.fm_home_top, null);
        home_top.findViewById(R.id.fmhome_tv_information_choice).setOnClickListener(this);
        home_top.findViewById(R.id.fmhome_rl_information_choice).setOnClickListener(this);
        home_top.findViewById(R.id.fmhome_rl_tv_task_lists).setOnClickListener(this);
        home_top.findViewById(R.id.fmhome_rl_tv_goods_lists).setOnClickListener(this);
        inflate.findViewById(R.id.home_top_search).setOnClickListener(this);
        home_choice_img = home_top.findViewById(R.id.home_choice_img);
        home_choice_tv_title = home_top.findViewById(R.id.home_choice_tv_title);
        home_choice_tv_title_description = home_top.findViewById(R.id.home_choice_tv_title_description);
        bannerLayout = home_top.findViewById(R.id.fm_home_banner);
        bannerLayout.setAutoPlay(true);
        bannerLayout.setImageLoader(new GlideImageLoader());
        //添加点击监听
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        task_listv = home_top.findViewById(R.id.home_task_list);
        mRecyclerView = inflate.findViewById(R.id.fmhome_XRecyclerView);
        mRecyclerView.addHeaderView(home_top);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager =new GridLayoutManager(mContext, 2);
        shopChoiceAdapter = new ShopChoiceAdapter(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }
            @Override
            public void onLoadMore() {
                //加载更多
//                shopChoiceAdapter.addItemsToLast(goodsList);
//                shopChoiceAdapter.notifyDataSetChanged();
                mRecyclerView.setNoMore(true);//数据加载完成
                mRecyclerView.loadMoreComplete();//加载动画完成
            }
        });
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10))
                        , 0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10)));
            }
        });
        shopChoiceAdapter.setListAll(goodsList);
        mRecyclerView.setAdapter(shopChoiceAdapter);
        shopChoiceAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                 intent.putExtra("goods_id",goodsList.get(position).getGoods_id()+"");
                intent.putExtra("img_item", RequstUrlUtils.URL.HOST+goodsList.get(position).getOriginal_img());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fmhome_tv_information_choice:
                startActivity(new Intent(mContext, InformationChoiceActivity.class));
                break;
            case R.id.fmhome_rl_information_choice:
                if (!article_id.equals("")) {
                    Intent intent = new Intent(mContext, InformationChoiceDetailActivity.class);
                    intent.putExtra("id", article_id + "");
                    startActivity(intent);
                }
                break;
            case R.id.fmhome_rl_tv_task_lists:
               Intent intent1=new Intent(mContext,HomeActivity.class);
               intent1.putExtra("currentItems","2");
               startActivity(intent1);
                break;
            case R.id.home_top_search:
                Intent intent2 = new Intent(mContext, ShopFmSearchActivity.class);
                startActivityForResult(intent2,SHOPFMSEARCH_CODE);
                break;
            case R.id.fmhome_rl_tv_goods_lists:
                startActivity(new Intent(mContext,ShopFmSearchActivity.class));
                break;
                default:
                    break;
        }
    }

    public class TaskAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return taskList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            final View inflate = getLayoutInflater().inflate(R.layout.list_home_task, null);
            TextView tv_content= inflate.findViewById(R.id.list_home_task_tv_content);
            tv_content.setText(taskList.get(i).getShare_content());
            TextView tv_rrp= inflate.findViewById(R.id.list_home_task_tv_rrp);
            tv_rrp.setText(taskList.get(i).getMarket_price());
            TextView tv_price = inflate.findViewById(R.id.list_home_task_tv_price);
            tv_price.setText(taskList.get(i).getShop_price());
            ImageView task_img = inflate.findViewById(R.id.list_home_task_img);
            Glide.with(mContext).load(RequstUrlUtils.URL.HOST+taskList.get(i).getOriginal_img()).into(task_img);
            inflate.findViewById(R.id.list_home_task_tv_detail).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ForwardActivity.class);
                    intent.putExtra("task_id",taskList.get(i).getId()+"");
                    intent.putExtra("content",taskList.get(i).getShare_content());
                    ArrayList<String> share_imgs = (ArrayList<String>) taskList.get(i).getShare_imgs();
                    intent.putStringArrayListExtra("share_imgs",share_imgs);
                    startActivity(intent);
                }
            });
            inflate.findViewById(R.id.list_home_task_btn_setReMind).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ReMindActivity.class);
                    intent.putExtra("task_id",taskList.get(i).getId()+"");
                    startActivity(intent);
                }
            });
            inflate.findViewById(R.id.list_home_task_btn_forward).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WechatDialog();
                }
            });

            return inflate;
        }
    }

    //转发朋友圈
    public void  WechatDialog(){
        final BottomDialog bottomDialog = new BottomDialog(mContext, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_forward_moments, null);
        inflate.findViewById(R.id.dialog_forward_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }

    private String imageTranslateUri(int resId) {
       try {
           Resources r = getResources();
           Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                   + r.getResourcePackageName(resId) + "/"
                   + r.getResourceTypeName(resId) + "/"
                   + r.getResourceEntryName(resId));

           return uri.toString();
       }catch (Exception e){
           return "";
       }
    }


}
