package com.zyl.myline.view.Today;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class TimeView extends View {

    Paint paint, paintT, paintK, paintP, paintZ, paintV, paintTt;
    boolean tag = false;

    String[] times = {"0", "20", "40", "60", "80", "100", "120", "140", "160", "180", "200", "220", "240",};

    int progress = 0;
    String text, gtext = "";

    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#6ea6f5"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);


        paintT = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintT.setAntiAlias(true);
        paintT.setTextSize(20);
        paintT.setColor(Color.parseColor("#ffffff"));

        paintK = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintK.setAntiAlias(true);
        paintK.setStrokeWidth(2);
        paintK.setColor(Color.parseColor("#ffffff"));

        paintZ = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintZ.setAntiAlias(true);
        paintZ.setStrokeWidth(5);
        paintZ.setColor(Color.parseColor("#ffffff"));

        paintV = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintV.setAntiAlias(true);
        paintV.setStrokeWidth(5);
        paintV.setTextSize(60);
        paintV.setColor(Color.parseColor("#ffffff"));

        paintTt = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintTt.setAntiAlias(true);
        paintTt.setStrokeWidth(5);
        paintTt.setTextSize(20);
        paintTt.setColor(Color.parseColor("#ffffff"));


    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawMaxR(canvas);

        drawKU(canvas);

        drawZZ(canvas);

    }

    private void drawZZ(Canvas canvas) {
        gtext = "km/h";
        DecimalFormat fnum = new DecimalFormat("##0.0");
        if (!tag)
            text = fnum.format(progress * ((float) 4 / 3));
        x = (float) (getWidth() / 2 + Math.sin(Math.PI * (-90 - progress) / 180) * (getWidth() - 350) / 2);
        y = (float) (getWidth() / 2 + Math.cos(Math.PI * (-90 - progress) / 180) * (getWidth() - 350) / 2);

        canvas.drawLine(x, y, getWidth() / 2, getWidth() / 2, paintZ);

        canvas.drawText(text, getWidth() / 2 - paintV.measureText(text) / 2, getWidth() / 2 - 200, paintV);
        canvas.drawText(gtext, getWidth() / 2 + paintV.measureText(text) / 2 + 10, getWidth() / 2 - 200, paintTt);

        tag = !tag;
    }

    float x, y, x1, y1, x2, y2;

    /*
        画刻度
     */
    private void drawKU(Canvas canvas) {


        for (int i = 0; i < 61; i++) {
            x = (float) (getWidth() / 2 + Math.sin(Math.PI * (-90 - 3 * i) / 180) * (getWidth() - 240) / 2);
            y = (float) (getWidth() / 2 + Math.cos(Math.PI * (-90 - 3 * i) / 180) * (getWidth() - 240) / 2);

            x1 = (float) (getWidth() / 2 + Math.sin(Math.PI * (-90 - 3 * i) / 180) * (getWidth() - 210) / 2);
            y1 = (float) (getWidth() / 2 + Math.cos(Math.PI * (-90 - 3 * i) / 180) * (getWidth() - 210) / 2);

            //canvas.drawPoint(x, y, paintP);
            canvas.drawLine(x1, y1, x, y, paintK);
        }

        for (int i = 0; i < 13; i++) {
            x = (float) (getWidth() / 2 + Math.sin(Math.PI * (-90 - 15 * i) / 180) * (getWidth() - 260) / 2);
            y = (float) (getWidth() / 2 + Math.cos(Math.PI * (-90 - 15 * i) / 180) * (getWidth() - 260) / 2);

            x1 = (float) (getWidth() / 2 + Math.sin(Math.PI * (-90 - 15 * i) / 180) * (getWidth() - 210) / 2);
            y1 = (float) (getWidth() / 2 + Math.cos(Math.PI * (-90 - 15 * i) / 180) * (getWidth() - 210) / 2);

            x2 = (float) (getWidth() / 2 + Math.sin(Math.PI * (-90 - 15 * i) / 180) * (getWidth() - 320) / 2);
            y2 = (float) (getWidth() / 2 + Math.cos(Math.PI * (-90 - 15 * i) / 180) * (getWidth() - 320) / 2);

            paint.setStrokeWidth(3);
            canvas.drawLine(x1, y1, x, y, paint);
            canvas.drawText(times[i], x2 - paintT.measureText(times[i]) / 2, y2, paintT);

        }
    }

    /*
        画外圈
     */
    private void drawMaxR(Canvas canvas) {
        canvas.drawArc(new RectF(100, 100, getWidth() - 100, getWidth() - 100), -180, 180, false, paint);

//        canvas.drawArc(new RectF(150, 150, getWidth() - 150, getWidth() - 150), -180, 180, false, paint);

//        canvas.drawPoint(getWidth() / 2, getWidth() / 2, paintP);e6a067
        paintP = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintP.setShader(new RadialGradient(getWidth() / 2, getWidth() / 2, 15, Color.parseColor("#ec7615"), Color.parseColor("#e6a067"), Shader.TileMode.CLAMP));
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, 15, paintP);

    }

    public void setTitle(String text) {
        this.text = text + ".0";
        invalidate();
        tag = true;
    }
}
