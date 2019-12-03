package com.zhkj.syyj.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhkj.syyj.Adapters.AppraiseAdapter;
import com.zhkj.syyj.R;
import com.zhkj.syyj.Utils.MxyUtils;
import com.zhouyou.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppraiseActivity extends AppCompatActivity implements View.OnClickListener {

    private XRecyclerView mRecyclerView;
    private List<String> list=new ArrayList<>();
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private AppraiseAdapter appraiseAdapter;
    private RadioGroup radioGroup;
    private RadioButton radiobutton_whole;
    private RadioButton radiobutton_to_bo_shipped;
    private RadioButton radiobutton_to_bo_received;
    private RadioButton radiobutton_obligation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appraise);
        mContext = getApplicationContext();
        InitUI();
    }

    private void InitUI() {
        list.add("112");
        list.add("112");
        list.add("112");
        list.add("112");
        list.add("112");
        findViewById(R.id.appraise_img_back).setOnClickListener(this);
        mRecyclerView= findViewById(R.id.appraise_recycleView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManager = new LinearLayoutManager(mContext);
        appraiseAdapter = new AppraiseAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.refreshComplete();//刷新动画完成
            }

            @Override
            public void onLoadMore() {
                //加载更多
                mRecyclerView.loadMoreComplete();//加载动画完成
                mRecyclerView.setNoMore(true);//数据加载完成
            }
        });
        mRecyclerView.setAdapter( appraiseAdapter);
        appraiseAdapter.setListAll(list);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0
                        , 0
                        , 0
                        , MxyUtils.dpToPx(mContext, MxyUtils.getDimens(mContext, R.dimen.dp_10)));
            }
        });

        radioGroup = findViewById(R.id.appraise_radioGroup);
        radiobutton_whole = findViewById(R.id.appraise_radiobutton_whole);
        radiobutton_to_bo_shipped = findViewById(R.id.appraise_radiobutton_to_bo_shipped);
        radiobutton_to_bo_received = findViewById(R.id.appraise_radiobutton_to_bo_received);
        radiobutton_obligation = findViewById(R.id.appraise_radiobutton_obligation);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.appraise_radiobutton_obligation:
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.appraise_radiobutton_to_bo_shipped:
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                    case R.id.appraise_radiobutton_to_bo_received:
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_efb134));
                        break;
                    case R.id.appraise_radiobutton_whole:
                        radiobutton_whole.setBackgroundResource(R.drawable.myorder_choosed_color);
                        radiobutton_whole.setTextColor(getResources().getColor(R.color.text_efb134));
                        radiobutton_obligation.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_obligation.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_shipped.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_shipped.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        radiobutton_to_bo_received.setBackgroundResource(R.drawable.myorder_nochoosed_color);
                        radiobutton_to_bo_received.setTextColor(getResources().getColor(R.color.text_fdfdfd));
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.appraise_img_back:
                finish();
                break;
                default:
                    break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
