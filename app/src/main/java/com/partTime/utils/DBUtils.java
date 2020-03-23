package com.partTime.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.partTime.bean.JobBean;
import com.partTime.db.DbHelper;

/**
 * Created by MAIBENBEN on 2019/6/21.
 */

public class DBUtils {
    private static DBUtils instance = null;
    private static DbHelper helper;
    private static SQLiteDatabase db;
    public DBUtils(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }
    public static DBUtils getInstance(Context context) {
        if (instance == null) {
            instance = new DBUtils(context);
        }
        return instance;
    }
    //保存
    public void saveUserInfo(JobBean bean) {
        ContentValues cv = new ContentValues();
        cv.put("id", bean.getId());
        cv.put("company", bean.getCompany());
        cv.put("addr", bean.getAddr());
        cv.put("juli", bean.getJuli());
        cv.put("joptype", bean.getJoptype());
        cv.put("phone", bean.getPhone());
        cv.put("joptime", bean.getJoptime());
        db.insert(DbHelper.TB_JOB, null, cv);
    }
    //查询
    public JobBean getUserInfo(String userName) {
        String sql = "SELECT * FROM " + DbHelper.TB_JOB + " WHERE userName=?";
        Cursor cursor = db.rawQuery(sql, new String[]{userName});
        JobBean bean = null;
        while (cursor.moveToNext()) {
            bean = new JobBean();
            bean.company=cursor.getString(cursor.getColumnIndex("company"));
            bean.addr=cursor.getString(cursor.getColumnIndex("addr"));
            bean.juli=cursor.getString(cursor.getColumnIndex("juli"));
            bean.joptype=cursor.getString(cursor.getColumnIndex("joptype"));
            bean.phone=cursor.getString(cursor.getColumnIndex("phone"));
            bean.joptime=cursor.getString(cursor.getColumnIndex("joptime"));
        }
        cursor.close();
        return bean;
    }
}
