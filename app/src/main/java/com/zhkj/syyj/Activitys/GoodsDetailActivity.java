package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.GsonBuilder;
import com.yyydjk.library.BannerLayout;
import com.zhkj.syyj.Adapters.GridAdapter;
import com.zhkj.syyj.Beans.CommentStatisticsBean;
import com.zhkj.syyj.Beans.GoodsDetailBean;
import com.zhkj.syyj.Beans.GoodsSpecBean;
import com.zhkj.syyj.Beans.ShareImgBean;
import com.zhkj.syyj.Beans.SpecGoodsPriceBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.CustView.CustomProgressDialog;
import com.zhkj.syyj.CustView.GlideImageLoader;
import com.zhkj.syyj.CustView.LabelsView;
import com.zhkj.syyj.CustView.MeasureRelativeLayout;
import com.zhkj.syyj.CustView.MeasureTextView;
import com.zhkj.syyj.CustView.MyScrollView;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.CommonUtil;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.GoodsDetailContract;
import com.zhkj.syyj.presenter.GoodsDetailPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

public class GoodsDetailActivity extends AppCompatActivity implements View.OnClickListener, GoodsDetailContract.View {


    private NoScrollListView noScrollListView;
    private Context mContext;
    public int SelectNum=1;
    private ImageView img_appraise;
    private TextView tv_appraise_name;
    private MeasureTextView tv_appraise_content;
    private MeasureTextView tv_copywriting;
    private TextView tv_goodsTitle;
    private TextView tv_goodsMoney;
    private TextView tv_goodsVolume;
    private String goods_id;
    private String uid;
    private String token;
    private TextView tv_share;
    private Button tv_forward;
    private String shop_price;
    private String market_price;
    private TextView tv_market_price;
    private TextView tv_money;
    private List<SpecGoodsPriceBean> SpecGoodsPriceList=new ArrayList<>();
    private String key_name;
    private TextView tv_selectedNum;
    private TextView tv_select_num;
    private TextView tv_stock_num;
    private int store_count=0;
    private GoodsDetailPresenter goodsDetailPresenter;
    private int item_id=0;
    private MyScrollView scrollView;
    private MeasureRelativeLayout rl_appraise;
    private MeasureRelativeLayout rl_official;
    private int rl_appraiseHeight;
    private int rl_officialHeight;
    private int appraiseContentHeight;
    private int copywritingHeight;
    private BannerLayout bannerLayout;
    //轮播图
    final List<String> urls = new ArrayList<>();
    private CustomProgressDialog progressDialog;
    private List<GoodsDetailBean.DataBean.GoodsImagesBean> goods_images=new ArrayList<>();
    private WebView webview;
    private String webUrl="file:///android_asset/EmptyView.html";
    private NoScrollListView dtl_nolistview;
    private List<GoodsSpecBean.SpecBean> specList=new ArrayList<>();
    private int OneType;
    private int TwoType;
    private int ThreeType;
    private int FourType;
    private int FiveType;
    private int isCollect=0;
    private ImageView img_collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        mContext = getApplicationContext();
        InitUI();
        if (progressDialog == null){
            progressDialog = CustomProgressDialog.createDialog(this);
        }
        progressDialog.show();
        goodsDetailPresenter = new GoodsDetailPresenter(this);
        goodsDetailPresenter.GetGoodsDetail(uid,token,goods_id);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        goodsDetailPresenter.GetGoodsDetail(uid,token,goods_id);
    }

    @SuppressLint("JavascriptInterface")
    private void InitUI() {
        webview = findViewById(R.id.goods_detail_web_goods_content);
        webview.loadUrl(webUrl);
        //设置可自由缩放网页、JS生效
        WebSettings webSettings = webview.getSettings();
        //1. 设置于JS交互的权限
        webSettings.setJavaScriptEnabled(true);
        //2. 将Java对象映射到JS对象
        webview.addJavascriptInterface(GoodsDetailActivity.this, "jsObject");
        bannerLayout = findViewById(R.id.goods_detail_banner);
        bannerLayout.setAutoPlay(true);
        bannerLayout.setImageLoader(new GlideImageLoader());
        //添加点击监听
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        tv_forward = findViewById(R.id.goods_detail_tv_forward);
        tv_forward.setOnClickListener(this);
        findViewById(R.id.goods_detail_img_back).setOnClickListener(this);
        findViewById(R.id.goods_img_call_center).setOnClickListener(this);
        findViewById(R.id.goods_detail_img_home).setOnClickListener(this);
        findViewById(R.id.goods_detail_btn_redeem_now).setOnClickListener(this);
        findViewById(R.id.goods_detail_tv_view_all_appraise).setOnClickListener(this);
        findViewById(R.id.goods_detail_btn_buynow).setOnClickListener(this);
        findViewById(R.id.goods_detail_img_collectGoods).setOnClickListener(this);
        img_collect = findViewById(R.id.goods_detail_img_collectGoods);
        scrollView = findViewById(R.id.goods_detail_scrollView);
        img_appraise = findViewById(R.id.goods_detail_img_appraise);
        tv_appraise_name = findViewById(R.id.goods_detail_tv_appraise_name);
        tv_appraise_content = findViewById(R.id.goods_detail_tv_appraise_content);
        tv_copywriting = findViewById(R.id.goods_detail_tv_copywriting);
        tv_goodsTitle = findViewById(R.id.goods_detail_tv_goodsTitle);
        tv_goodsMoney = findViewById(R.id.goods_detail_tv_goodsMoney);
        tv_goodsVolume = findViewById(R.id.goods_detail_tv_goodsVolume);
        tv_share = findViewById(R.id.goods_detail_tv_share);
        rl_appraise = findViewById(R.id.goods_detail_rl_appraise);
        rl_official = findViewById(R.id.goods_detail_rl_official);
        rl_appraiseHeight = rl_appraise.getViewHeight(rl_appraise);
        rl_officialHeight = rl_official.getViewHeight(rl_official);
        appraiseContentHeight = tv_appraise_content.getViewHeight(tv_appraise_content);
        copywritingHeight = tv_copywriting.getViewHeight(tv_copywriting);
        scrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {
                int viewHeight = tv_appraise_content.getViewHeight(tv_appraise_content);
                int viewHeight1 = tv_copywriting.getViewHeight(tv_copywriting);
                int oneHeight=rl_appraiseHeight+(viewHeight-appraiseContentHeight);
                int TwoHeight=rl_officialHeight+(viewHeight1-copywritingHeight);
//                Log.e("滑动距离",scrollY+"和"+oneHeight+"加"+rl_appraiseHeight);
//                Log.e("滑动距离ssss",scrollY+"和"+TwoHeight+"加"+rl_officialHeight);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goods_detail_img_back:
                finish();
                break;
            case R.id.goods_detail_img_collectGoods:
                goodsDetailPresenter.GetCollectGoods(uid,token,goods_id);
                break;
            case R.id.goods_detail_tv_view_all_appraise:
                Intent intent1 = new Intent(mContext, AppraiseActivity.class);
                intent1.putExtra("goods_id",goods_id);
                startActivity(intent1);
                break;
            case R.id.goods_detail_tv_forward:
                startActivity(new Intent(mContext,ForwardActivity.class));
                break;
            case R.id.goods_detail_btn_buynow:
                RedeemBuyNowDialog();
                break;
            case R.id.goods_detail_btn_redeem_now:
                RedeemNowDialog();
                break;
            case R.id.goods_img_call_center:
                startActivity(new Intent(mContext,CallCenterActivity.class));
                break;
            case R.id.goods_detail_img_home:
                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.putExtra("currentItems","0");
                startActivity(intent);
                break;
                default:
                    break;
        }
    }

    private void RedeemNowDialog() {
        try{
        final BottomDialog bottomDialog = new BottomDialog(this, R.style.ActionSheetDialogStyle);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_integral_detail, null);
        tv_select_num = inflate.findViewById(R.id.db_integral_dtl_tv_select_num);
        tv_selectedNum = inflate.findViewById(R.id.db_integral_dtl_tv_selectedNum);
        tv_stock_num = inflate.findViewById(R.id.db_integral_dtl_tv_stock_num);
        tv_money = inflate.findViewById(R.id.db_integral_dtl_tv_money);
        tv_market_price = inflate.findViewById(R.id.db_integral_dtl_tv_market_price);
        tv_market_price.setText("建议售价：¥ "+market_price);
        tv_money.setText("¥ "+shop_price);
        tv_selectedNum.setText("已选"+key_name+","+SelectNum+"件");
        tv_stock_num.setText("库存："+store_count+"");
            dtl_nolistview = inflate.findViewById(R.id.db_integral_dtl_nolistview);
            dtl_nolistview.setAdapter(new TypeAdapter());
        inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                //加入购物车
                if (item_id>0) {
                    if (SelectNum>0) {
                        goodsDetailPresenter.GetCartAdd(uid,token,goods_id,item_id+"",SelectNum+"");
                        bottomDialog.dismiss();
                    }else {
                        ToastUtils.showToast(mContext,"购买数量不能为0");
                    }
                }else {
                    ToastUtils.showToast(mContext,"请选择类别");
                }

            }
        });
        inflate.findViewById(R.id.db_integral_dtl_img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_tv_lesson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SelectNum>1){
                    SelectNum=--SelectNum;
                    tv_select_num.setText(SelectNum+"");
                    tv_selectedNum.setText("已选"+key_name+","+SelectNum+"件");
                }else {
                    ToastUtils.showToast(mContext,"换购数量不能小于1");
                }
            }
        });
        inflate.findViewById(R.id.db_integral_dtl_tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( SelectNum<store_count) {
                    SelectNum = ++SelectNum;
                    tv_select_num.setText(SelectNum + "");
                    tv_selectedNum.setText("已选" + key_name + "," + SelectNum + "件");
                }else {
                    ToastUtils.showToast(mContext,"库存不足");
                }
            }
        });
        bottomDialog.setContentView(inflate);
        bottomDialog.show();
    }catch (Exception e){}
    }

    //立即购买弹出窗
    public void  RedeemBuyNowDialog(){
        try {
            final BottomDialog bottomDialog = new BottomDialog(this, R.style.ActionSheetDialogStyle);
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_integral_detail, null);
            tv_select_num = inflate.findViewById(R.id.db_integral_dtl_tv_select_num);
            tv_selectedNum = inflate.findViewById(R.id.db_integral_dtl_tv_selectedNum);
            tv_stock_num = inflate.findViewById(R.id.db_integral_dtl_tv_stock_num);
            dtl_nolistview = inflate.findViewById(R.id.db_integral_dtl_nolistview);
            dtl_nolistview.setAdapter(new TypeAdapter());
            tv_money = inflate.findViewById(R.id.db_integral_dtl_tv_money);
            tv_market_price = inflate.findViewById(R.id.db_integral_dtl_tv_market_price);
            tv_market_price.setText("建议售价：¥ " + market_price);
            tv_money.setText("¥ " + shop_price);
            tv_selectedNum.setText("已选" + key_name + "," + SelectNum + "件");
            tv_stock_num.setText("库存：" + store_count + "");
            inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item_id>0) {
                        if (SelectNum>0) {
                            goodsDetailPresenter.GetCartAdd2(uid, token, goods_id, item_id + "", SelectNum + "", "buy_now");
                            bottomDialog.dismiss();
                        }else {
                            ToastUtils.showToast(mContext,"购买数量不能为0");
                        }
                    }else {
                        ToastUtils.showToast(mContext,"请选择类别");
                    }
                }
            });
            inflate.findViewById(R.id.db_integral_dtl_img_close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomDialog.dismiss();
                }
            });
            inflate.findViewById(R.id.db_integral_dtl_tv_lesson).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SelectNum > 1) {
                        SelectNum = --SelectNum;
                        tv_select_num.setText(SelectNum + "");
                        tv_selectedNum.setText("已选" + key_name + "," + SelectNum + "件");
                    } else {
                        ToastUtils.showToast(mContext, "换购数量不能小于1");
                    }
                }
            });
            inflate.findViewById(R.id.db_integral_dtl_tv_next).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (SelectNum < store_count) {
                        SelectNum = ++SelectNum;
                        tv_select_num.setText(SelectNum + "");
                        tv_selectedNum.setText("已选" + key_name + "," + SelectNum + "件");
                    } else {
                        ToastUtils.showToast(mContext, "库存不足");
                    }
                }
            });
            bottomDialog.setContentView(inflate);
            bottomDialog.show();
        }catch (Exception e){}
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void UpdateUI(int code, String msg, String data){
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
        parseJSONWithJSONObject(data);
    }

    private void parseJSONWithJSONObject(String jsonData){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonData);
            int is_share = jsonObject.getInt("is_share");
            String goods_content = jsonObject.getString("goods_content");
            String goods_name = jsonObject.getString("goods_name");
            shop_price = jsonObject.getString("shop_price");
            market_price = jsonObject.getString("market_price");
            String sales_sum= jsonObject.getString("sales_sum");
            String share_imgs = jsonObject.getString("share_imgs");
            isCollect = jsonObject.getInt("isCollect");
            String comment_statistics = jsonObject.getString("comment_statistics");
            JosnStatistics(comment_statistics);
            //轮播图
             urls.clear();
             ShareImgBean shareImgBean = new GsonBuilder().create().fromJson("{share_imgs:"+ share_imgs+"}", ShareImgBean.class);
             List<String> share_imgsList = shareImgBean.getShare_imgs();
             for (int a=0;a<share_imgsList.size();a++){
             urls.add(RequstUrlUtils.URL.HOST+share_imgsList.get(a));
             }
             if (urls.size()>0) {
                 bannerLayout.setViewUrls(urls);
             }
             //产品详情
            webview.loadUrl("javascript:callJS('"+goods_content+"')");
            tv_goodsTitle.setText(goods_name);
            tv_goodsMoney.setText("¥ "+ shop_price);
            tv_goodsVolume.setText("销量："+sales_sum);
            if (is_share==1){
                tv_share.setText("该商品支持转发卖货");
                tv_forward.setClickable(true);
                String share_content = jsonObject.getString("share_content");
                tv_copywriting.setText(share_content);
            }else {
                tv_share.setText("该商品不支持转发卖货");
                tv_forward.setClickable(false);
            }
            //规格详情
            String spec_goods_price = jsonObject.getString("spec_goods_price");
            JsonSpecGoodsPrice(spec_goods_price);
             //规格列表
            String spec = jsonObject.getString("spec");
            GoodsSpecBean goodsSpecBean = new GsonBuilder().create().fromJson("{spec:" + spec + "}", GoodsSpecBean.class);
            specList = goodsSpecBean.getSpec();
            for (int a = 0; a< specList.size(); a++){
                String name = specList.get(a).getName();
            }
            //是否收藏
            if (isCollect==0){
                img_collect.setImageResource(R.mipmap.icon_collect);
            }else if (isCollect==1){
                img_collect.setImageResource(R.mipmap.icon_collect_select);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //解析评论数据
    public void JosnStatistics(String data){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            String content = jsonObject.getString("content");
            String goods_rank = jsonObject.getString("goods_rank");
            String headimg = jsonObject.getString("headimg");
            String nickname = jsonObject.getString("nickname");
            tv_appraise_name.setText(nickname);
            tv_appraise_content.setText(content);
            Glide.with(mContext).load(RequstUrlUtils.URL.HOST+headimg).into(img_appraise);
            tv_appraise_name.setVisibility(View.VISIBLE);
            tv_appraise_content.setVisibility(View.VISIBLE);
            img_appraise.setVisibility(View.VISIBLE);
        }catch (Exception e){
            tv_appraise_name.setVisibility(View.GONE);
            tv_appraise_content.setVisibility(View.GONE);
            img_appraise.setVisibility(View.GONE);
        }

    }

    //解析产品规格列表
    public boolean JsonSpecGoodsPrice(String specGoodsPrice){
        try {
            SpecGoodsPriceList.clear();
            JSONArray   jsonArray = new JSONArray(specGoodsPrice);
            for (int i=0; i< jsonArray.length(); i++){
                 JSONObject jsonObject = jsonArray.getJSONObject(i);
                 int item_id = jsonObject.getInt("item_id");
                int goods_id = jsonObject.getInt("goods_id");
                String key = jsonObject.getString("key");
                String key_name = jsonObject.getString("key_name");
                String price = jsonObject.getString("price");
                String  market_price = jsonObject.getString("market_price");
                int store_count = jsonObject.getInt("store_count");
                String spec_img = jsonObject.getString("spec_img");
                SpecGoodsPriceBean specGoodsPriceBean = new SpecGoodsPriceBean(item_id, goods_id, key, key_name,market_price, price,store_count, spec_img);
                SpecGoodsPriceList.add(specGoodsPriceBean);
            }
             return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    //加入购物车返回事件
    public void  UpdateCartAdd(int code,String msg){
        ToastUtils.showToast(mContext,msg);
    }

    //立即购买返回事件
    public void UpdateCartBuy(int code,String msg,String content){
        if (code==1) {
            Intent intent = new Intent(mContext, PlaceOrderActivity.class);
            intent.putExtra("type","1");
            intent.putExtra("content", content);
            intent.putExtra("item_id", item_id + "");
            startActivity(intent);
        }else {
            ToastUtils.showToast(mContext,msg);
        }
    }

   //返回通知
    public void UpdateUI(int code,String msg){
        goodsDetailPresenter.GetGoodsDetail(uid,token,goods_id);
        ToastUtils.showToast(mContext,msg);
    }


    //选择规格适配器
    public class TypeAdapter extends  BaseAdapter{
        @Override
        public int getCount() {
            return specList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.goods_type, null);
            TextView tv_size = inflate.findViewById(R.id.goods_type_tv_size);
            tv_size.setText(specList.get(position).getName());
            final List<GoodsSpecBean.SpecBean.SpecItemBean> spec_item = specList.get(position).getSpec_item();
            LabelsView  labelsView = inflate.findViewById(R.id.goods_type_labels);
            labelsView.setMaxLines(0);
            labelsView.setLabels(spec_item, new LabelsView.LabelTextProvider<GoodsSpecBean.SpecBean.SpecItemBean>() {
                @Override
                public CharSequence getLabelText(TextView label, int position, GoodsSpecBean.SpecBean.SpecItemBean data) {
                    //根据data和position返回label需要显示的数据。
                    return data.getItem();
                }
            });
            //标签的点击监听
            labelsView.setOnLabelClickListener(new LabelsView.OnLabelClickListener() {
                @Override
                public void onLabelClick(TextView label, Object data, int positions) {
                    if (position==0){
                        OneType=spec_item.get(positions).getId();
                    }else if (position==1){
                        TwoType=spec_item.get(positions).getId();
                    }else if (position==2){
                        ThreeType=spec_item.get(positions).getId();
                    }else if (position==3){
                        FourType=spec_item.get(positions).getId();
                    }else if (position==4){
                        FiveType=spec_item.get(positions).getId();
                    }
                    SleItemType();
                }
            });
            return inflate;
        }
        public void SleItemType(){
            if (specList.size()==1){
                SltSpecGoods(OneType+"");
            }else if (specList.size()==2){
                SltSpecGoods(OneType+"_"+TwoType);
            }else if (specList.size()==3){
                SltSpecGoods(OneType+"_"+TwoType+"_"+ThreeType);
            }else if (specList.size()==4){
                SltSpecGoods(OneType+"_"+TwoType+"_"+ThreeType+"_"+FourType);
            }else if (specList.size()==5){
                SltSpecGoods(OneType+"_"+TwoType+"_"+ThreeType+"_"+FourType+"_"+FiveType);
            }
        }

        public void SltSpecGoods(String type){
            for (int a=0;a<SpecGoodsPriceList.size();a++){
                if (type.equals(SpecGoodsPriceList.get(a).getKey())){
                    key_name = SpecGoodsPriceList.get(a).getKey_name();
                    store_count = SpecGoodsPriceList.get(a).getStore_count();
                    item_id = SpecGoodsPriceList.get(a).getItem_id();
                    //label是被点击的标签，data是标签所对应的数据，position是标签的位置。
                    tv_selectedNum.setText("已选" + key_name + "," + SelectNum + "件");
                    tv_stock_num.setText("库存：" + store_count + "");
                    return ;
                }else {
                    tv_selectedNum.setText("已选" + "请选择"+ "," + SelectNum + "件");
                    tv_stock_num.setText("库存：" + store_count + "");
                }
                if (store_count > 0) {
                    SelectNum = 1;
                    tv_select_num.setText(SelectNum + "");
                } else {
                    SelectNum = 0;
                    tv_select_num.setText(SelectNum + "");
                }
            }
        }
    }
}
