package com.partTime.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.partTime.R;

public class RenwuActivity extends AppCompatActivity {
    private TextView tv_main_title;
    private TextView tv_back;
    private RelativeLayout r1_title_bar;

    private ImageView iv_wenjian,iv_bianji;
    private TextView tv_bianji;

    public static RenwuActivity instance=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renwu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        instance=this;
        init();
    }

    private void init() {
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_main_title.setText("小任务记录");
        tv_back=(TextView)findViewById(R.id.tv_back);
        r1_title_bar=(RelativeLayout)findViewById(R.id.title_bar);
        iv_wenjian=(ImageView)findViewById(R.id.iv_wenjian);
        iv_bianji=(ImageView)findViewById(R.id.iv_bianji);
        tv_bianji=(TextView)findViewById(R.id.tv_bianji);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RenwuActivity.this.finish();
            }
        });
        iv_wenjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转文件界面

            }
        });
        iv_bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转编辑界面

            }
        });
        tv_bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转删除记录界面

            }
        });
    }
}
