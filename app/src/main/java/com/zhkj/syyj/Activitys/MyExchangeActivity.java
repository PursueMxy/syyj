package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Adapters.MyOrderAdapter;
import com.zhkj.syyj.Beans.OrderListBean;
import com.zhkj.syyj.Beans.ShoppingCarDataBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.contract.MyExchangeContract;
import com.zhkj.syyj.presenter.MyExchangePresenter;

import java.util.ArrayList;
import java.util.List;

public class MyExchangeActivity extends AppCompatActivity implements View.OnClickListener, MyExchangeContract.View {
    private RadioButton radiobutton_whole;
    private RadioButton radiobutton_confirm;
    private RadioButton radiobutton_to_bo_received;
    private RadioButton radiobutton_to_bo_shipped;
    private ExpandableListView elvShoppingCar;
    private Context mContext;
    private MyOrderAdapter myOrderAdapter;
    private List<OrderListBean.DataBean> datas=new ArrayList<>();
    private MyExchangePresenter myExchangePresenter;
    private String uid;
    private String token;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_exchange);
        mContext = getApplicationContext();
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        Intent intent = getIntent();
        type=intent.getStringExtra("type");
        InitUI();
        initExpandableListView();
        initData();
        myExchangePresenter = new MyExchangePresenter(this);
        myExchangePresenter.GetMyExchange(uid, token, type, 0, 1);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        myExchangePresenter.GetMyExchange(uid, token, type, 0, 1);
    }

    private void InitUI() {
        findViewById(R.id.my_exchange_img_back).setOnClickListener(this);
        elvShoppingCar = findViewById(R.id.my_exchange_elv_shopping_car);
        RadioGroup my_exchange_radioGroup= findViewById(R.id.my_exchange_radioGroup);
        radiobutton_whole = findViewById(R.id.my_exchange_radiobutton_whole);
        radiobutton_to_bo_shipped = findViewById(R.id.my_exchange_radiobutton_to_bo_shipped);
        radiobutton_to_bo_received = findViewById(R.id.my_exchange_radiobutton_to_bo_received);
        radiobutton_confirm = findViewById(R.id.my_exchange_radiobutton_confirm);
        my_exchange_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.my_exchange_radiobutton_to_bo_shipped:
                        type="WAITSEND";
                        myExchangePresenter.GetMyExchange(uid, token, type, 0, 1);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_exchange_radiobutton_to_bo_received:
                        type="WAITRECEIVE";
                        myExchangePresenter.GetMyExchange(uid, token, type, 0, 1);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_exchange_radiobutton_whole:
                        type="";
                        myExchangePresenter.GetMyExchange(uid, token, type, 0, 1);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_exchange_radiobutton_confirm:
                        type="FINISH";
                        myExchangePresenter.GetMyExchange(uid, token, type, 0, 1);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_efb134));
                        break;
                    default:
                        break;

                }
            }
        });
        RadioGroupUI();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //使用Gson解析购物车数据，
        //ShoppingCarDataBean为bean类，Gson按照bean类的格式解析数据

        initExpandableListViewData(datas);
    }

    /**
     * 初始化ExpandableListView
     * 创建数据适配器adapter，并进行初始化操作
     */
    private void initExpandableListView() {
        myOrderAdapter = new MyOrderAdapter(MyExchangeActivity.this);

        elvShoppingCar.setAdapter(myOrderAdapter);
        elvShoppingCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("点击事件",position+"加"+id);
//                startActivity(new Intent(mContext,OrderDetailActivity.class));
            }
        });
    }

    /**
     * 初始化ExpandableListView的数据
     * 并在数据刷新时，页面保持当前位置
     *
     * @param datas 购物车的数据
     */
    private void initExpandableListViewData(List<OrderListBean.DataBean> datas) {
        if (datas != null && datas.size() > 0) {
            //刷新数据时，保持当前位置
            myOrderAdapter.setData(datas);

            //使所有组展开
            for (int i = 0; i < myOrderAdapter.getGroupCount(); i++) {
                elvShoppingCar.expandGroup(i);
            }

            //使组点击无效果（true）
            elvShoppingCar.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
//                    Log.e("点击事件",groupPosition+"加"+id);
                    return true;
                }
            });

            elvShoppingCar.setVisibility(View.VISIBLE);
        } else {
            elvShoppingCar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_exchange_img_back:
                finish();
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

    //解析数据
    public void UpdateJson(int code,String msg,String data) {
        datas.clear();
        if (code == 1) {
            OrderListBean orderListBean = new GsonBuilder().create().fromJson(data, OrderListBean.class);
            datas = orderListBean.getData();
        }
        initExpandableListViewData(datas);
        myOrderAdapter.notifyDataSetChanged();
        myOrderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void RadioGroupUI() {
       if (type.equals("WAITSEND")){
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
        else if (type.equals("WAITRECEIVE")){
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
        else if (type.equals("FINISH")){
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_efb134));
        }
        else {
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
    }
}
