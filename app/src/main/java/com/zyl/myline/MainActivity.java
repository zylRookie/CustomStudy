package com.zyl.myline;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.zyl.myline.view.five.AnimtorView;
import com.zyl.myline.view.one.MyView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyView view;
    AnimtorView anv1;
    List<Integer> list = new ArrayList<>();
    List<String> colors = new ArrayList<>();
    List<Float> dataX = new ArrayList<>();

    String[] color = {"#e46cdc", "#0b65d2", "#f5083b", "#52d4f9", "#26e977", "#f96d1c", "#d60b74"};
    int[] data = {256, 45, 635, 189, 250, 100, 100};
    float[] arrayData = {350,250,650,450,150,500};
    float[] datas = {300, 689, 210};
    ObjectAnimator oa, ob, oc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.myView);
        anv1 = findViewById(R.id.anv1);
        for (int i = 0; i < arrayData.length ; i++) {
            dataX.add(arrayData[i]);
        }
        anv1.setData(dataX);
        view.setData(list);
        for (int i = 0; i < color.length; i++) {
            colors.add(color[i]);
            list.add(data[i]);
        }
        view.setColors(colors);
        view.setTitle("2018报表");


//        oa = ObjectAnimator.ofFloat(anv1,
//                "progress", 100, datas[0]);
//        oa.setDuration(2000);
//        oa.setInterpolator(new AccelerateDecelerateInterpolator());
//        oa.start();
//
//        ob = ObjectAnimator.ofFloat(anv2, "progress", 100, datas[1]);
//        ob.setDuration(2000);
//        ob.setInterpolator(new AccelerateDecelerateInterpolator());
//        ob.start();
//
//        oc = ObjectAnimator.ofFloat(anv3, "progress", 100, datas[2]);
//        oc.setDuration(2000);
//        oc.setInterpolator(new AccelerateDecelerateInterpolator());
//        oc.start();


    }

    //获取屏幕高度
    public int getHight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int hight = wm.getDefaultDisplay().getHeight();
        return hight;
    }

    //获取屏幕宽度
    public int getWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    public void start(View view) {
        for (int i = 0; i <arrayData.length ; i++) {

            oc = ObjectAnimator.ofFloat(anv1, "progress", 100, arrayData[i]);
            Log.e("aaa", "start: ---->=="+arrayData[i]);

        }
        oc.setDuration(2000);
        oc.setInterpolator(new AccelerateDecelerateInterpolator());
        oc.start();
    }

    public void intentSend(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }
}
