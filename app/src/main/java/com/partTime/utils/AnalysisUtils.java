package com.partTime.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MAIBENBEN on 2019/6/16.
 */

public class AnalysisUtils {
    /**
     * 从SharePreferences中读取登录用户名
     */
   public static String readLoginUserName(Context context){
       SharedPreferences sp=context.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
       String userName=sp.getString("loginUserName","");
       return userName;
   }
}
