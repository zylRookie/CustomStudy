package com.zyl.myline.view.one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyl.myline.R;

import java.util.Random;


/**
 * Created by Administrator on 2018/3/22 0022.
 */

public class RoundView extends View {

    private String[] strArr = {"Android", "ios", "java", "js", "php", ".net"};
    public RoundView(Context context) {
        super(context);
    }

    public RoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {

        //------------------基本的圆----drawCircle----------------
      /*  Paint paint = new Paint();
        paint.setStrokeWidth(30);
        paint.setColor(R.color.color5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200f,200f,150,paint);*/


        //------------------基本的矩形----drawRect----------------
      /*  Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setStyle(Paint.Style.FILL);
        //paint1.setStrokeWidth(20);
        paint1.setColor(R.color.blue);
        //canvas.drawRect(100f,100f,100f,100f,paint1);
        canvas.drawRect(100f, 100f, 300f, 200f, paint1);*/


        //------------------基本的点----drawPoint----------------
       /* Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //点的话这个属性就不能用了
        //paint.setStyle(Paint.Style.STROKE);
        //cap有三个属性
        //1. BUTT, ROUND, SQUARE 方形，圆形，效果是方形；
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setColor(R.color.blue);
        paint.setStrokeWidth(100);
        canvas.drawPoint(400f,400f,paint);*/

        //------------------基本的椭圆----drawOval----------------
        /*Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(R.color.blue);
        paint.setStrokeWidth(20);
        canvas.drawOval(new RectF(100f,100f,500f,300f),paint);*/

        //------------------基本的线----drawLine----------------
       /* Paint paint = new Paint();
        //线的话这个属性就不能用了
        //paint.setStyle(Paint.Style.FILL);
        paint.setColor(R.color.blue);
        paint.setStrokeWidth(100);
        canvas.drawLine(200f,200f,600f,400f,paint);*/


        //------------------基本的圆角矩形----drawRoundRect----------------
        /*Paint paint = new Paint();
        //圆角矩形的话这个属性就不能用了
        paint.setStyle(Paint.Style.STROKE);
        //===抗锯齿==
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(R.color.blue);
        paint.setStrokeWidth(20);
        canvas.drawRoundRect(new RectF(100f,100f,600f,500f),30f,40f,paint);*/


        //------------------基本的圆弧----drawArc----------------
        /*RectF rectF = new RectF(200, 200, getWidth() - 200, getWidth() - 200);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        //paint.setColor(R.color.blue);
        //paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF, -180, 120, true, paint);

        //paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawArc(rectF, -60, 30, true, paint);
        //paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawArc(rectF, -30, 110, true, paint);

        //paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(rectF, 80, 55, true, paint);

        paint.setColor(Color.RED);
        canvas.drawArc(rectF, 135, 45, true, paint);
        Paint paint1 = new Paint();
        paint1.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        canvas.drawCircle(getWidth()/2,getWidth()/2,getWidth()/2-320,paint1);

        float x,y,x1,y1 ,x2,y2;
        x = (float) (getWidth()/2 + Math.sin(Math.PI*(-150)/180)*(getWidth()/2-200));
        y = (float) (getWidth()/2 + Math.cos(Math.PI*(-150)/180)*(getWidth()/2-200));



        Paint paint2 = new Paint();
        paint2.setStrokeWidth(20);
        paint2.setColor(Color.YELLOW);
        canvas.drawPoint(x,y,paint2);
        x1 = (float) (getWidth()/2 + Math.sin(Math.PI*(135)/180)*(getWidth()/2-200));
        y1 = (float) (getWidth()/2 + Math.cos(Math.PI*(135)/180)*(getWidth()/2-200));
        canvas.drawPoint(x1,y1,paint2);
        x2 = (float) (getWidth()/2 + Math.sin(Math.PI*(65)/180)*(getWidth()/2-200));
        y2 = (float) (getWidth()/2 + Math.cos(Math.PI*(65)/180)*(getWidth()/2-200));
        canvas.drawPoint(x2,y2,paint2);
        //point[0] = (float)(radius * Math.cos(Math.PI * (Math.abs(90 - (iBArc / 2 + oBMSiSMArc))) / 180));

        Log.e("AAA", "onDraw: x="+x+"y="+y);
        Log.e("AAA", "onDraw: x="+x1+"y="+y1);
        Log.e("AAA", "onDraw: x="+x2+"y="+y2);*/

        //------------------基本的组合----drawPath----------------
       /* int randius = 50;
        int width = getWidth();
        int y1 = 150;
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        Path path = new Path();
        path.addArc(new RectF(width / 2 - 2 * randius, y1, width / 2, y1 + 2 * randius), -230, 230);
        path.arcTo(new RectF(width / 2, y1, width / 2 + 2 * randius, y1 + 2 * randius), -180, 230);
        path.lineTo(width / 2, y1 * 2);
        path.close();
        //paint.setStrokeWidth(100);
        canvas.drawPath(path,paint);*/


        //------------------基本的柱状图--------------------
        int width = getWidth();
        int min=100;
        int max=700;
        Random random = new Random();
        Paint paint = new Paint();
        paint.setColor(R.color.blank);
        //画线
        canvas.drawLine(100,800,width-100,800,paint);
        canvas.drawLine(100,100,100,800,paint);

        //画柱状图
        for (int i = 0; i <6 ; i++) {
            paint.setColor(Color.GREEN);
            paint.setStyle(Paint.Style.FILL);
            int num = random.nextInt(max)%(max-min+1) + min;
            canvas.drawRect(new RectF(140+i*140,num,240+i*140,800),paint);
            paint.setTextSize(40);
            paint.setColor(Color.BLACK);
            canvas.drawText(strArr[i],190+i*140-paint.measureText(strArr[i]) / 2,840,paint);
        }
    }

}
