package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SQLiteExampleActivity extends AppCompatActivity {

    SQLiteDatabase db;

    private TextView usernameTextView;
    private TextView loginTimesTextView;
    private Button selectRandomEntryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite_example);
        usernameTextView = findViewById(R.id.usernameTextView);
        loginTimesTextView = findViewById(R.id.loginTimesTextView);
        selectRandomEntryButton = findViewById(R.id.selectRandomEntryButton);

        db = openOrCreateDatabase("sqliteexample", MODE_PRIVATE, null);
        if(!existsTable()) {
            db.execSQL("create table users (username varchar(55), logintimes int)");
            db.execSQL("insert into users values('wilder', 2)");
            db.execSQL("insert into users values('wick', 3)");
            db.execSQL("insert into users values('norris', -1)");
        }


        selectRandomEntryButton.setOnClickListener(v -> selectRandomEntry());
    }

    private boolean existsTable() {
        Cursor cr = db.rawQuery("select * from users", null);
        boolean result = cr.moveToFirst();
        cr.close();
        return result;
    }

    private void selectRandomEntry() {
        Cursor cr = db.rawQuery("select count(*) from users", null);

        int numberOfRows = 0;
        if(cr.moveToFirst()) {
            numberOfRows = cr.getInt(0);
        }

        cr.close();
        int random = new Random().nextInt(numberOfRows);
        int count = 0;

        cr = db.rawQuery("select * from users", null);
        if(cr.moveToFirst()) {
            do {
                if(count == random) {
                    usernameTextView.setText(
                            cr.getString(cr.getColumnIndex("username")));
                    loginTimesTextView.setText(
                            String.valueOf(cr.getInt(cr.getColumnIndex("logintimes"))));
                    break;
                } else {
                    count++;
                }
            } while(cr.moveToNext());
        }
        cr.close();
    }
}