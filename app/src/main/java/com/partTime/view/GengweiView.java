package com.partTime.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.partTime.R;
import com.partTime.adapter.JobTimeAdapter;
import com.partTime.bean.JobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAIBENBEN on 2019/6/19.
 */

public class GengweiView {
    private ListView job_time_lv;
    private Activity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;
    private TextView tv_main_title;
    private TextView tv_back;
    private RelativeLayout r1_quanzhi,r1_shixi,r1_jianzhi,r1_xiaoshigong,r1_fabu;
    private List<JobBean> timeList;
    private JobTimeAdapter myJobAdapter;
    public GengweiView(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView() {
        initView();
    }

    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.main_view_gangwei, null);
        job_time_lv=(ListView)mCurrentView.findViewById(R.id.job_time_lv);
        tv_main_title=(TextView)mCurrentView.findViewById(R.id.tv_main_title);
        tv_main_title.setText("岗位");
        tv_back=(TextView)mCurrentView.findViewById(R.id.tv_back);
        tv_back.setVisibility(View.GONE);
        getDate();
        r1_quanzhi=(RelativeLayout)mCurrentView.findViewById(R.id.r1_quanzhi);
        r1_shixi=(RelativeLayout)mCurrentView.findViewById(R.id.r1_shixi);
        r1_jianzhi=(RelativeLayout)mCurrentView.findViewById(R.id.r1_jianzhi);
        r1_xiaoshigong=(RelativeLayout)mCurrentView.findViewById(R.id.r1_xiaoshigong);
        r1_fabu=(RelativeLayout)mCurrentView.findViewById(R.id.r1_fabu);
        myJobAdapter=new JobTimeAdapter(timeList,mContext);
        job_time_lv.setAdapter(myJobAdapter);
        mCurrentView.setVisibility(View.VISIBLE);
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
    public void getDate() {
        timeList = new ArrayList<JobBean>();
        timeList = new ArrayList<JobBean>();
        timeList.add(new JobBean("希尔顿大酒店", "北京路", "5km","全职","18154394149","2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("雅阁大酒店", "北京路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("武当国际大酒店", "朝阳路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("回家吃饭大饭店", "北京路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("大本营大酒店", "人民路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("环球一号", "北京路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("爷爷家的土钵菜", "上海路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("李二鲜鱼村", "朝阳路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("维纳斯水疗", "朝阳路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
        timeList.add(new JobBean("香格里拉", "北京路", "5km","全职","18154394149", "2019/6/18 09:00-17:30"));
    }
}
