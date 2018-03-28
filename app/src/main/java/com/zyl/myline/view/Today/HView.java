package com.zyl.myline.view.Today;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/28 0028.
 */

public class HView extends View {

    Paint paint, paintP, paintLine, paintN, paintNX, paintT;
    Path path, path1, path2;

    String[] names = {"KDA", "输出", "经济", "生存", "推进", "打野"};


    ArrayList<Float> datas = new ArrayList<>();


    public HView(Context context) {
        super(context);
    }

    public HView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#333333"));
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);

        paintT = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintT.setColor(Color.BLACK);
        paintT.setAntiAlias(true);
        paintT.setTextSize(28);


        paintP = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintP.setStrokeCap(Paint.Cap.ROUND);
        paintP.setAntiAlias(true);
        paintP.setColor(Color.RED);
        paintP.setStrokeWidth(10);
        paintP.setTextSize(50);
        paintP.setFakeBoldText(true);

        paintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintLine.setAntiAlias(true);
        paintLine.setColor(Color.parseColor("#f5e566"));


        paintN = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintN.setAntiAlias(true);
        paintN.setStyle(Paint.Style.STROKE);
        paintN.setColor(Color.RED);
        paintN.setStrokeWidth(2f);


        paintNX = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintNX.setAntiAlias(true);
        paintNX.setStyle(Paint.Style.FILL);
        paintNX.setColor(Color.parseColor("#33FF0000"));

        path = new Path();
        path1 = new Path();
        path2 = new Path();
    }

    public HView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    float x, y, r, xr, yr,size;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        r = (getWidth() - size) / 2;
        x = (float) (getWidth() / 2 + Math.sin(Math.PI * 180 / 180) * r);
        y = (float) (getWidth() / 2 + Math.cos(Math.PI * 180 / 180) * r);
        xr = 0.5f * ((float) Math.sqrt(3)) * r / 100;
        yr = 0.5f * r / 100;
        path.moveTo(x, y);
        path1.moveTo(x, y + r / 100 * (100 - datas.get(0)));
        path2.moveTo(x, y + r / 100 * (100 - datas.get(0)));

        for (int i = 0; i < 7; i++) {
            x = (float) (getWidth() / 2 + Math.sin(Math.PI * (180 - 60 * i) / 180) * r);
            y = (float) (getWidth() / 2 + Math.cos(Math.PI * (180 - 60 * i) / 180) * r);

            switch (i) {
                case 0:
                    canvas.drawText(names[i], x - paintT.measureText(names[i]) / 2 - 20, y - paintT.measureText(names[i]) / 2, paintT);
                    canvas.drawText(getPj(datas.get(i)), x + paintT.measureText(names[i]) / 2 - 10, y - paintT.measureText(names[i]) / 2 + 5, paintP);
                    canvas.drawPoint(x, y + r / 100 * (100 - datas.get(i)), paintP);
                    path1.lineTo(x, y + r / 100 * (100 - datas.get(i)));
                    path2.lineTo(x, y + r / 100 * (100 - datas.get(i)));
                    break;
                case 3:
                    canvas.drawText(names[i], x - paintT.measureText(names[i]) / 2 - 20, y + 10 + paintT.measureText(names[i]) / 2, paintT);
                    canvas.drawText(getPj(datas.get(i)), x + paintT.measureText(names[i]) / 2 - 10, y + 10 + paintT.measureText(names[i]) / 2 + 5, paintP);
                    canvas.drawPoint(x, y - r / 100 * (100 - datas.get(i)), paintP);
                    path1.lineTo(x, y - r / 100 * (100 - datas.get(i)));
                    path2.lineTo(x, y - r / 100 * (100 - datas.get(i)));
                    break;
                case 1:
                    canvas.drawText(names[i], x + 10, y, paintT);
                    canvas.drawText(getPj(datas.get(i)), x + paintT.measureText(names[i]) + 15, y + 5, paintP);
                    canvas.drawPoint(x - xr * (100 - datas.get(i)), y + yr * (100 - datas.get(i)), paintP);
                    path1.lineTo(x - xr * (100 - datas.get(i)), y + yr * (100 - datas.get(i)));
                    path2.lineTo(x - xr * (100 - datas.get(i)), y + yr * (100 - datas.get(i)));
                    break;
                case 2:
                    canvas.drawText(names[i], x + 10, y, paintT);
                    canvas.drawText(getPj(datas.get(i)), x + paintT.measureText(names[i]) + 15, y + 5, paintP);
                    canvas.drawPoint(x - xr * (100 - datas.get(i)), y - yr * (100 - datas.get(i)), paintP);
                    path1.lineTo(x - xr * (100 - datas.get(i)), y - yr * (100 - datas.get(i)));
                    path2.lineTo(x - xr * (100 - datas.get(i)), y - yr * (100 - datas.get(i)));
                    break;
                case 4:
                    canvas.drawText(names[i], x - paintT.measureText(names[i]) - paintP.measureText(getPj(datas.get(i))) - 15, y, paintT);
                    canvas.drawText(getPj(datas.get(i)), x - paintP.measureText(getPj(datas.get(i))) - 10, y + 5, paintP);
                    canvas.drawPoint(x + xr * (100 - datas.get(i)), y - yr * (100 - datas.get(i)), paintP);
                    path1.lineTo(x + xr * (100 - datas.get(i)), y - yr * (100 - datas.get(i)));
                    path2.lineTo(x + xr * (100 - datas.get(i)), y - yr * (100 - datas.get(i)));
                    break;
                case 5:
                    canvas.drawText(names[i], x - paintT.measureText(names[i]) - paintP.measureText(getPj(datas.get(i))) - 15, y, paintT);
                    canvas.drawText(getPj(datas.get(i)), x - paintP.measureText(getPj(datas.get(i))) - 10, y + 5, paintP);
                    canvas.drawPoint(x + xr * (100 - datas.get(i)), y + yr * (100 - datas.get(i)), paintP);
                    path1.lineTo(x + xr * (100 - datas.get(i)), y + yr * (100 - datas.get(i)));
                    path2.lineTo(x + xr * (100 - datas.get(i)), y + yr * (100 - datas.get(i)));
                    break;

                case 6:
                    path1.lineTo(x, y + r / 100 * (100 - datas.get(0)));
                    path2.lineTo(x, y + r / 100 * (100 - datas.get(0)));
                    break;
            }

            canvas.drawLine(getWidth() / 2, getWidth() / 2, x, y, paintLine);
            path.lineTo(x, y);

        }

        canvas.drawPath(path, paint);
        canvas.drawPath(path1, paintN);
        canvas.drawPath(path2, paintNX);

    }

    public String getPj(float x) {

        String pj = "";
        if (x <= 100 && x > 80) {
            pj = "S";
        } else if (x <= 80 && x > 60) {
            pj = "A";
        } else if (x <= 60 && x > 40) {
            pj = "B";
        } else if (x <= 40 && x > 20) {
            pj = "C";
        } else if (x <= 20 && x >= 0) {
            pj = "D";
        }

        return pj;
    }

    public void setSize(float size){
        this.size = size;
    }

    public void setData(ArrayList<Float> datas){
        this.datas = datas;
    }
}
