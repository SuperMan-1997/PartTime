package com.partTime.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.partTime.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private TextView tv_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }
    private void init() {
        tv_welcome=(TextView) findViewById(R.id.tv_welcome);
        try{
            //获取程序包信息
            PackageInfo info=getPackageManager().getPackageInfo(getPackageName(), 0);
            tv_welcome.setText("V"+info.versionName);
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            tv_welcome.setText("V");
        }
        //设置延迟3秒后跳转，Timer中有一个线程，这个线程不断执行task
        Timer timer=new Timer();
        //在指定的时间内执行task
        TimerTask task=new TimerTask(){

            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
        //设置task在延迟3秒后自动执行
        timer.schedule(task, 5000);
    }
}
