package com.partTime.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.partTime.R;
import com.partTime.utils.MD5Utils;

public class RegisterActivity extends AppCompatActivity {
    private TextView tv_main_title;
    private TextView tv_back;
    private Button btn_register;
    private EditText et_user,et_psw,et_psw_again;
    private String username,psw,pswAgain;
    private RelativeLayout r1_title_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_main_title.setText("注册");
        tv_back=(TextView)findViewById(R.id.tv_back);
        r1_title_bar=(RelativeLayout)findViewById(R.id.title_bar);
        r1_title_bar.setBackgroundColor(Color.TRANSPARENT);
        btn_register=(Button)findViewById(R.id.btn_register);
        et_user=(EditText)findViewById(R.id.et_user);
        et_psw=(EditText)findViewById(R.id.et_psw);
        et_psw_again=(EditText)findViewById(R.id.et_psw_again);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.this.finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入在相应控件中的字符串
               getEditString();
               if (TextUtils.isEmpty(username)){
                   Toast.makeText(RegisterActivity.this,"请输入用户名", Toast.LENGTH_SHORT).show();
                   return;
                }else if (TextUtils.isEmpty(psw)){
                   Toast.makeText(RegisterActivity.this,"请输入密码", Toast.LENGTH_SHORT).show();
                   return;
               }else if (TextUtils.isEmpty(pswAgain)){
                   Toast.makeText(RegisterActivity.this,"请再次输入密码", Toast.LENGTH_SHORT).show();
                   return;
               }else if (!psw.equals(pswAgain)){
                   Toast.makeText(RegisterActivity.this,"输入两次的密码不一样", Toast.LENGTH_SHORT).show();
                   return;
               }else if (isExistUserName(username)){
                   Toast.makeText(RegisterActivity.this,"用户名已经存在", Toast.LENGTH_SHORT).show();
                   return;
               }else {
                   Toast.makeText(RegisterActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
                   saveRegisterInfo(username,psw);
                   Intent data=new Intent();
                   data.putExtra("username",username);
                   setResult(RESULT_OK,data);
                   RegisterActivity.this.finish();
               }
            }
        });
    }


//获取控件中的字符串
    private void getEditString() {
        username=et_user.getText().toString().trim();
        psw=et_psw.getText().toString().trim();
        pswAgain=et_psw_again.getText().toString().trim();
    }
    //从SharedPreferences中读取输入的用户名，并判断用户是否存在
    private  boolean isExistUserName(String username){
        boolean has_username=false;
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPsw=sp.getString(username,"");
        if (!TextUtils.isEmpty(spPsw)){
            has_username=true;
        }
        return has_username;
    }
    //将用户名和密码保存在SharedPreferences中
    private void saveRegisterInfo(String username, String psw) {
        String md5Psw= MD5Utils.md5(psw);
        //loginInfin表示文件名
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        //username为key  psw为值
        editor.putString(username,md5Psw);
        editor.commit();//提交
    }

}
