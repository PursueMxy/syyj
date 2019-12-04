package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhkj.syyj.Activitys.GoodsListActivity;
import com.zhkj.syyj.Beans.CategoryListBean;
import com.zhkj.syyj.Beans.GoodsListBean;
import com.zhkj.syyj.CustView.CircleImageView;
import com.zhkj.syyj.CustView.MyGridView;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FmShopAdapter extends HelperRecyclerViewAdapter<CategoryListBean.DataBean.TmenuBean> {
    private final LayoutInflater layoutInflater;
    public Context context;
    private List<CategoryListBean.DataBean.TmenuBean.SubMenuBean> sub_menu=new ArrayList<>();

    public FmShopAdapter(Context context) {
        super(context, R.layout.list_right_item);
        this.context=context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, final int position, CategoryListBean.DataBean.TmenuBean item) {
        MyGridView item_type_grid = viewHolder.getView(R.id.list_right_item_grid);
        TextView tv_type_name= viewHolder.getView(R.id.list_right_item_tv_type_name);
        tv_type_name.setText(item.getName());
        sub_menu = item.getSub_menu();
        MyAdapter myAdapter = new MyAdapter();
        item_type_grid.setAdapter(myAdapter);
        item_type_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, GoodsListActivity.class);
                intent.putExtra("id",sub_menu.get(position).getId()+"");
                intent.putExtra("name",sub_menu.get(position).getName());
                mContext.startActivity(intent);
            }
        });

    }


    public class  MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return sub_menu.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = layoutInflater.inflate(R.layout.list_right_item_gride, null);
            TextView tv_name = inflate.findViewById(R.id.list_right_item_tv_name);
            tv_name.setText(sub_menu.get(position).getName());
            ImageView img_name = inflate.findViewById(R.id.list_right_item_img_name);
            Glide.with(mContext).load(RequstUrlUtils.URL.HOST+sub_menu.get(position).getImage()).into(img_name);
            return inflate;
        }
    }

}
