package com.zhkj.syyj.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.zhkj.syyj.Beans.BalanceBean;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.DateUtils;
import com.zhkj.syyj.contract.MyBalanceContract;
import com.zhkj.syyj.presenter.MyBalancePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyBalanceActivity extends AppCompatActivity implements View.OnClickListener, MyBalanceContract.View {
    @InjectView(R.id.my_balance_btn_recharge)
    Button btn_recharge;
    @InjectView(R.id.my_balance_btn_cash_out)
    Button btn_cash_out;
    private Context mContext;
    private ListView balance_list;
    private MyAdapter myAdapter;
    private MyBalancePresenter myBalancePresenter;
    private SharedPreferences share;
    private String token;
    private String uid;
    private List<BalanceBean.DataBean.LogBean> log=new ArrayList<>();
    private String balance;
    private TextView tv_pursue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_balance);
        mContext = getApplicationContext();
        ButterKnife.inject(this);
        btn_recharge.setOnClickListener(this);
        btn_cash_out.setOnClickListener(this);
        share = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        token = share.getString("token", "");
        uid = share.getString("uid", "");
        InitUI();
        myBalancePresenter = new MyBalancePresenter(this);
        myBalancePresenter.GetBalance(uid,token);
    }

    private void InitUI() {
        findViewById(R.id.my_balance_img_back).setOnClickListener(this);
        tv_pursue = findViewById(R.id.my_balance_tv_pursue);
        balance_list = findViewById(R.id.my_balance_list);
        myAdapter = new MyAdapter();
        balance_list.setAdapter(myAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_balance_btn_recharge:
                startActivity(new Intent(mContext,RechargeActivity.class));
                break;
            case R.id.my_balance_btn_cash_out:
                startActivity(new Intent(mContext,CashOutActivity.class));
                break;
            case R.id.my_balance_img_back:
                finish();
                break;
                default:
                    break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return log.size();
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
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.list_balance, null);
            TextView tv_dt = inflate.findViewById(R.id.list_balance_dt);
            TextView tv_time = inflate.findViewById(R.id.list_balance_time);
            TextView tv_type = inflate.findViewById(R.id.list_balance_type);
            TextView tv_money = inflate.findViewById(R.id.list_balance_money);
            tv_dt.setText(DateUtils.timeStamp2Date(log.get(position).getTime()+""));
            tv_time.setText(DateUtils.timeStamp2Date3(log.get(position).getTime()+""));
            tv_type.setText(log.get(position).getDesc());
            tv_money.setText(log.get(position).getMoney());
            return inflate ;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    //UI更新
    public void  UpdateUI(int code, String msg, BalanceBean.DataBean data){
        if (code==1){
            balance = data.getBalance();
            tv_pursue.setText(balance);
            log = data.getLog();
            myAdapter.notifyDataSetChanged();
        }
    }
}
