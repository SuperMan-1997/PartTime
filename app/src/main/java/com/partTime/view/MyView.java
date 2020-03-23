package com.partTime.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.partTime.R;
import com.partTime.activity.LoginActivity;
import com.partTime.activity.RenwuActivity;
import com.partTime.activity.SettingActivity;
import com.partTime.utils.AnalysisUtils;

/**
 * Created by MAIBENBEN on 2019/6/16.
 */

public class MyView {
    public ImageView iv_head;//头像
    private LinearLayout Wo_title_view;
    private TextView tv_main_title;
    private RelativeLayout r1_partTime_history, r1_renwu_history, r1_shezhi;
    private TextView tv_user_name;
    private Activity mContext;
    private TextView tv_back;
    private LayoutInflater mInflater;
    private View mCurrentView;

    public MyView(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView() {
        initView();
    }

    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.main_view_my, null);

        Wo_title_view = (LinearLayout) mCurrentView.findViewById(R.id.Wo_title_view);
        tv_back=(TextView)mCurrentView.findViewById(R.id.tv_back);
        tv_back.setVisibility(View.GONE);
        iv_head = (ImageView) mCurrentView.findViewById(R.id.iv_head);
        tv_main_title=(TextView)mCurrentView.findViewById(R.id.tv_main_title);
        tv_main_title.setText("我");
        r1_partTime_history = (RelativeLayout) mCurrentView.findViewById(R.id.r1_partTime_history);

        r1_renwu_history = (RelativeLayout) mCurrentView.findViewById(R.id.r1_renwu_history);

        r1_shezhi = (RelativeLayout) mCurrentView.findViewById(R.id.r1_shezhi);

        tv_user_name = (TextView) mCurrentView.findViewById(R.id.tv_user_name);

        mCurrentView.setVisibility(View.VISIBLE);

       setLoginParams(readLoginStatus());

        iv_head.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {

                } else {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    mContext.startActivityForResult(intent, 1);
                }
            }
        });
        r1_partTime_history.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //兼职记录
                } else {
                    Toast.makeText(mContext, "您还未登录，请登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1_renwu_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //跳转到小任务界面
                    Intent intent=new Intent(mContext, RenwuActivity.class);
                    mContext.startActivityForResult(intent,1);
                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1_shezhi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //跳转到设置界面
                    Intent intent=new Intent(mContext, SettingActivity.class);
                    mContext.startActivityForResult(intent,1);
                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void setLoginParams(boolean isLogin) {
        if (isLogin) {
            tv_user_name.setText(AnalysisUtils.readLoginUserName(mContext));
        } else {
            tv_user_name.setText("点击登录");
        }
    }

    public View getView() {
        if (mCurrentView == null) {
            createView();
    }
        return mCurrentView;
    }
    public void showView(){
        if (mCurrentView==null){
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }

    private boolean readLoginStatus() {
        SharedPreferences sp = mContext.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        return isLogin;
    }
}