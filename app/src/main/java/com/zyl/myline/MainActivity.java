package com.zyl.myline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zyl.myline.view.one.MyView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyView view;
    List<Integer> list = new ArrayList<>();
    List<String> colors = new ArrayList<>();

    String[] color = {"#e46cdc", "#0b65d2","#f5083b","#52d4f9","#26e977","#f96d1c","#d60b74"};
    int[] data = {256, 45, 635, 189, 250, 100,100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view =  findViewById(R.id.myView);
        view.setData(list);
        for (int i = 0; i <color.length ; i++) {
            colors.add(color[i]);
            list.add(data[i]);
        }
        view.setColors(colors);
        view.setTitle("2018报表");
    }
}
