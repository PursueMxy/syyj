package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.yyydjk.library.BannerLayout;
import com.zhkj.syyj.Adapters.GridAdapter;
import com.zhkj.syyj.Beans.BuyIntegralGoodsBean;
import com.zhkj.syyj.Beans.GoodsSpecBean;
import com.zhkj.syyj.Beans.IntegralGoodsDetailBean;
import com.zhkj.syyj.Beans.SpecGoodsPriceBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.CustView.CircleImageView;
import com.zhkj.syyj.CustView.GlideImageLoader;
import com.zhkj.syyj.CustView.LabelsView;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.IntegralGoodsDetailContract;
import com.zhkj.syyj.presenter.IntegralGoodsDetailPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntegralGoodsDetailActivity extends AppCompatActivity implements IntegralGoodsDetailContract.View {

    @BindView(R.id.integral_detail_goods_web_goods_content)
    WebView webview;
    @BindView(R.id.integral_detail_goods_tv_forward)
    TextView tv_forward;
    @BindView(R.id.integral_detail_goods_img_appraise)
    CircleImageView img_appraise;
    private Context mContext;
    public int SelectNum=1;
    private TextView tv_goodsTitle;
    private TextView tv_goodsMoney;
    private TextView tv_goodsVolume;
    private TextView tv_copywriting;
    private TextView tv_appraise_name;
    private TextView tv_appraise_content;
    private IntegralGoodsDetailPresenter integralGoodsDetailPresenter;
    private String token;
    private String uid;
    private String goods_id;
    private String webUrl="file:///android_asset/EmptyView.html";
    private BannerLayout bannerLayout;
    //轮播图
    final List<String> urls = new ArrayList<>();
    private List<IntegralGoodsDetailBean.DataBean.SpecGoodsPriceBean> spec_goods_price=new ArrayList<>();
    private List<IntegralGoodsDetailBean.DataBean.SpecBean> specList=new ArrayList<>();
    private int OneType;
    private int TwoType;
    private int ThreeType;
    private int FourType;
    private int FiveType;
    private String key_name;
    private int store_count;
    private int item_id=0;
    private TextView tv_select_num;
    private TextView tv_selectedNum;
    private TextView tv_stock_num;
    private NoScrollListView dtl_nolistview;
    private int exchange_integral;
    private TextView tv_forwardName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral_goods_detail);
        mContext = getApplicationContext();
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        ButterKnife.bind(this);
        SharedPreferences share = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        integralGoodsDetailPresenter = new IntegralGoodsDetailPresenter(this);
        integralGoodsDetailPresenter.GetIntegraDetail(uid,token,goods_id);
    }

    @SuppressLint("JavascriptInterface")
    private void InitUI() {
        webview.loadUrl(webUrl);
        //设置可自由缩放网页、JS生效
        WebSettings webSettings = webview.getSettings();
        //1. 设置于JS交互的权限
        webSettings.setJavaScriptEnabled(true);
        //2. 将Java对象映射到JS对象
        webview.addJavascriptInterface(IntegralGoodsDetailActivity.this, "jsObject");
        tv_goodsTitle = findViewById(R.id.integral_detail_goods_tv_goodsTitle);
        tv_goodsMoney = findViewById(R.id.integral_detail_goods_tv_goodsMoney);
        tv_goodsVolume = findViewById(R.id.integral_detail_goods_tv_goodsVolume);
        tv_copywriting = findViewById(R.id.integral_detail_goods_tv_copywriting);
        tv_appraise_name = findViewById(R.id.integral_detail_goods_tv_appraise_name);
        tv_forwardName = findViewById(R.id.integral_detail_goods_tv_forwardName);
        tv_appraise_content = findViewById(R.id.integral_detail_goods_tv_appraise_content);
        bannerLayout = findViewById(R.id.integral_detail_goods_banner);
        bannerLayout.setAutoPlay(true);
        bannerLayout.setImageLoader(new GlideImageLoader());
        //添加点击监听
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
    }


    @OnClick({R.id.integral_detail_goods_img_back,R.id.integral_btn_redeem_now,R.id.integral_detail_goods_tv_forward,
    R.id.integral_detail_goods_img_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.integral_detail_goods_img_back:
                finish();
                break;
            case R.id.integral_btn_redeem_now:
                RedeemNowDialog();
                break;
            case R.id.integral_detail_goods_tv_forward:
                startActivity(new Intent(mContext,ForwardActivity.class));
                break;
            case R.id.integral_detail_goods_img_home:
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
            TextView tv_money = inflate.findViewById(R.id.db_integral_dtl_tv_money);
            TextView tv_market_price = inflate.findViewById(R.id.db_integral_dtl_tv_market_price);
            tv_market_price.setVisibility(View.GONE);
            tv_money.setText(" "+exchange_integral);
            tv_selectedNum.setText("已选"+key_name+","+SelectNum+"件");
            tv_stock_num.setText("库存："+store_count+"");
            dtl_nolistview = inflate.findViewById(R.id.db_integral_dtl_nolistview);
            dtl_nolistview.setAdapter(new TypeAdapter());
            inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomDialog.dismiss();
                    if (item_id>0) {
                        if (SelectNum>0) {
                            integralGoodsDetailPresenter.GetBuyIntegralGoods(uid,token,goods_id,item_id,SelectNum);
                            bottomDialog.dismiss();
                        }else {
                            ToastUtils.showToast(mContext,"购买数量不能为0");
                        }
                    }else {
                        if (specList.size()==0){
                            integralGoodsDetailPresenter.GetBuyIntegralGoods(uid,token,goods_id,item_id,SelectNum);
                        }else {
                            ToastUtils.showToast(mContext, "请选择类别");
                        }
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

   public void UpdateUI(int code,String msg, IntegralGoodsDetailBean.DataBean data){
       //产品详情
       webview.loadUrl("javascript:callJS('"+data.getGoods_content()+"')");
       List<IntegralGoodsDetailBean.DataBean.GoodsImagesBean> goods_images = data.getGoods_images();
       for (int a=0;a<goods_images.size();a++){
           urls.add(RequstUrlUtils.URL.HOST+goods_images.get(a).getImage_url());
       }
       if (urls.size()>0) {
           bannerLayout.setViewUrls(urls);
       }
       specList = data.getSpec();
       spec_goods_price = data.getSpec_goods_price();
       exchange_integral = data.getExchange_integral();
       tv_goodsTitle.setText(data.getGoods_name());
       tv_goodsMoney.setText(data.getExchange_integral()+"");
       if (data.getIsCollect()==1){
           tv_forward.setClickable(true);
           tv_forwardName.setText("该商品支持转发卖货");
       }else {
           tv_forward.setClickable(false);
           tv_forwardName.setText("该商品不支持转发卖货");
       }
       tv_goodsVolume.setText("销量："+data.getSales_sum());
       tv_copywriting.setText("");
       img_appraise.setVisibility(View.GONE);
       tv_appraise_content.setVisibility(View.GONE);
       tv_appraise_name.setVisibility(View.GONE);
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
            List<IntegralGoodsDetailBean.DataBean.SpecBean.SpecItemBean> spec_item = specList.get(position).getSpec_item();
            LabelsView  labelsView = inflate.findViewById(R.id.goods_type_labels);
            labelsView.setMaxLines(0);
            labelsView.setLabels(spec_item, new LabelsView.LabelTextProvider<IntegralGoodsDetailBean.DataBean.SpecBean.SpecItemBean>() {
                @Override
                public CharSequence getLabelText(TextView label, int position, IntegralGoodsDetailBean.DataBean.SpecBean.SpecItemBean data) {
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

            for (int a=0;a<spec_goods_price.size();a++){
                if (type.equals(spec_goods_price.get(a).getKey())){
                    key_name = spec_goods_price.get(a).getKey_name();
                    store_count = spec_goods_price.get(a).getStore_count();
                    item_id = spec_goods_price.get(a).getItem_id();
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

    //立即兑换返回
    public void UpdateBuyIntegralGoods(int code, String msg, String content ){
        if (code==1){
            Intent intent = new Intent(mContext, PlaceOrderIntegralActivity.class);
            intent.putExtra("content", content);
            intent.putExtra("item_id", item_id + "");
            startActivity(intent);
        }else {
            ToastUtils.showToast(mContext,msg);
        }

    }

}
