package com.partTime.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.partTime.R;
/**
 * Created by MAIBENBEN on 2019/6/20.
 */

public class AdBannerFragment extends Fragment {
    private String ab;
    private ImageView iv;
    public static AdBannerFragment newInstance(Bundle args) {
        AdBannerFragment af = new AdBannerFragment();
        af.setArguments(args);
        return af;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arg = getArguments();
        // 获取广告图片名称
        ab = arg.getString("ad");
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ab != null) {
            if ("banner_1".equals(ab)) {
                iv.setImageResource(R.drawable.ganggao2);
            } else if ("banner_2".equals(ab)) {
                iv.setImageResource(R.drawable.ganggao3);
            } else if ("banner_3".equals(ab)) {
                iv.setImageResource(R.drawable.ganggao4);
            }

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (iv != null) {
            iv.setImageDrawable(null);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 创建广告图片控件
        iv = new ImageView(getActivity());
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT);
        iv.setLayoutParams(lp);// 设置图片宽高参数
        iv.setScaleType(ImageView.ScaleType.FIT_XY);// 把图片塞满整个控件
        return iv;
    }
}