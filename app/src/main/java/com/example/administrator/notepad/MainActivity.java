package com.example.administrator.notepad;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button textbtn,imgbtn,videobtn;
    private ListView lv;
    private Intent i;
    private MyAdapter adapter;
    private NotesDB notesDB;
    private SQLiteDatabase dbreader;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        lv = (ListView) findViewById(R.id.list);
        textbtn = (Button) findViewById(R.id.text);
        imgbtn = (Button) findViewById(R.id.img);
        videobtn = (Button) findViewById(R.id.video);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbreader = notesDB.getReadableDatabase();
    }

    @Override
    public void onClick(View view) {
        i=new Intent(this,AddContent.class);
        switch (view.getId()){
            case R.id.text:
                i.putExtra("flag","1");
                startActivity(i);
                break;

            case R.id.img:
                i.putExtra("flag","2");
                startActivity(i);
                break;

            case R.id.video:
                i.putExtra("flag","3");
                startActivity(i);
                break;
        }
    }

    public void selectDB(){
        Cursor cursor = dbreader.query(NotesDB.TABLE_NAME,null,null,null,null,null,null);
        adapter = new MyAdapter(this,cursor);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        selectDB();
    }
}
