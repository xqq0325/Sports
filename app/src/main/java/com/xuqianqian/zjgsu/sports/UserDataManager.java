package com.xuqianqian.zjgsu.sports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class UserDataManager {
    private static final String TAG = "UserDataManager";
    private static final String DB_NAME = "user_data";
    private static final String TABLE_NAME = "users";
    public static final String ID = "_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_PWD = "user_pwd";

    private static final int DB_VERSION = 2;
    private Context mContext = null;


    private static final String DB_CREATE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID + " integer primary key," + USER_NAME + " varchar,"
            + USER_PWD + " varchar" + ");";

    private SQLiteDatabase mSQLiteDatabase = null;
    private DataBaseManagementHelper mDatabaseHelper = null;


    private static class DataBaseManagementHelper extends SQLiteOpenHelper {

        DataBaseManagementHelper(Context context) {

            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
            db.execSQL(DB_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onCreate(db);
        }
    }

    public UserDataManager(Context context) {
        mContext = context;
        Log.i(TAG, "UserDataManager construction!");
    }

    public void openDataBase() throws SQLException {
        mDatabaseHelper = new DataBaseManagementHelper(mContext);
        mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
    }

    public void closeDataBase() throws SQLException {
        mDatabaseHelper.close();
    }

    public long insertUserData(UserData userData) {
        String userName=userData.getUserName();
        String userPwd=userData.getUserPwd();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_PWD, userPwd);
        return mSQLiteDatabase.insert(TABLE_NAME, ID, values);
    }

    public boolean updateUserData(UserData userData) {

        String userName = userData.getUserName();
        String userPwd = userData.getUserPwd();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_PWD, userPwd);
        return mSQLiteDatabase.update(TABLE_NAME, values,null, null) > 0;

    }



    public int findUserByName(String userName){

        int result=0;
        Cursor mCursor=mSQLiteDatabase.query(TABLE_NAME, null, USER_NAME+"="+userName, null, null, null, null);
        if(mCursor!=null){
            result=mCursor.getCount();
            mCursor.close();
        }
        return result;
    }

    public int findUserByNameAndPwd(String userName,String pwd){

        int result=0;
        Cursor mCursor=mSQLiteDatabase.query(TABLE_NAME, null, USER_NAME+"="+userName+" and "+USER_PWD+"="+pwd,
                null, null, null, null);
        if(mCursor!=null){
            result=mCursor.getCount();
            mCursor.close();

        }
        return result;
    }
}


