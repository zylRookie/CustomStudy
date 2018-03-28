package com.zyl.myline.view.Today;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class zhuChat extends View {

    Paint paint, paintText, paintZ, paintP, paintZX, paintXX;
    Path path, path1;
    String text;

    int[] datas = {80, 70, 90, 60, 40, 88, 60};
    String[] colors = {"#4cce82", "#04692e", "#e7a11f", "#ed2e91", "#11ef66", "#2e84ec", "#a7e4be"};
    String[] names = {"北京", "上海", "广州", "深圳", "武汉", "成都", "南京"};

    float length, k, r, s;

    public zhuChat(Context context) {
        super(context);
    }

    public zhuChat(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public zhuChat(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setAntiAlias(true);
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(18);

        paintZ = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintZ.setAntiAlias(true);
        paintZ.setColor(Color.BLACK);
        paintZ.setStrokeWidth(45);

        paintP = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintP.setAntiAlias(true);
        paintP.setColor(Color.BLACK);
        paintP.setStrokeCap(Paint.Cap.ROUND);
        paintP.setStrokeWidth(10);

        paintZX = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintZX.setStyle(Paint.Style.STROKE);
        paintZX.setAntiAlias(true);
        paintZX.setColor(Color.RED);
        paintZX.setStrokeWidth(2);
        PathEffect pathEffect = new CornerPathEffect(10);
        paintZX.setPathEffect(pathEffect);
        paintZX.setTextSize(18);


        paintXX = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintXX.setStyle(Paint.Style.STROKE);
        paintXX.setPathEffect(new DashPathEffect(new float[]{10, 10}, 0));
        paintXX.setAntiAlias(true);
        paintXX.setColor(Color.parseColor("#5e5d5d"));

        path = new Path();
        path1 = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawZhu(canvas);
        drawXY(canvas);
        //drawZX(canvas);
    }


    /*
        画柱形图
     */
    private void drawZhu(Canvas canvas) {
        length = (getWidth() - 200 - 50) / 7;
        k = getWidth() - 200;
        s = (k - 100) / 11;
        r = (k - 100 - s) / 100;
        path1.moveTo(171, (100 - datas[0]) * r + 100 + s);
        for (int i = 0; i < datas.length; i++) {

            paintZ.setColor(Color.parseColor(colors[i]));
            canvas.drawLine(171 + length * i, getWidth() - 200, 171 + length * i, (100 - datas[i]) * r + 100 + s, paintZ);
            canvas.drawText(names[i], 171 + length * i - paintText.measureText(names[i]) / 2, getWidth() - 200 + paintText.measureText(names[i]) / 2 + 10, paintText);
            canvas.drawText(datas[i] + "", 171 + length * i - paintText.measureText(datas[i] + "") / 2, (100 - datas[i]) * r + 100 + s - paintZX.measureText(datas[i] + "") / 2 - 10, paintZX);
            canvas.drawPoint(171 + length * i, (100 - datas[i]) * r + 100 + s, paintP);
            path1.lineTo(171 + length * i, (100 - datas[i]) * r + 100 + s);

            canvas.save();
            path.moveTo(100, (100 - datas[i]) * r + 100 + s);
            path.lineTo(171 + length * i, (100 - datas[i]) * r + 100 + s);
            canvas.drawPath(path, paintXX);
            canvas.restore();

            canvas.save();
            path.moveTo(171 + length * i, (100 - datas[i]) * r + 100 + s);
            path.lineTo(171 + length * i, getWidth() - 200);
            canvas.drawPath(path, paintXX);
            canvas.restore();
        }

        canvas.drawPath(path1, paintZX);
    }

    /*
        画坐标系
     */
    private void drawXY(Canvas canvas) {

        canvas.drawLine(100, 100, 100, getWidth() - 200, paint);
        canvas.drawLine(90, 110, 100, 100, paint);
        canvas.drawLine(110, 110, 100, 100, paint);

        canvas.drawLine(100, getWidth() - 200, getWidth() - 100, getWidth() - 200, paint);
        canvas.drawLine(getWidth() - 110, getWidth() - 190, getWidth() - 100, getWidth() - 200, paint);
        canvas.drawLine(getWidth() - 110, getWidth() - 210, getWidth() - 100, getWidth() - 200, paint);

        for (int i = 0; i < 12; i++) {
            text = (100 - (i - 1) * 10) + "";
            if (i > 0) {
                if (i != 11) {
                    canvas.drawLine(100, ((getWidth() - 300) / 11 * i) + 100, 107, ((getWidth() - 300) / 11 * i) + 100, paint);
                }
                canvas.drawText(text, 100 - paint.measureText(text) - 20, ((getWidth() - 300) / 11 * i) + 100, paintText);
            }
        }
    }
}
