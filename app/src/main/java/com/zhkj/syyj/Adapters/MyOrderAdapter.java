package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Activitys.OrderDetailActivity;
import com.zhkj.syyj.Beans.OrderBean;
import com.zhkj.syyj.Beans.OrderListBean;
import com.zhkj.syyj.Beans.ShoppingCarDataBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderAdapter extends BaseExpandableListAdapter {

    private final Context mContext;
    private List<OrderListBean.DataBean> data=new ArrayList<>();
    private boolean isSelectAll = false;
    private double total_price;

    public MyOrderAdapter(Context context) {
        this.mContext = context;

    }

    /**
     * 自定义设置数据方法；
     * 通过notifyDataSetChanged()刷新数据，可保持当前位置
     *
     * @param data 需要刷新的数据
     */
    public void setData(List<OrderListBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        if (data != null && data.size() > 0) {
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (data.get(groupPosition).getOrder_goods() != null && data.get(groupPosition).getOrder_goods() .size() > 0) {
            return data.get(groupPosition).getOrder_goods() .size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getOrder_goods() .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.myorder_item_top, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tv_typename.setText(data.get(groupPosition).getOrder_status_detail().getName());
        groupViewHolder.tv_orderNumeber.setText(data.get(groupPosition).getOrder_sn());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("order_id",data.get(groupPosition).getOrder_id()+"");
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.myorder_item_detail, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        final OrderListBean.DataBean datasBean = data.get(groupPosition);
        if (childPosition==(datasBean.getOrder_goods().size()-1)){
            childViewHolder.myorder_item_bottom_rl.setVisibility(View.VISIBLE);
        }else {
            childViewHolder.myorder_item_bottom_rl.setVisibility(View.GONE);
        }
        OrderListBean.DataBean.OrderStatusDetailBean order_status_detail = datasBean.getOrder_status_detail();
        if (order_status_detail.getStatus()==0){
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_obligation.setVisibility(View.VISIBLE);
        }else if(order_status_detail.getStatus()==1){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
        }else if(order_status_detail.getStatus()==2){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.VISIBLE);
        }else if (order_status_detail.getStatus()==3){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.VISIBLE);
        }else if (order_status_detail.getStatus()==4){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.VISIBLE);
        } else if (order_status_detail.getStatus()==5){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.VISIBLE);
        }else if (order_status_detail.getStatus()==6){
            childViewHolder.ll_obligation.setVisibility(View.GONE);
            childViewHolder.ll_tobe_received.setVisibility(View.GONE);
            childViewHolder.ll_cancel_order.setVisibility(View.GONE);
            childViewHolder.ll_orderDone.setVisibility(View.VISIBLE);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("order_id",data.get(groupPosition).getOrder_id()+"");
                mContext.startActivity(intent);
            }
        });
        childViewHolder.tv_title.setText(datasBean.getOrder_goods().get(childPosition).getGoods_name());
        childViewHolder.tv_num.setText("X"+datasBean.getOrder_goods().get(childPosition).getGoods_num());
        childViewHolder.tv_model.setText(datasBean.getOrder_goods().get(childPosition).getSpec_key_name());
        childViewHolder.tv_price.setText("¥ "+datasBean.getOrder_goods().get(childPosition).getGoods_price());
        childViewHolder.tv_goods_num.setText("共"+datasBean.getCount_goods_num()+"件商品，");
        childViewHolder.tv_total_amount.setText("¥"+datasBean.getTotal_amount());
        Glide.with(mContext).load(RequstUrlUtils.URL.HOST+datasBean.getOrder_goods().get(childPosition).getOriginal_img()).into(childViewHolder.img_item);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder {
        @BindView(R.id.myorder_item_top_tv_typename)
                TextView tv_typename;
        @BindView(R.id.myorder_item_orderNumber)
                TextView tv_orderNumeber;
        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        //产品图片
        @BindView(R.id.myorder_item_detail_img)
        ImageView img_item;
        @BindView(R.id.myorder_item_detail_tv_title)
        TextView tv_title;
        @BindView(R.id.myorder_item_detail_tv_price)
        TextView tv_price;
        @BindView(R.id.myorder_item_detail_tv_model)
        TextView tv_model;
        @BindView(R.id.myorder_item_detail_tv_num)
        TextView tv_num;
         @BindView(R.id.item_shopping_tv_goods_num)
         TextView tv_goods_num;
         @BindView(R.id.item_shopping_tv_goods_total_amount)
         TextView tv_total_amount;
        @BindView(R.id.myorder_item_bottom_rl)
         RelativeLayout myorder_item_bottom_rl;
        @BindView(R.id.item_shopping_ll_obligation)
        LinearLayout ll_obligation;
        @BindView(R.id.item_shopping_ll_cancel_order)
        LinearLayout ll_cancel_order;
        @BindView(R.id.item_shopping_ll_tobe_received)
        LinearLayout ll_tobe_received;
        @BindView(R.id.item_shopping_ll_orderDone)
        LinearLayout ll_orderDone;
        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
