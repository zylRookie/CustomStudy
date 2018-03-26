package com.zyl.myline.view.one;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/3/23 0023.
 */

public class MyView extends View {

    int width, sum;
    RectF rectF;
    Paint paint;

    /**
     * 各个元素
     */
    private List<Integer> arrayDatas = new ArrayList<>();
    /**
     * 元素的颜色
     */
    private List<String> mColors = new ArrayList<>();
    float progress = 0;

    ArrayList<Float> r = new ArrayList<>();
    ArrayList<String> txt = new ArrayList<>();


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }


    float  x, y;
    String text = "";

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float round, sumR, sumo = 0;
        initSum();

        width = getWidth();
        rectF = new RectF(width / 4, width / 4, width * 3 / 4, width * 3 / 4);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        for (int i = 0; i < arrayDatas.size(); i++) {
            paint.setColor(Color.parseColor(mColors.get(i)));
            if (i == 0) {
                round = -90;
                sumR = r.get(i) / 2;
            } else {
                sumo += r.get(i - 1);
                round = -90 + sumo;
                sumR = sumo + r.get(i) / 2;
            }

            canvas.drawArc(rectF, round, r.get(i), true, paint);

            x = (float) (getWidth() / 2 + Math.sin(Math.PI * (180 - sumR) / 180) * width * 19 / 64);
            y = (float) (getWidth() / 2 + Math.cos(Math.PI * (180 - sumR) / 180) * width * 19 / 64);
            Paint linePaint = new Paint();
            linePaint.setColor(Color.parseColor(mColors.get(i)));
            linePaint.setStrokeWidth(5);
            linePaint.setAntiAlias(true);
            linePaint.setTextSize(35);
            canvas.drawLine(getWidth() / 2, getWidth() / 2, x, y, linePaint);
            if ((180 - sumR) > 0) {
                canvas.drawLine(x, y, x + 80, y, linePaint);
                canvas.drawText(txt.get(i), x + 90, y + 10, linePaint);
            } else {
                canvas.drawLine(x, y, x - 80, y, linePaint);
                canvas.drawText(txt.get(i), x - linePaint.measureText(txt.get(i)) - 90, y + 10, linePaint);
            }

        }

        paint.setColor(Color.WHITE);
        canvas.drawCircle(width / 2, width / 2, width / 6, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText(text, getWidth() / 2 - paint.measureText(text) / 2, getWidth() / 2+10, paint);
    }

    private void initSum() {
        for (int i = 0; i < arrayDatas.size(); i++) {
            sum += arrayDatas.get(i);
        }
        for (int i = 0; i < arrayDatas.size(); i++) {
            r.add((float) arrayDatas.get(i) / sum * 360);
            DecimalFormat fnum = new DecimalFormat("##0.00");

            txt.add(fnum.format(((float) arrayDatas.get(i) / sum) * 100) + "%");
        }
    }

    public void setColors(List<String> mColor) {
        mColors = mColor;
    }

    public void setData(List<Integer> mDatas) {
        arrayDatas = mDatas;
    }

    public void setTitle(String txt) {
        text = txt;
    }

}
