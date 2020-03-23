package com.partTime.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.partTime.R;

public class MingPianActivity extends AppCompatActivity {

    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout title_bar;
    private RelativeLayout r1_jop_mingpian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ming_pian);
        initView();
    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("我的名片");
        title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        r1_jop_mingpian = (RelativeLayout) findViewById(R.id.r1_jop_mingpian);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MingPianActivity.this.finish();
            }
        });
    }
}
