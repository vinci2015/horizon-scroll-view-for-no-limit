package com.github.vinci.animationpractices;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textHello;
    private Button btn_run;
    private MyHorizontalScrollView scrollView;
    private HorizontalScrollViewAdapter adapter;
    private List<Integer> imgs = new ArrayList<Integer>(Arrays.asList(R.drawable.cassiopeia_square_0,
            R.drawable.masteryi_square_0, R.drawable.zed_square_0,R.drawable.karthus_square_0,
            R.drawable.trundle_square_0,R.drawable.ziggs_square_0,R.drawable.sona_square_0));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textHello = (TextView) findViewById(R.id.txt_hello);
        btn_run = (Button) findViewById(R.id.button);
        scrollView = (MyHorizontalScrollView) findViewById(R.id.scroll);
        adapter = new HorizontalScrollViewAdapter(this,imgs);
        scrollView.initView(adapter);
    }
    public void run(View view){
        Toast.makeText(this,"run",Toast.LENGTH_SHORT).show();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        textHello.startAnimation(animation);
        btn_run.startAnimation(animation);
        btn_run.setAlpha(1.0f);
    }
    public void propertyAnimation(View view){
        ObjectAnimator
                .ofFloat(textHello,"translationX",0,50)
                .setDuration(2000)
                .start();
    }
}
