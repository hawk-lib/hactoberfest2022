package com.whawk.mark;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.whawk.mark.HomeActivity.database_changed;

public class PasswordDB extends SQLiteOpenHelper {

    private static String name = "Password_Store";
    private static int version = 1;
    private static Context context;
    private SQLiteDatabase database;

    private List<DataEntry> passwordList;


    public PasswordDB(@Nullable Context context) {
        super(context, name, null, version);
        this.context = context;
    }

    public boolean openDB(int mode){
        if (mode == 0){
            database = this.getReadableDatabase();


        }else{
            database = this.getWritableDatabase();



        }
        return true;
    }

    public void closeDB(){
        database.close();
    }

    public boolean insertData(DataEntry entry){

        //String title, username, pasword1, password2, pin;

//        username = entry.getUsername();
//        if(username.isEmpty()){
//
//            username = "";
//
//        }else{
//            username = "";
//        }
        ContentValues contentValues = new ContentValues();

        contentValues.put("Title", entry.getTitle());
        contentValues.put("Username", entry.getUsername());
        contentValues.put("Password1", entry.getPassword1());
        contentValues.put("Password2", entry.getPassword2());
        contentValues.put("Pin", entry.getPin());

        //long checkIfAdded =
        if(database.insert("Data", null, contentValues) != 0){
            context.sendBroadcast(new Intent("com.whawk.mark.DATABASE_CHANGED"));
            database_changed = true;
            return true;
        }else{
            return false;
        }
    }
    public void deleteData(DataEntry entry){
        String[] title={entry.getTitle()};
        database.delete("Data", "Title = ?", title);
        database_changed = true;
        context.sendBroadcast(new Intent("com.whawk.mark.DATABASE_CHANGED"));

    }

    public void updateData(DataEntry entry){
        String[] title = {entry.getTitle()};

        ContentValues contentValues = new ContentValues();

        contentValues.put("Title", entry.getTitle());
        contentValues.put("Username", entry.getUsername());
        contentValues.put("Password1", entry.getPassword1());
        contentValues.put("Password2", entry.getPassword2());
        contentValues.put("Pin", entry.getPin());
        database.update("Data",contentValues, "Title = ?",title);

        database_changed = true;
        context.sendBroadcast(new Intent("com.whawk.mark.DATABASE_CHANGED"));

    }
    public List<DataEntry> getData() {

        Cursor cursor = database.query("Data", null, null, null, null, null, "Title ASC");
        cursor.moveToFirst();
        passwordList = new ArrayList<>();
        if (cursor.getCount() > 0) {
            do {
                passwordList.add(new DataEntry(
                        cursor.getString(cursor.getColumnIndex("Title")),
                        cursor.getString(cursor.getColumnIndex("Username")),
                        cursor.getString(cursor.getColumnIndex("Password1")),
                        cursor.getString(cursor.getColumnIndex("Password2")),
                        cursor.getString(cursor.getColumnIndex("Pin"))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return passwordList;
    }


    public void deleteAllData() {
        database.execSQL("delete from Data");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Data( Title TEXT , Username TEXT,Password1 TEXT, Password2 TEXT, Pin TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
