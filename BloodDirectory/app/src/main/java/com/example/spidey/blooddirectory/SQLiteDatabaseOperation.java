package com.example.spidey.blooddirectory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteDatabaseOperation extends SQLiteOpenHelper
{
    static String dbname="BloodDirectory";
    SQLiteDatabase db;
    public SQLiteDatabaseOperation(Context context)
    {
        super(context, dbname, null,1);
        db=context.openOrCreateDatabase(dbname, SQLiteDatabase.CREATE_IF_NECESSARY,null,null);

        String qry="CREATE TABLE IF NOT EXISTS BLOODINFO (SRNO INTEGER PRIMARY KEY,NAME TEXT,DATE_OF_BIRTH TEXT,GENDER TEXT,BLOOD_GROUP TEXT,AGE INTEGER,USERNAME TEXT,PASSWORD TEXT,MONTH_SPAN_OF_DONATION TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT,CITY TEXT,INTERESTED_TO_DONATE_BLOOD TEXT)";

        db.execSQL(qry);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
    public long AddRecord(String r,String n,String dob,String g,String bg,String a,String un,String pass,String msod,String mn,String email,String city,String itdb)
    {
        db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("SRNO",r);
        cv.put("NAME",n);
        cv.put("DATE_OF_BIRTH",dob);
        cv.put("GENDER",g);
        cv.put("BLOOD_GROUP",bg);
        cv.put("AGE",a);
        cv.put("USERNAME",un);
        cv.put("PASSWORD",pass);
        cv.put("MONTH_SPAN_OF_DONATION",msod);
        cv.put("MOBILE_NUMBER",mn);
        cv.put("EMAIL",email);
        cv.put("CITY",city);
        cv.put("INTERESTED_TO_DONATE_BLOOD",itdb);
        long res=db.insert("BLOODINFO",null,cv);
        return (res);
    }
    public int DeleteRecord(String r)
    {
        db=this.getWritableDatabase();
        int res=db.delete("BLOODINFO","SRNO="+r,null);

        return (res);
    }

    public int UpdateRecordUsername(String r,String n)
    {
        db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("USERNAME",n);

        int res=db.update("BLOODINFO",cv,"SRNO="+r,null);
        return (res);
    }

    public int UpdateRecordEmail(String r,String n)
    {
        db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("EMAIL",n);

        int res=db.update("BLOODINFO",cv,"SRNO="+r,null);
        return (res);
    }

    public int UpdateRecordContact(String r,String n)
    {
        db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("MOBILE_NUMBER",n);

        int res=db.update("BLOODINFO",cv,"SRNO="+r,null);
        return (res);
    }

    public int UpdateRecordCity(String r,String n)
    {
        db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("CITY",n);

        int res=db.update("BLOODINFO",cv,"SRNO="+r,null);
        return (res);
    }

    public ArrayList ReadData(String r)
    {
        ArrayList list=new ArrayList();
        db=this.getReadableDatabase();

        String qry="select *from BLOODINFO where SRNO="+r;
        Cursor cr=db.rawQuery(qry,null);

        if(cr.moveToNext())
        {
            list.add(cr.getString(0));
            list.add(cr.getString(1));
            list.add(cr.getString(2));
            list.add(cr.getString(3));
            list.add(cr.getString(4));
            list.add(cr.getString(5));
            list.add(cr.getString(6));
            list.add(cr.getString(7));
            list.add(cr.getString(8));
            list.add(cr.getString(9));
        }
        return (list);
    }
    public ArrayList ReadDataProfile(String r)
    {
        ArrayList list=new ArrayList();
        db=this.getReadableDatabase();

        String qry="select *from BLOODINFO where SRNO="+r;
        Cursor cr=db.rawQuery(qry,null);

        if(cr.moveToNext())
        {
            list.add(cr.getString(0));
            list.add(cr.getString(1));
            list.add(cr.getString(2));
            list.add(cr.getString(3));
            list.add(cr.getString(4));
            list.add(cr.getString(5));
            list.add(cr.getString(6));
            list.add(cr.getString(7));
            list.add(cr.getString(8));
            list.add(cr.getString(9));
            list.add(cr.getString(10));
            list.add(cr.getString(11));
        }
        return (list);
    }
    public ArrayList ReadDataLogin(String r)
    {
        ArrayList list=new ArrayList();
        db=this.getReadableDatabase();

        String qry="select *from BLOODINFO where SRNO="+r;
        Cursor cr=db.rawQuery(qry,null);

        if(cr.moveToNext())
        {
            list.add(cr.getString(1));
            list.add(cr.getString(2));
            list.add(cr.getString(3));
            list.add(cr.getString(4));
            list.add(cr.getString(5));
            list.add(cr.getString(6));
            list.add(cr.getString(7));
            list.add(cr.getString(8));
        }
        return (list);
    }
}
