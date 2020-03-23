package com.partTime.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.partTime.R;
import com.partTime.view.GengweiView;
import com.partTime.view.MyView;
import com.partTime.view.ShouyeView;
import com.partTime.view.XiaoxiView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 中间内容
     */
    private FrameLayout mBodyLayout;
    /*
    底部按钮栏
     */
    private LinearLayout mBottomLayout;
    /*
    底部按钮中的图片和文字
     */
    private View mShouyeBtn;
    private View mGangweiBtn;
    private View mXiaoxiBtn;
    private View mWoBtn;
    private MyView myView;

    private TextView tv_Shouye;
    private TextView tv_Gangwei;
    private TextView tv_Xiaoxi;
    private TextView tv_Wo;

    private ImageView iv_Shouye;
    private ImageView iv_Gangwei;
    private ImageView iv_Xiaoxi;
    private ImageView iv_Wo;

    /*
    返回栏
     */
    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout r1_title_bar;
    private ShouyeView shouyeView;
    private GengweiView gengweiView;
    private XiaoxiView xiaoxiView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        initBottomBar();
        setListener();
        setInitStatus();
    }
    private void init() {
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        r1_title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        initBodyLayout();
    }


    private void initBottomBar() {
        mBottomLayout = (LinearLayout) findViewById(R.id.main_bottom_bar);

        mShouyeBtn = findViewById(R.id.bottom_bar_shouye_btn);
        mGangweiBtn = findViewById(R.id.bottom_bar_gangwei_btn);
        mXiaoxiBtn = findViewById(R.id.bottom_bar_xiaoxi_btn);
        mWoBtn = findViewById(R.id.bottom_bar_wo_btn);

        tv_Shouye = (TextView) findViewById(R.id.bottom_bar_shouye_text_btn);
        tv_Gangwei = (TextView) findViewById(R.id.bottom_bar_gangwei_text_btn);
        tv_Xiaoxi = (TextView) findViewById(R.id.bottom_bar_xiaoxi_text_btn);
        tv_Wo = (TextView) findViewById(R.id.bottom_bar_wo_text_btn);

        iv_Shouye = (ImageView) findViewById(R.id.bottom_bar_shouye_image_btn);
        iv_Gangwei = (ImageView) findViewById(R.id.bottom_bar_gangwei_image_btn);
        iv_Xiaoxi = (ImageView) findViewById(R.id.bottom_bar_xiaoxi_image_btn);
        iv_Wo = (ImageView) findViewById(R.id.bottom_bar_wo_image_btn);
    }

    private void initBodyLayout() {
        mBodyLayout = (FrameLayout) findViewById(R.id.main_body);

    }

    /*
    底部栏的控件的点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //首页的点击事件
            case R.id.bottom_bar_shouye_btn:
                clearBottomImageState();
                selectDisplayView(0);
                break;
            //岗位的点击事件
            case R.id.bottom_bar_gangwei_btn:
                clearBottomImageState();
                selectDisplayView(1);
                break;
            //消息的点击事件
            case R.id.bottom_bar_xiaoxi_btn:
                clearBottomImageState();
                selectDisplayView(2);
                break;
            //我的点击事件
            case R.id.bottom_bar_wo_btn:
                clearBottomImageState();
                selectDisplayView(3);
                break;
            default:
                break;
        }
    }

    /*
    设置底部四个按钮的点击监听事件
     */
    private void setListener() {
        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setOnClickListener(this);
        }
    }

    /*
    清除底部按钮的选中状态
     */
    private void clearBottomImageState() {
        tv_Shouye.setTextColor(Color.parseColor("#666666"));
        tv_Gangwei.setTextColor(Color.parseColor("#666666"));
        tv_Xiaoxi.setTextColor(Color.parseColor("#666666"));
        tv_Wo.setTextColor(Color.parseColor("#666666"));

        iv_Shouye.setImageResource(R.drawable.shouye);
        iv_Gangwei.setImageResource(R.drawable.gangwei);
        iv_Xiaoxi.setImageResource(R.drawable.xiaoxi);
        iv_Wo.setImageResource(R.drawable.wo);

        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setSelected(false);
        }
    }

    /*
    设置底部栏按钮的选中状态
     */
    private void setSelectedStatus(int index) {
        switch (index) {
            case 0:
                mShouyeBtn.setSelected(true);
                iv_Shouye.setImageResource(R.drawable.shouye);
                tv_Shouye.setTextColor(Color.parseColor("#0097F7"));

                r1_title_bar.setVisibility(View.VISIBLE);

                break;
            case 1:
                mGangweiBtn.setSelected(true);
                iv_Gangwei.setImageResource(R.drawable.gangwei);
                tv_Gangwei.setTextColor(Color.parseColor("#0097F7"));
                r1_title_bar.setVisibility(View.VISIBLE);

                break;
            case 2:
                mXiaoxiBtn.setSelected(true);
                iv_Xiaoxi.setImageResource(R.drawable.xiaoxi);
                tv_Xiaoxi.setTextColor(Color.parseColor("#0097F7"));
                r1_title_bar.setVisibility(View.GONE);

                break;
            case 3:
                mWoBtn.setSelected(true);
                iv_Wo.setImageResource(R.drawable.wo);
                tv_Wo.setTextColor(Color.parseColor("#0097F7"));
                r1_title_bar.setVisibility(View.GONE);

                break;

        }
    }

    private void removeAllView() {
        for (int i = 0; i < mBodyLayout.getChildCount(); i++) {
            mBodyLayout.getChildAt(i).setVisibility(View.GONE);
        }
    }
//设置界面的初始化
    private void setInitStatus() {
        clearBottomImageState();
        setSelectedStatus(0);
        createView(1);
    }
//显示对应的界面
    private void selectDisplayView(int index) {
        removeAllView();
        createView(index);
        setSelectedStatus(index);
    }
//选择要显示的视图
    private void createView(int viewIndex) {
        switch (viewIndex) {
            case 0:
               if (shouyeView==null){
                    shouyeView=new ShouyeView(this);
                    mBodyLayout.addView(shouyeView.getView());
                }else {
                    shouyeView.getView();
                }
                shouyeView.showView();
                break;
            case 1:
         if (gengweiView==null){
             gengweiView=new GengweiView(this);
            mBodyLayout.addView(gengweiView.getView());
        }else {
             gengweiView.getView();
        }
                gengweiView.showView();
                break;
            case 2:
                if (xiaoxiView==null){
                    xiaoxiView=new XiaoxiView(this);
                    mBodyLayout.addView(xiaoxiView.getView());
                }else {
                    xiaoxiView.getView();
                }
                xiaoxiView.showView();
                break;
            case 3:
                if (myView==null){
                    myView=new MyView(this);
                    mBodyLayout.addView(myView.getView());
                }else {
                    myView.getView();
                }
                myView.showView();
                break;
        }
    }

    protected long exitTime;//记录第一次点击的时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                MainActivity.this.finish();
                if (readLoginStatus()) {
                    clearLoginStatus();
                }
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

//获取登录状态
    private boolean readLoginStatus() {
        SharedPreferences sp=getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin=sp.getBoolean("isLogin",false);
        return isLogin;
}
//清除登录状态
    private void clearLoginStatus() {
        SharedPreferences sp=getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",false);
        editor.putString("loginUserName","");
        editor.commit();
    }
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            boolean isLogin=data.getBooleanExtra("isLogin",false);
            if (isLogin){
                clearBottomImageState();
                selectDisplayView(0);
            }
            if (myView !=null){
                myView.setLoginParams(isLogin);
            }
        }
    }
}