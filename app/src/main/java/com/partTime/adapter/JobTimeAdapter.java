package com.partTime.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.partTime.R;
import com.partTime.activity.JopTiem;
import com.partTime.bean.JobBean;

import java.util.List;

/**
 * Created by MAIBENBEN on 2019/6/19.
 */

public class JobTimeAdapter extends BaseAdapter {
    private List<JobBean> timeList;
    private Context context;
    private LayoutInflater mLi;

    public JobTimeAdapter(List<JobBean> timeList, Context context) {
        this.timeList = timeList;
        this.context = context;
        mLi = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return timeList.size();
    }

    @Override
    public Object getItem(int i) {
        return timeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //1.动态加载布局
        //2.通过postion索引获取对象
        //3.获取动态布局中的控件并赋值
        ViewHolder vh = null;
        if (view == null) {
            view = mLi.inflate(R.layout.job_time_item, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        //获取i对应的数据对象
        final JobBean u_info = timeList.get(i);
        if (u_info!=null) {
            vh.company_name.setText(u_info.getCompany());
            vh.company_addr.setText(u_info.getAddr());
            vh.company_juli.setText(u_info.getJuli());
            vh.tv_quanzhi.setText(u_info.getJoptype());
            vh.company_phone.setText(u_info.getPhone());
            vh.jop_time.setText(u_info.getJoptime());
        }
        //每个Item的点击事件
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (u_info==null){
                    return;
                }
                //跳转兼职详情界面
                Intent intent=new Intent(context, JopTiem.class);
                //把兼职所有的信息都传递到兼职详情界面中去
                intent.putExtra("id",u_info.getId());
                intent.putExtra("company",u_info.getCompany());
                intent.putExtra("addr",u_info.getAddr());
                intent.putExtra("juli",u_info.getJuli());
                intent.putExtra("joptype",u_info.getJoptype());
                intent.putExtra("phone",u_info.getPhone());
                intent.putExtra("joptime",u_info.getJoptime());
                context.startActivity(intent);
            }
        });
        return view;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView company_name;
        public TextView company_addr;
        public TextView company_juli;
        public TextView company_phone;
        public TextView tv_quanzhi;
        public TextView jop_time;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.company_name = (TextView) rootView.findViewById(R.id.company_name);
            this.company_addr = (TextView) rootView.findViewById(R.id.company_addr);
            this.company_juli = (TextView) rootView.findViewById(R.id.company_juli);
            this.company_phone = (TextView) rootView.findViewById(R.id.company_phone);
            this.tv_quanzhi = (TextView) rootView.findViewById(R.id.tv_quanzhi);
            this.jop_time = (TextView) rootView.findViewById(R.id.jop_time);

        }

    }
}




