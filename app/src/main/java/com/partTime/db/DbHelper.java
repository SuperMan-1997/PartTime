package com.partTime.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MAIBENBEN on 2019/6/21.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    public static String DB_NAME = "jog.db";//库
    public static String TB_JOB="TB_JOB";//表
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  IF NOT EXISTS " + TB_JOB + "( "
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "company VARCHAR, "
                + "addr VARCHAR, "
                + "juli VARCHAR, "
                + "joptype VARCHAR, "
                + "phone VARCHAR, "
                + "joptime datetime"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_JOB);
        onCreate(db);
    }
}
