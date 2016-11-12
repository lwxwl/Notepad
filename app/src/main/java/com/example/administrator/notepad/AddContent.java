package com.example.administrator.notepad;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Date;

import static com.example.administrator.notepad.R.layout.addcontent;


/**
 * Created by Administrator on 2016/11/9.
 */

public class AddContent extends Activity implements View.OnClickListener {

    private String val;
    private Button savebtn, deletebtn;
    private EditText ettext;
    private ImageView c_img;
    private VideoView c_video;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(addcontent);
        val = getIntent().getStringExtra("flag");
        savebtn = (Button) findViewById(R.id.save);
        deletebtn = (Button) findViewById(R.id.delete);
        ettext = (EditText) findViewById(R.id.ettext);
        c_img = (ImageView) findViewById(R.id.c_img);
        c_video = (VideoView) findViewById(R.id.c_video);
        savebtn.setOnClickListener(this);
        deletebtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.save:
                addDB();
                finish();
                break;

            case R.id.delete:
                finish();
                break;
        }
    }

    public void addDB(){
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT, ettext.getText().toString());
        cv.put(NotesDB.TIME, getTime());
        dbWriter.insert(NotesDB.TABLE_NAME,null,cv);
    }

    private String getTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String str = format.format(date);
        return str;
    }
}







