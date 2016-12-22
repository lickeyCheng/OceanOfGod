package com.lickey.asus.oceanofgod.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * describe：
 * time：on 2016/11/30 09:27
 * created by：aifeng.hong
 */
public class AutoTextView extends TextView implements Runnable {
    private int currentScrollX;// 当前滚动的位置
    private boolean isStop = false;
    private int textWidth;
    private boolean isMeasure = false;
    private boolean isFirst = false;

    public AutoTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public AutoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (!isMeasure) {// 文字宽度只需获取一次就可以了
            getTextWidth();
            isMeasure = true;
        }

    }

    /**
     * 获取文字宽度
     */
    private void getTextWidth() {
        Paint paint = this.getPaint();
        String str = this.getText().toString();
        textWidth = (int) paint.measureText(str);
        Log.d("textWidth:",textWidth+",x:"+this.getWidth());
    }

    // 重写setText 在setText的时候重新计算text的宽度
    @Override
    public void setText(CharSequence text, BufferType type) {
        // TODO Auto-generated method stub
        super.setText(text, type);
        this.isMeasure = false;
    }

    @Override
    public void run() {
        if (isFirst) {
            scrollTo(-getWidth(), 0);
            currentScrollX = -getWidth();
            isFirst = false;
        }
        currentScrollX++;// 滚动速度
        scrollTo(currentScrollX, 0);//相对（0,0）的偏移点
        if (isStop) {
            return;
        }
        if (currentScrollX >= (textWidth - getWidth())) {
            scrollTo(-this.getWidth(), 0);
            currentScrollX = -this.getWidth();
            // return;
        }

        postDelayed(this, 5);
    }

    // 开始滚动
    public void startScroll() {
        isStop = false;
        this.removeCallbacks(this);
        isFirst = true;
        post(this);
    }

    // 停止滚动
    public void stopScroll() {
        isStop = true;
        // textWidth=currentScrollX; //随时停止
    }

    // 从头开始滚动
    public void startFor0() {
        currentScrollX = 0;
        startScroll();
    }
}