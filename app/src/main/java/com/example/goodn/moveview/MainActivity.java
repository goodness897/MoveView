package com.example.goodn.moveview;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        final LinearLayout llBottom = (LinearLayout) findViewById(R.id.ll_bottom);
        final LinearLayout llAddView = (LinearLayout) findViewById(R.id.ll_add_view);
        Button btnOne = (Button) findViewById(R.id.btn_one);
        final ImageView ivSample = new ImageView(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ivSample.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_launcher));
        }
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation bottomUp = AnimationUtils.loadAnimation(context,
                        R.anim.bottom_up);
                RelativeLayout.LayoutParams layout = (RelativeLayout.LayoutParams) llBottom.getLayoutParams();
                layout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
                llAddView.addView(ivSample);
                llBottom.setLayoutParams(layout);
                llBottom.startAnimation(bottomUp);
                llBottom.setVisibility(View.VISIBLE);
            }
        });

    }

}