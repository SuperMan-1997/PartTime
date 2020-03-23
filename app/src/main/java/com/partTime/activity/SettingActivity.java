package com.partTime.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.partTime.R;

public class SettingActivity extends AppCompatActivity {
    private TextView tv_main_title;
    private TextView tv_back;
    private RelativeLayout r1_title_bar;

    private RelativeLayout r1_xiugai_psw, r1_shezhi_mibao,r1_tuichu;

    public static SettingActivity instance=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        instance=this;
        init();
    }

    private void init() {
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_main_title.setText("设置");
        tv_back=(TextView)findViewById(R.id.tv_back);
        r1_title_bar=(RelativeLayout)findViewById(R.id.title_bar);


        r1_xiugai_psw=(RelativeLayout)findViewById(R.id.r1_xiugai_psw);
        r1_shezhi_mibao=(RelativeLayout)findViewById(R.id.r1_shezhi_mibao);
        r1_tuichu=(RelativeLayout)findViewById(R.id.r1_tuichu);
        //返回的点击事件
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingActivity.this.finish();
            }
        });
        //修改密码点击事件
        r1_xiugai_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转修改密码界面
                Intent intent=new Intent(SettingActivity.this,XiugaiPswActivity.class);
                startActivity(intent);
            }
        });
        r1_shezhi_mibao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转修改密保界面
                Intent intent=new Intent(SettingActivity.this,FindPswActivity.class);
                startActivity(intent);
            }
        });
        //退出点击事件
        r1_tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this,"退出成功", Toast.LENGTH_SHORT).show();
                clearLoginStatus();
                Intent data=new Intent();
                data.putExtra("isLogin",false);
                setResult(RESULT_OK,data);
                SettingActivity.this.finish();
            }
        });
    }
//清除登录状态和用户名
    private void clearLoginStatus() {
        SharedPreferences sp=getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",false);
        editor.putString("loginUserName","");
        editor.commit();
    }
}
