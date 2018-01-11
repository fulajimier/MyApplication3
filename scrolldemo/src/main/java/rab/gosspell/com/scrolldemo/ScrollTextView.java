package rab.gosspell.com.scrolldemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * author：lirui on 2018/1/3.
 * todo//
 * version：v1.0
 */
public class ScrollTextView extends View {

    public ScrollTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = (getWidth()) / 2;
        drawTextNumber(canvas, centerX);
    }

    private void drawTextNumber(Canvas canvas, float centerX) {
        Paint vTextPaint = new Paint();
        vTextPaint.setTextAlign(Paint.Align.CENTER);
        vTextPaint.setAntiAlias(true);//抗锯齿功能
        vTextPaint.setTextSize(60);
        Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);
        vTextPaint.setTypeface(font);//字体风格
        vTextPaint.setColor(getResources().getColor(R.color.colorAccent));
        Rect bounds_Number = new Rect();
        vTextPaint.getTextBounds("4000", 0, "4000".length(), bounds_Number);
        canvas.drawText("4000", centerX, getHeight() / 2 + bounds_Number.height() / 2, vTextPaint);
    }
}
