package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.zhkj.syyj.Activitys.ForwardActivity;
import com.zhkj.syyj.Activitys.PlaceOrderIntegralActivity;
import com.zhkj.syyj.Beans.IntegralGoodsDetailBean;
import com.zhkj.syyj.Beans.IntegralListBean;
import com.zhkj.syyj.Beans.PublicResultBean;
import com.zhkj.syyj.Beans.SecGoodsPriceSBean;
import com.zhkj.syyj.CustView.BottomDialog;
import com.zhkj.syyj.CustView.LabelsView;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class IntegralAdapter extends HelperRecyclerViewAdapter<IntegralListBean.DataBean> {
    private final String uid;
    private final String token;
    public Context context;
    private HelperRecyclerViewHolder viewHolder;
    private int SelectNum;
    private List<IntegralGoodsDetailBean.DataBean.SpecBean> specList=new ArrayList<>();
    private List<IntegralGoodsDetailBean.DataBean.SpecGoodsPriceBean> spec_goods_price=new ArrayList<>();
    private int OneType;
    private int TwoType;
    private int ThreeType;
    private int FourType;
    private int FiveType;
    private int item_id=0;
    private String key_name="";
    private int store_count;
    private TextView tv_selectedNum;
    private TextView tv_stock_num;
    private TextView tv_select_num;
    private IntegralGoodsDetailBean.DataBean data;

    public IntegralAdapter(Context context) {
        super(context, R.layout.list_integral);
        this.context=context;
        SharedPreferences share = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, IntegralListBean.DataBean item) {
        IntegralListBean.DataBean data = getData(position);
        ImageView list_integral_img = viewHolder.getView(R.id.list_integral_img);
        TextView tv_price = viewHolder.getView(R.id.list_integral_tv_price);
        TextView tv_title= viewHolder.getView(R.id.list_integral_tv_title);
        viewHolder.getView(R.id.list_integral_btn_redeem_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSpecGoodsPrice(data.getGoods_id());
            }
        });
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+data.getOriginal_img()).into(list_integral_img);
        tv_price.setText(data.getExchange_integral()+"");
        tv_title.setText(data.getGoods_name());

    }

    //获取产品规格及价格
    public void getSpecGoodsPrice(int goods_id){
        OkGo.<String>get(RequstUrlUtils.URL.IntegraDetail)
                .params("goods_id",goods_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        IntegralGoodsDetailBean secGoodsPriceSBean = new GsonBuilder().create().fromJson(response.body(), IntegralGoodsDetailBean.class);
                        if (secGoodsPriceSBean.getCode()==1){
                            data = secGoodsPriceSBean.getData();
                            specList = data.getSpec();
                            spec_goods_price = data.getSpec_goods_price();
                            key_name="";
                            item_id=0;
                            RedeemBuyNowDialog();
                        }
                    }
                });

    }

    //立即购买弹出窗
    public void  RedeemBuyNowDialog(){
        try {
            final BottomDialog bottomDialog = new BottomDialog(mContext, R.style.ActionSheetDialogStyle);
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom_integral_detail, null);
            tv_select_num = inflate.findViewById(R.id.db_integral_dtl_tv_select_num);
            tv_selectedNum = inflate.findViewById(R.id.db_integral_dtl_tv_selectedNum);
            tv_stock_num = inflate.findViewById(R.id.db_integral_dtl_tv_stock_num);
            NoScrollListView dtl_nolistview = inflate.findViewById(R.id.db_integral_dtl_nolistview);
            dtl_nolistview.setAdapter(new TypeAdapter());
            TextView   tv_money = inflate.findViewById(R.id.db_integral_dtl_tv_money);
            TextView  tv_market_price = inflate.findViewById(R.id.db_integral_dtl_tv_market_price);
            tv_market_price.setVisibility(View.GONE);
            tv_money.setText(" "+data.getExchange_integral());
            tv_selectedNum.setText("已选"+key_name+","+SelectNum+"件");
            tv_stock_num.setText("库存："+store_count+"");
            inflate.findViewById(R.id.db_integral_dtl_btn_confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item_id>0) {
                        if (SelectNum>0) {
                            bottomDialog.dismiss();
                            PostCardAdd2();
                        }else {
                            ToastUtils.showToast(mContext,"购买数量不能为0");
                        }
                    }else {
                        if (spec_goods_price.size()==0){
                            if (SelectNum>0) {
                                bottomDialog.dismiss();
                                PostCardAdd2();
                            }else {
                                ToastUtils.showToast(mContext,"购买数量不能为0");
                            }
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
            View inflate = inflateItemView(R.layout.goods_type, null);
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

    //立即购买
    public void  PostCardAdd2(){
        OkGo.<String>post(RequstUrlUtils.URL.BuyIntegralGoods)
                .params("uid",uid)
                .params("token",token)
                .params("goods_id",data.getGoods_id())
                .params("item_id",item_id)
                .params("goods_num",SelectNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        PublicResultBean publicResultBean = new GsonBuilder().create().fromJson(response.body(), PublicResultBean.class);
                        if (publicResultBean.getCode()==1) {
                            Intent intent = new Intent(mContext, PlaceOrderIntegralActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("content",response.body());
                            intent.putExtra("item_id", item_id + "");
                            mContext.startActivity(intent);
                        }else {
                            ToastUtils.showToast(mContext,publicResultBean.getMsg());
                        }
                    }
                });
    }
}
