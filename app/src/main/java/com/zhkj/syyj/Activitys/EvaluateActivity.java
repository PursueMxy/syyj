package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Beans.LiteCollectBean;
import com.zhkj.syyj.Beans.LiteCommentBean;
import com.zhkj.syyj.Beans.OrderDetailBean;
import com.zhkj.syyj.CustView.NoScrollListView;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.Utils.RequstUrlUtils;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.EvaluateContract;
import com.zhkj.syyj.presenter.EvaluatePresenter;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class EvaluateActivity extends AppCompatActivity implements View.OnClickListener, EvaluateContract.View {

    private NoScrollListView evaluate_listview;
    private MyAdapter myAdapter;
    private String order_id;
    private List<OrderDetailBean.DataBean.OrderGoodsBean> order_goods=new ArrayList<>();
    private EvaluatePresenter evaluatePresenter;
    private String uid;
    private String token;
    private Context mContext;
    private List<LiteCommentBean> commentBeanList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
        InitUI();
        evaluatePresenter = new EvaluatePresenter(this);
        evaluatePresenter.GetOrderDetail(uid,token,order_id);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        evaluatePresenter.GetOrderDetail(uid,token,order_id);
    }

    private void InitUI() {
        evaluate_listview = findViewById(R.id.evaluate_listview);
        findViewById(R.id.evaluate_btn_confirm).setOnClickListener(this);
        findViewById(R.id.evaluate_img_back).setOnClickListener(this);
        myAdapter = new MyAdapter();
        evaluate_listview.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.evaluate_img_back:
                finish();
                break;
            case R.id.evaluate_btn_confirm:
                commentBeanList = LitePal.findAll(LiteCommentBean.class);
                String content = new GsonBuilder().create().toJson(commentBeanList);
                evaluatePresenter.GetOrderAddComment(uid,token,order_id,content);
                break;
                default:
                    break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return order_goods.size();
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
            View inflate = getLayoutInflater().inflate(R.layout.list_evaluate, null);
            ImageView  img= inflate.findViewById(R.id.list_evaluate_img);
            TextView tv_title = inflate.findViewById(R.id.list_evaluate_tv_title);
            TextView tv_price = inflate.findViewById(R.id.list_evaluate_tv_price);
            TextView tv_sn = inflate.findViewById(R.id.list_evaluate_tv_sn);
            EditText edt_evaluate = (EditText)inflate.findViewById(R.id.list_evaluate_edt_content);
            Glide.with(mContext).load(RequstUrlUtils.URL.HOST+order_goods.get(position).getOriginal_img()).into(img);
            tv_title.setText(order_goods.get(position).getGoods_name());
            tv_price.setText("¥："+order_goods.get(position).getGoods_price());
            tv_sn.setText(order_goods.get(position).getSpec_key_name());
            RadioGroup radioGroup = inflate.findViewById(R.id.list_evaluate_radioGroup);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case R.id.list_evaluate_radioBtn_praise:
                            LiteCommentBean liteCommentBean = new LiteCommentBean();
                            liteCommentBean.setGoods_rank("1");
                            liteCommentBean.updateAll("goods_id="+order_goods.get(position).getGoods_id());
                            break;
                        case R.id.list_evaluate_radioBtn_middle:
                            LiteCommentBean liteCommentBean1 = new LiteCommentBean();
                            liteCommentBean1.setGoods_rank("2");
                            liteCommentBean1.updateAll("goods_id="+order_goods.get(position).getGoods_id());
                            break;
                        case R.id.list_evaluate_radioBtn_difference:
                            LiteCommentBean liteCommentBean2 = new LiteCommentBean();
                            liteCommentBean2.setGoods_rank("3");
                            liteCommentBean2.updateAll("goods_id="+order_goods.get(position).getGoods_id());
                            break;
                    }
                }
            });
            edt_evaluate.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String contnet = edt_evaluate.getText().toString();
                    LiteCommentBean liteCommentBean = new LiteCommentBean();
                    liteCommentBean.setContent(contnet);
                    liteCommentBean.updateAll("goods_id="+order_goods.get(position).getGoods_id());
                }
            });
            return inflate;
        }
    }

    //数据解析
    public void  UpdateJson(int code, String msg, OrderDetailBean.DataBean data){
        if (code==1){
            OrderDetailBean.DataBean.OrderStatusDetailBean order_status_detail = data.getOrder_status_detail();
            order_goods = data.getOrder_goods();
            LitePal.deleteAll(LiteCommentBean.class);
            for (int a=0;a<order_goods.size();a++){
                LiteCommentBean liteCommentBean = new LiteCommentBean();
                liteCommentBean.setGoods_id(order_goods.get(a).getGoods_id());
                liteCommentBean.setGoods_rank("1");
                liteCommentBean.setContent("");
                liteCommentBean.save();
            }
            myAdapter.notifyDataSetChanged();

        }
    }

    //
    public void UpdateUI(int code, String msg){
        if (code==1){
            Intent intent = new Intent(mContext, MyOrderActivity.class);
            intent.putExtra("title","已完成");
            startActivity(intent);
            finish();
        }else {
            ToastUtils.showToast(mContext,msg);
        }
    }

}
