package com.zhkj.syyj.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.SpecGoodsPriceBean;
import com.zhkj.syyj.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GridAdapter extends BaseAdapter {
    private final LayoutInflater layoutInflater;
    private Context mContext;
    List<SpecGoodsPriceBean> SpecGoodsPriceList;

    public GridAdapter(Context context,  List<SpecGoodsPriceBean> dataList){
        this.SpecGoodsPriceList=dataList;
        this.mContext=context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return SpecGoodsPriceList.size();
    }

    @Override
    public Object getItem(int position) {
        return SpecGoodsPriceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.gridview_item, null);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.gridview_item_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String text = SpecGoodsPriceList.get(position).getKey_name();
        if (position==0){
            holder.text.setBackgroundResource(R.color.text_efb134);
        }else {
            holder.text.setBackgroundResource(R.color.text_fdfdfd);
        }
        holder.text.setText(text);
        return convertView;
    }
    class ViewHolder {
        TextView text;
    }
}
