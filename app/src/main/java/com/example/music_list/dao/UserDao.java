package com.example.music_list.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.music_list.DataBase.DataBaseHelper;
import com.example.music_list.vo.User;

public class UserDao {
    private final Context context;        //上下文
    private DataBaseHelper dbHelper;//数据库管理对象
    private SQLiteDatabase db;      //可对数据库进行读写的操作对象

    public UserDao(Context context) {
        this.context = context;
    }

    //创建并打开数据库（如果数据库已存在直接打开）
    public void open() throws SQLiteException {
        dbHelper = new DataBaseHelper(context);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException exception) {
            db = dbHelper.getReadableDatabase();
        }
    }

    //关闭数据库
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    //添加用户信息
    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put("account", user.account);
        values.put("password", user.password);
        db.insert("user", null, values);
    }


    //查询用户信息
    public boolean find(User user) {
        //查询user表中where指定列元素的记录
        Cursor cursor = db.query("user", null, "account = ?", new String[]{user.account}, null, null, null);
        if (cursor == null || cursor.getCount() < 1) {
            return false;
        }
        if (cursor.moveToFirst()) {
            do {
                //遍历cursor对象，取出数据并打印
                @SuppressLint("Range") String acc = cursor.getString(cursor.getColumnIndex("account"));
                @SuppressLint("Range") String pass = cursor.getString(cursor.getColumnIndex("password"));
                Log.d("UserDao", "user account is" + acc);
                Log.d("UserDao", "user password is " + pass);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return true;
    }

    //判断账号是否存在
    public boolean isExist(String account) {
        Cursor cursor = db.query("user", null, "account = ?",
                new String[] {account}, null, null, null);
        return cursor != null && cursor.getCount() > 0;
    }

    //根据账号来查找用户密码，登录时校验密码
    public String getPassword(String account) {
        Cursor cursor = db.query("user", null, "account = ?",
                new String[] {account}, null, null, null);
        cursor.moveToFirst();
        @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
        return password;
    }
}
