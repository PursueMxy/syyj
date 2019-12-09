package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhkj.syyj.Adapters.MyOrderAdapter;
import com.zhkj.syyj.Beans.OrderListBean;
import com.zhkj.syyj.Beans.ShoppingCarDataBean;
import com.zhkj.syyj.CustView.RoundCornerDialog;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.ToastUtils;
import com.zhkj.syyj.contract.MyOrderContract;
import com.zhkj.syyj.presenter.MyOrderPresenter;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener, MyOrderContract.View {



    private List<OrderListBean.DataBean> datas=new ArrayList<>();
    private Context mContext;
    private MyOrderAdapter myOrderAdapter;
    private RadioButton radiobutton_whole;
    private RadioButton radiobutton_confirm;
    private RadioButton radiobutton_to_bo_received;
    private RadioButton radiobutton_to_bo_shipped;
    private RadioButton radiobutton_obligation;
    private ExpandableListView elvShoppingCar;
    private  ImageView ivNoContant;
    private  RelativeLayout rlNoContant;
    private String titleName;
    private MyOrderPresenter myOrderPresenter;
    private String uid;
    private String token;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        SharedPreferences share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uid = share.getString("uid", "");
        token = share.getString("token", "");
        mContext = this;
        myOrderPresenter = new MyOrderPresenter(this);
        Intent intent = getIntent();
        titleName = intent.getStringExtra("title");
        InitUI();
        initExpandableListView();
        initData();
        if (titleName.equals("全部")) {
            myOrderPresenter.GetMyOrder(uid, token, "", 0, 0);
        }else if (titleName.equals("待付款")){
            myOrderPresenter.GetMyOrder(uid, token, "WAITPAY", 0, 0);
        }else if (titleName.equals("待发货")){
            myOrderPresenter.GetMyOrder(uid, token, "WAITSEND", 0, 0);
        }else if (titleName.equals("待收货")){
            myOrderPresenter.GetMyOrder(uid, token, "WAITRECEIVE", 0, 0);
        }else if (titleName.equals("已完成")){
            myOrderPresenter.GetMyOrder(uid, token, "FINISH", 0, 0);
        }
    }

    private void InitUI() {
        findViewById(R.id.my_order_img_back).setOnClickListener(this);
        elvShoppingCar = findViewById(R.id.elv_shopping_car);
        RadioGroup my_order_radioGroup= findViewById(R.id.my_order_radioGroup);
        radiobutton_whole = findViewById(R.id.my_order_radiobutton_whole);
        radiobutton_obligation = findViewById(R.id.my_order_radiobutton_obligation);
        radiobutton_to_bo_shipped = findViewById(R.id.my_order_radiobutton_to_bo_shipped);
        radiobutton_to_bo_received = findViewById(R.id.my_order_radiobutton_to_bo_received);
        radiobutton_confirm = findViewById(R.id.my_order_radiobutton_confirm);
        rlNoContant= findViewById(R.id.my_order_rl_no_contant);
        ivNoContant = findViewById(R.id.my_order_iv_no_contant);
        my_order_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.my_order_radiobutton_whole:
                        datas.clear();
                        myOrderPresenter.GetMyOrder(uid, token, "", 0, 0);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_order_radiobutton_obligation:
                        datas.clear();
                        myOrderPresenter.GetMyOrder(uid, token, "WAITPAY", 0, 0);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_order_radiobutton_to_bo_shipped:
                        datas.clear();
                        myOrderPresenter.GetMyOrder(uid, token, "WAITSEND", 0, 0);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_order_radiobutton_to_bo_received:
                        datas.clear();
                        myOrderPresenter.GetMyOrder(uid, token, "WAITRECEIVE", 0, 0);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.my_order_radiobutton_confirm:
                        datas.clear();
                        myOrderPresenter.GetMyOrder(uid, token, "FINISH", 0, 0);
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
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

    private void RadioGroupUI() {
        if (titleName.equals("待付款")) {
            myOrderPresenter.GetMyOrder(uid, token, "WAITPAY", 0, 0);
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_obligation.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
        else if (titleName.equals("待发货")){
            myOrderPresenter.GetMyOrder(uid, token, "WAITSEND", 0, 0);
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
        else if (titleName.equals("待收货")){
            myOrderPresenter.GetMyOrder(uid, token, "WAITRECEIVE", 0, 0);
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
        else if (titleName.equals("已完成")){
            myOrderPresenter.GetMyOrder(uid, token, "FINISH", 0, 0);
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_efb134));
        }
        else {
            myOrderPresenter.GetMyOrder(uid, token, "", 0, 0);
            radiobutton_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
            radiobutton_whole.setTextColor(getResources().getColor(R.color.text_efb134));
            radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
            radiobutton_confirm.setBackgroundResource(R.drawable.myorder_nochoosed_color);
            radiobutton_confirm.setTextColor(getResources().getColor(R.color.text_fdfdfd));
        }
    }
    /**
     * 初始化数据
     */
    private void initData() {
        initExpandableListViewData(datas);
    }

    /**
     * 初始化ExpandableListView
     * 创建数据适配器adapter，并进行初始化操作
     */
    private void initExpandableListView() {
        myOrderAdapter = new MyOrderAdapter(mContext);
        elvShoppingCar.setAdapter(myOrderAdapter);
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
            rlNoContant.setVisibility(View.GONE);
            elvShoppingCar.setVisibility(View.VISIBLE);
        } else {
            rlNoContant.setVisibility(View.VISIBLE);
            elvShoppingCar.setVisibility(View.GONE);
        }
    }

    /**
     * 判断是否要弹出删除的dialog
     * 通过bean类中的DatasBean的isSelect_shop属性，判断店铺是否被选中；
     * GoodsBean的isSelect属性，判断商品是否被选中，
     */
    private void initDelete() {
        //判断是否有店铺或商品被选中
        //true为有，则需要刷新数据；反之，则不需要；
        boolean hasSelect = false;
        //创建临时的List，用于存储没有被选中的购物车数据
        List<ShoppingCarDataBean.DatasBean> datasTemp = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            List<OrderListBean.DataBean.OrderGoodsBean> goods = datas.get(i).getOrder_goods();

        }
        if (hasSelect) {
            showDeleteDialog(datasTemp);
        } else {
            ToastUtils.showToast(mContext, "请选择要删除的商品");
        }
    }

    /**
     * 展示删除的dialog（可以自定义弹窗，不用删除即可）
     *
     * @param datasTemp
     */
    private void showDeleteDialog(final List<ShoppingCarDataBean.DatasBean> datasTemp) {
        View view = View.inflate(mContext, R.layout.dialog_two_btn, null);
        final RoundCornerDialog roundCornerDialog = new RoundCornerDialog(mContext, 0, 0, view, R.style.RoundCornerDialog);
        roundCornerDialog.show();
        roundCornerDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        roundCornerDialog.setOnKeyListener(keylistener);//设置点击返回键Dialog不消失

        TextView tv_message = (TextView) view.findViewById(R.id.tv_message);
        TextView tv_logout_confirm = (TextView) view.findViewById(R.id.tv_logout_confirm);
        TextView tv_logout_cancel = (TextView) view.findViewById(R.id.tv_logout_cancel);
        tv_message.setText("确定要删除商品吗？");

        //确定
        tv_logout_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundCornerDialog.dismiss();
                initExpandableListViewData(datas);
            }
        });
        //取消
        tv_logout_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundCornerDialog.dismiss();
            }
        });
    }

    DialogInterface.OnKeyListener keylistener = new DialogInterface.OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                return true;
            } else {
                return false;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_order_img_back:
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
}
