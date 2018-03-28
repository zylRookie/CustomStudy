package com.zyl.myline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zyl.myline.view.Today.HView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private HView hv;
    //String[] names = {"KDA", "输出", "经济", "生存", "推进", "打野"};

    //分别对应 ，"KDA", "输出", "经济", "生存", "推进", "打野";
    float[] datas = {100, 20, 20, 100, 20, 20};

    ArrayList<Float> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        hv = findViewById(R.id.hv);

        for (int i = 0; i < datas.length; i++) {
            data.add(datas[i]);
        }

        hv.setSize(350);
        hv.setData(data);


    }

}
