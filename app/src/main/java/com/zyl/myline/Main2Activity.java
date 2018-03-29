package com.zyl.myline;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.zyl.myline.view.Today.HView;
import com.zyl.myline.view.Today.ProgressView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private HView hv;
    private ProgressView pv;
    //String[] names = {"KDA", "输出", "经济", "生存", "推进", "打野"};

    //分别对应 ，"KDA", "输出", "经济", "生存", "推进", "打野";
    float[] datas = {100, 100, 100, 20, 100, 100};

    ArrayList<Float> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hv = findViewById(R.id.hv);
        pv = findViewById(R.id.pv);

        for (int i = 0; i < datas.length; i++) {
            data.add(datas[i]);
        }

        hv.setSize(350);
        hv.setData(data);

    }

    public void start(View view) {
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(pv,"progress",180,300);
//        objectAnimator.setDuration(2000);
//        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//        objectAnimator.start();



        ObjectAnimator oa = ObjectAnimator.ofFloat(pv, "progress", 0, 360);
        oa.setDuration(10000);
        //oa.setInterpolator(new FastOutSlowInInterpolator());
        oa.setInterpolator(new AccelerateDecelerateInterpolator());
        oa.start();
    }
}
