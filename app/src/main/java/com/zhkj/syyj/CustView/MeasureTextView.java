package com.zhkj.syyj.CustView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class MeasureTextView extends TextView {

    public MeasureTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MeasureTextView(Context mContext) {
        super(mContext);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //宽
    public int getViewWidth(MeasureTextView view){
        view.measure(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return view.getMeasuredWidth();
    }
    //高
    public int getViewHeight(MeasureTextView view){
        view.measure(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return view.getMeasuredHeight();
    }
}

