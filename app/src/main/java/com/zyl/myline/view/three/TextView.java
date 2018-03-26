package com.zyl.myline.view.three;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/3/24 0024.
 */

public class TextView extends View {

    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "Hello HeiHeiHei";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(50);
        paint.setStrikeThruText(true);
        paint.setUnderlineText(true);
        paint.setTextSkewX(-0.3f);
        canvas.drawText(text, 50, 100, paint);
    }
}
