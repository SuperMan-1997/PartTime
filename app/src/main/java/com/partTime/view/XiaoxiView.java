package com.partTime.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.partTime.R;
/**
 * Created by MAIBENBEN on 2019/6/20.
 */

public class XiaoxiView {
    private Activity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;
    private TextView tv_main_title;
    private FrameLayout mXiaoxiLayout;
    private LinearLayout ll_xiaoxi;
    private TextView tv_back;
    private ImageView iv_kefu,iv_fenxiang,iv_tongzhi;
    public XiaoxiView(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView() {
        initView();
    }

    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.main_view_xiaoxi, null);
        ll_xiaoxi = (LinearLayout) mCurrentView.findViewById(R.id.ll_xiaoxi);
        iv_kefu = (ImageView) mCurrentView.findViewById(R.id.iv_kefu);
        tv_back=(TextView)mCurrentView.findViewById(R.id.tv_back);
        tv_back.setVisibility(View.GONE);
        iv_fenxiang = (ImageView) mCurrentView.findViewById(R.id.iv_fenxiang);
        iv_tongzhi = (ImageView) mCurrentView.findViewById(R.id.iv_tongzhi);
        tv_main_title=(TextView)mCurrentView.findViewById(R.id.tv_main_title);
        tv_main_title.setText("消息");
        mCurrentView.setVisibility(View.VISIBLE);
        iv_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
}
