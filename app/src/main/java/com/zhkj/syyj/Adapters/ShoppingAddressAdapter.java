package com.zhkj.syyj.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.zhkj.syyj.Activitys.ShoppingAddressActivity;
import com.zhkj.syyj.Activitys.ShoppingAddressUpdateActivity;
import com.zhkj.syyj.Beans.AddressListBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.lang.ref.WeakReference;

public class ShoppingAddressAdapter extends HelperRecyclerViewAdapter<AddressListBean.DataBean> {
    public Context context;
    public WeakReference<Activity> weak;
    public ShoppingAddressAdapter(Context context) {
        super(context, R.layout.list_shopping_address);
        this.context=context;
        this.weak = new WeakReference<Activity>((Activity) context);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, AddressListBean.DataBean item) {
        final AddressListBean.DataBean data = getData(position);
        viewHolder.getView(R.id.list_shopping_address_tv_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShoppingAddressUpdateActivity.class);
                intent.putExtra("address_id",data.getAddress_id()+"");
                intent.putExtra("user_id",data.getUser_id()+"");
                intent.putExtra("consignee",data.getConsignee());
                intent.putExtra("province",data.getProvince());
                intent.putExtra("city",data.getCity());
                intent.putExtra("district",data.getDistrict());
                intent.putExtra("address",data.getAddress());
                intent.putExtra("zipcode",data.getZipcode());
                intent.putExtra("mobile",data.getMobile());
                intent.putExtra("is_default",data.getIs_default()+"");
                context.startActivity(intent);
            }
        });
        viewHolder.getView(R.id.list_shopping_address_tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingAddressActivity shoppingAddressActivity=(ShoppingAddressActivity)weak.get();
                shoppingAddressActivity.DleAddress(data.getAddress_id()+"");

            }
        });
       TextView tv_address= viewHolder.getView(R.id.list_shopping_address_tv_address);
       TextView tv_name = viewHolder.getView(R.id.list_shopping_address_tv_name);
       TextView tv_default= viewHolder.getView(R.id.list_shopping_address_tv_default);
        CheckBox cb_default = viewHolder.getView(R.id.list_shopping_address_cb_default);
        tv_address.setText(data.getProvince()+data.getCity()+data.getDistrict()+data.getTwon()+data.getAddress());
        tv_name.setText(data.getConsignee()+"  "+data.getMobile());
        if (data.getIs_default()==1){
            cb_default.setChecked(true);
        }else {
            cb_default.setChecked(false);
        }
    }
}
