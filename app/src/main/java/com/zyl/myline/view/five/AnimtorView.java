package com.zyl.myline.view.five;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class AnimtorView extends View {


    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);

    float length = 50;

    private List<Float> arrayDatas = new ArrayList<>();
    String text;
    float progress = 100;
    float left, top, right, bottom;

    public AnimtorView(Context context) {
        super(context);
    }

    public AnimtorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimtorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        text = progress + "%";
        //paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
//        paint.setStrokeCap(Paint.Cap.ROUND);
        left = 100;

        for (int i = 0; i < arrayDatas.size(); i++) {
            canvas.drawRect(new RectF(left, 100+100*i, progress, 100+100*i+50), paint);
        }


//        paint1.setColor(Color.RED);
//        paint1.setTextSize(40);
//        canvas.drawText(text, progress + 50, 118, paint1);

//        Log.e("AAA", "onDraw: ==>"+progress*2.7f);
//        canvas.drawArc(new RectF(300,300,900,900),0, progress*2.7f,false,paint);
    }

    public void setData(List<Float> mDatas) {
        arrayDatas = mDatas;
    }
}
