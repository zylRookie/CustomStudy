package com.zyl.myline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.Toast;

import com.zyl.myline.view.Today.HView;
import com.zyl.myline.view.Today.ProgressView;
import com.zyl.myline.view.Today.TimeView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private HView hv;
    private ProgressView pv;
    private TimeView tv;
    EditText etn;
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
        tv = findViewById(R.id.tv);
        etn = findViewById(R.id.etn);


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
        oa.setDuration(5000);
        //oa.setInterpolator(new FastOutSlowInInterpolator());
        oa.setInterpolator(new AccelerateDecelerateInterpolator());
        oa.start();
    }

    public void time(View view) {

        if (TextUtils.isEmpty(etn.getText().toString().trim())) {
            Toast.makeText(this, "输入不能为空，在0-240之间！", Toast.LENGTH_SHORT).show();
        }

        int vue = Integer.parseInt(etn.getText().toString().trim());

        Keyframe keyframe1 = Keyframe.ofInt(0, 0); // 时间完成度为0时，值为0
        Keyframe keyframe2 = Keyframe.ofInt(0.5f, (int) (0.75 * vue) + 30);// 时间完成度为一半时，值为100
        Keyframe keyframe3 = Keyframe.ofInt(1, (int) (0.75 * vue));// 时间完成度为1时（既动画完成），值退到80

        // 设置Keyframe的插值器
        keyframe1.setInterpolator(new LinearInterpolator());
        keyframe2.setInterpolator(new AccelerateDecelerateInterpolator());
        //  2. 创建PropertyValuesHolder对象
        PropertyValuesHolder pvh = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);
        // 3. 创建ValueAnimator实例
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tv, pvh);
        animator.setDuration(3000);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();


        //监听方式 实现部分接口 有选择的去实现要监听的事件
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                tv.setTitle(etn.getText().toString());
            }
        });
    }
}
