package com.example.salahuddin.humansafety;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Salahuddin on 7/12/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserDetails.db";
    public static final String TABLE_NAME = "User_information";
    public static final String ID = "id";
    public static final String NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";
    public static final String PHONE = "Phone";
    public static final int VERSION_NUMBER = 5;

    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+ID+" integer primary key autoincrement,"+NAME+" varchar(20) not null,"+EMAIL+" varchar(30) not null,"+PASSWORD+" varchar(50) not null,"+PHONE+" varchar(40)not null)";
    private static final String DROP_TABLE = "drop table if exists "+TABLE_NAME;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"oN Create is called",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context,"oN Upgrade is called",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){

            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_SHORT).show();

        }

    }
}
