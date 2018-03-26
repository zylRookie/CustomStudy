package com.zyl.myline.view.two;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyl.myline.R;

/**
 * Created by Administrator on 2018/3/24 0024.
 */

public class ShaderView extends View {


    Paint paint;
    Path path = new Path();

//    {
//        paint.setStrokeWidth(40);
//        paint.setStyle(Paint.Style.STROKE);
//        path.rLineTo(200, 0);
//        path.rLineTo(-160, 120);
//    }

    public ShaderView(Context context) {
        super(context);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //------------着色的一种方式----setShader------LinearGradient----------------
        /*paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(new LinearGradient(100,100,300,300, Color.BLUE,Color.RED, Shader.TileMode.CLAMP));
        canvas.drawCircle(200,200,100,paint);*/

        //------------着色的一种方式----setShader------RadialGradient----------------
        /*paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(new RadialGradient(200,200,100, Color.RED, Color.BLUE, Shader.TileMode.CLAMP));
        canvas.drawCircle(200,200,100,paint);*/

        //------------着色的一种方式----setShader------SweepGradient----------------
        /*paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(new SweepGradient(200,200,Color.RED, Color.BLUE));
        canvas.drawCircle(200,200,100,paint);*/

        //------------着色的一种方式----setShader------BitmapShader----- 可以切割成原型图片，加上外圈带-----------
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.title), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawCircle(300,300,210,paint);
        Paint paint1 = new Paint();
        paint1.setStrokeWidth(10);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.GREEN);
        canvas.drawCircle(300,300,210,paint1);

        //------------着色的一种方式----setShader------SweepGradient----------------
       /* paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        BitmapShader bsBatman = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.title), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        BitmapShader bsBatmanLogo = new BitmapShader(BitmapFactory.decodeResource(getResources(), R.mipmap.batman_logo), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //ComposeShader() 在硬件加速下是不支持两个相同类型的 Shader 的，所以这里也需要关闭硬件加速才能看到效果。
        paint.setShader(new ComposeShader(bsBatman, bsBatmanLogo, PorterDuff.Mode.DST_IN));
        canvas.drawCircle(200, 200, 200, paint);*/

        //--------------------------------------------

        /*paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.save();

        canvas.translate(100, 100);
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, paint);

        canvas.translate(300, 0);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, paint);

        canvas.translate(300, 0);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);

        canvas.restore();*/

    }
}
