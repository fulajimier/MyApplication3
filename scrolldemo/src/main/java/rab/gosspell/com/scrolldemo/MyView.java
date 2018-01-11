package rab.gosspell.com.scrolldemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * author：lirui on 2018/1/3.
 * todo//
 * version：v1.0
 */

public class MyView extends View {
    Paint paint;
    int count = 120; //总刻度数
    //我们要设置的高度和宽度
    int width;
    int height;
    int tempcount;
    BarAnimation animation;
    float sw, sh;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(5);
        animation = new BarAnimation();

    }

    public void start() {
        startAnimation(animation);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //宽度类型
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //宽度
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        //高度类型
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //高度
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //说明是确定了 view 的宽度的  这个时候就用原始的宽度
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        sw = wm.getDefaultDisplay().getWidth();
        sh = wm.getDefaultDisplay().getHeight();
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int) sw;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int) sh;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, height / 2);
        Paint tmpPaint = new Paint(paint); //小刻度画笔
        tmpPaint.setStrokeWidth(2);
        float y = width / 4;
        for (int i = 0; i < tempcount; i++) {
            canvas.drawLine(0f, y, 0f, y + 45f, tmpPaint);
            canvas.rotate(360 / count, 0f, 0f); //旋转画纸
        }
    }

    public class BarAnimation extends Animation {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                tempcount = (int) (100 * interpolatedTime);
                postInvalidate();
            } else {
                tempcount = 100;
            }
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            setDuration(2000);
            //设置动画结束后保留效果
            setFillAfter(true);
            tempcount = 0;
            setInterpolator(new LinearInterpolator());
        }
    }
}
