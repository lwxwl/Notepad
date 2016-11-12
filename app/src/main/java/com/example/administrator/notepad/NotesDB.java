package com.example.administrator.notepad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;


/**
 * Created by Administrator on 2016/11/9.
 */

public class NotesDB extends SQLiteOpenHelper {
    public static final String TABLE_NAME ="notes";
    public static final String CONTENT ="content";
    public static final String PATH = "path";
    public static final String VEDIO= "vedio";
    public static final String ID = "id";
    public static final String TIME="time";

    public NotesDB(Context context) {
        super(context, "notes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + CONTENT
                + " TEXT NOT NULL," + PATH + " TEXT NOT NULL," + VEDIO
                + TIME + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
