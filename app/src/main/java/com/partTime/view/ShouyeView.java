package com.partTime.view;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.partTime.R;
import com.partTime.activity.GengduoActivity;
import com.partTime.activity.MingPianActivity;
import com.partTime.activity.SousuoActivity;
import com.partTime.adapter.JobTimeAdapter;
import com.partTime.bean.JobBean;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by MAIBENBEN on 2019/6/19.
 */
public class ShouyeView {
    private RelativeLayout r1_sousuo,r1_cade,r1_sao,r1_gengduo;
    private Activity mContext;
    private LayoutInflater mInflater;
    private TextView tv_main_title;
    private TextView tv_back;
    private View mCurrentView;
    private ListView jlist;
    private List<JobBean> timeList;
    public ShouyeView(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView() {
        initView();
}

    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.main_view_shouye, null);
        r1_sousuo=(RelativeLayout)mCurrentView.findViewById(R.id.r1_sousuo);
        r1_cade=(RelativeLayout)mCurrentView.findViewById(R.id.r1_cade);
        r1_sao=(RelativeLayout)mCurrentView.findViewById(R.id.r1_sao);
        r1_gengduo=(RelativeLayout)mCurrentView.findViewById(R.id.r1_gengduo);
        tv_main_title=(TextView)mCurrentView.findViewById(R.id.tv_main_title);
        tv_main_title.setText("首页");
        tv_back=(TextView)mCurrentView.findViewById(R.id.tv_back);
        tv_back.setVisibility(View.GONE);
        mCurrentView.setVisibility(View.VISIBLE);
        jlist=(ListView)mCurrentView.findViewById(R.id.lv_shouye_jianzhi);
        getDate();
        JobTimeAdapter myAdapter=new JobTimeAdapter(timeList,mContext);
        jlist.setAdapter(myAdapter);
        jlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (readLoginStatus()) {
                    //跳转到搜索
                    Intent intent=new Intent(mContext, SousuoActivity.class);
                    mContext.startActivityForResult(intent,1);
                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //跳转到搜索
                    Intent intent=new Intent(mContext, SousuoActivity.class);
                    mContext.startActivityForResult(intent,1);
                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //跳转到扫一扫
//                    Intent intent=new Intent(mContext, SaoActivity.class);
//                    mContext.startActivityForResult(intent,1);

                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1_gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //跳转到更多
                    Intent intent=new Intent(mContext, GengduoActivity.class);
                    mContext.startActivityForResult(intent,1);
                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
        r1_cade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (readLoginStatus()) {
                    //跳转到更多
                    Intent intent=new Intent(mContext, MingPianActivity.class);
                    mContext.startActivityForResult(intent,1);
                } else {
                    Toast.makeText(mContext, "您还未登录，请选择登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            Bundle bundle = data.getExtras();
//            //显示扫描到的内容
//            text.setText(bundle.getString("result"));
//        }
//
//    }

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
    private boolean readLoginStatus() {
        SharedPreferences sp = mContext.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin = sp.getBoolean("isLogin", false);
        return isLogin;
    }

}
