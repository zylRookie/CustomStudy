package com.zyl.myline.view.four;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyl.myline.R;

/**
 * Created by Administrator on 2018/3/24 0024.
 */

public class DrawBitmapView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.maps);
    }

    public DrawBitmapView(Context context) {
        super(context);
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;

//        canvas.clipRect(left, top + bitmap.getHeight() / 4, left + bitmap.getWidth(), top + bitmap.getHeight() * 3 / 4);
//        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.clipRect(100, 100, getWidth() - 100, getWidth() - 100);
        canvas.drawBitmap(bitmap, 200, 200, paint);

    }
}
