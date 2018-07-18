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
    public static final int VERSION_NUMBER = 3;

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(100) NOT NULL,"+EMAIL+" VARCHAR(100) NOT NULL,"+PASSWORD+" VARCHAR(50) NOT NULL,"+PHONE+" VARCHAR(15) NOT NULL";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"Create",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context,"Error: "+e,Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){

            Toast.makeText(context,"Error: "+e,Toast.LENGTH_SHORT).show();

        }

    }
}
