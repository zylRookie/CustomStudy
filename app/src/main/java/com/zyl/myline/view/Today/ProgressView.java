package com.zyl.myline.view.Today;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class ProgressView extends View {

    Paint paint, paintR, paintT;
    float progress = 0;
    float r = 250;
    String text = "";

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#f3f3f3"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(40);


        paintR = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintR.setColor(Color.RED);
        paintR.setStyle(Paint.Style.STROKE);
        paintR.setAntiAlias(true);
        paintR.setStrokeWidth(40);
        paintR.setStrokeCap(Paint.Cap.ROUND);

        paintT = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintT.setColor(Color.RED);
        paintT.setAntiAlias(true);
        paintT.setTextSize(60);
        paintT.setFakeBoldText(true);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DecimalFormat fnum = new DecimalFormat("##0.0");
        text = fnum.format(progress / 360 * 100) + "%";
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, (getWidth() - r * 2) / 2, paint);

        canvas.drawArc(new RectF(r, r, getWidth() - r, getWidth() - r), 180, progress, false, paintR);
        canvas.drawText(text, getWidth() / 2 - paintT.measureText(text) / 2, getWidth() / 2 + 20, paintT);
    }
}

