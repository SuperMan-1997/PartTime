package com.partTime.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.partTime.R;
import com.partTime.utils.AnalysisUtils;
import com.partTime.utils.MD5Utils;

public class XiugaiPswActivity extends AppCompatActivity {
    private TextView tv_main_title;
    private TextView tv_back;
    private EditText et_old_psw,et_new_psw,et_again_new_psw;
    private Button btn_save;
    private String oldpsw,newPsw,newPswAgain;
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugai_psw);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        userName= AnalysisUtils.readLoginUserName(this);
    }

    private void init() {
        tv_main_title=(TextView)findViewById(R.id.tv_main_title);
        tv_main_title.setText("修改密码");
        tv_back=(TextView)findViewById(R.id.tv_back);
        et_old_psw=(EditText) findViewById(R.id.et_old_psw);
        et_new_psw=(EditText) findViewById(R.id.et_new_psw);
        et_again_new_psw=(EditText) findViewById(R.id.et_again_new_psw);
        btn_save=(Button) findViewById(R.id.btn_save);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XiugaiPswActivity.this.finish();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if (TextUtils.isEmpty(oldpsw)) {
                    Toast.makeText(XiugaiPswActivity.this, "请输入原始密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!MD5Utils.md5(oldpsw).equals(readPsw())) {
                    Toast.makeText(XiugaiPswActivity.this, "输入的密码与原始密码不一致", Toast.LENGTH_SHORT).show();
                    return;

                } else if (TextUtils.isEmpty(newPsw)) {
                    Toast.makeText(XiugaiPswActivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(newPswAgain)) {
                    Toast.makeText(XiugaiPswActivity.this, "请再次输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!newPsw.equals(newPswAgain)) {
                    Toast.makeText(XiugaiPswActivity.this, "两次输入的新密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(XiugaiPswActivity.this, "新密码设置成功", Toast.LENGTH_SHORT).show();
                    //修改登录成功时保存在SharedPreferences中的密码
                    xiugaiPsw(newPsw);
                    Intent intent = new Intent(XiugaiPswActivity.this, LoginActivity.class);
                    startActivity(intent);
                    SettingActivity.instance.finish();
                    XiugaiPswActivity.this.finish();
                }
            }
        });
    }
    private void getEditString() {
      oldpsw=et_old_psw.getText().toString().trim();
      newPsw=et_new_psw.getText().toString().trim();
      newPswAgain=et_again_new_psw.getText().toString().trim();
    }
    //将修改后的密码保存到SharedPreferences中
    private void xiugaiPsw(String newPsw) {
        String md5Psw=MD5Utils.md5(newPsw);
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("username",md5Psw);
        editor.commit();
    }
//读取原始密码
    private String readPsw() {
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPsw=sp.getString(userName,"");
        return spPsw;
    }


}
