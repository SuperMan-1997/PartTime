package com.partTime.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.partTime.R;
public class JopTiem extends AppCompatActivity {

    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout title_bar;
    private TextView jop_phone;
    private LinearLayout jop_touxiang;
    private RelativeLayout r1_addr;
    private RelativeLayout r1_juli;
    private RelativeLayout r1_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jop_tiem);
        initView();
    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("兼职详情");
        title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        jop_phone = (TextView) findViewById(R.id.jop_phone);
        jop_touxiang = (LinearLayout) findViewById(R.id.jop_touxiang);
        r1_addr = (RelativeLayout) findViewById(R.id.r1_addr);
        r1_juli = (RelativeLayout) findViewById(R.id.r1_juli);
        r1_type = (RelativeLayout) findViewById(R.id.r1_type);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JopTiem.this.finish();
            }
        });
    }
}
