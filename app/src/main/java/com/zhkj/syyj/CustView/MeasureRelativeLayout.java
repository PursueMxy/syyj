package com.zhkj.syyj.CustView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MeasureRelativeLayout extends RelativeLayout {
    public MeasureRelativeLayout(Context context) {
        super(context);
    }
    public MeasureRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MeasureRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //宽
    public int getViewWidth(MeasureRelativeLayout view){
        view.measure(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return view.getMeasuredWidth();
    }
    //高
    public int getViewHeight(MeasureRelativeLayout view){
        view.measure(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return view.getMeasuredHeight();
    }
}
