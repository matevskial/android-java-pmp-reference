package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CalledWithIntentActivity extends AppCompatActivity {
    private TextView dataTextView1;
    private TextView dataTextView2;
    private Button closeActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_with_intent);
        dataTextView1 = findViewById(R.id.dataTextView1);
        dataTextView2 = findViewById(R.id.dataTextView2);
        closeActivityButton = findViewById(R.id.closeActivityButton);

        Intent intent = getIntent();
        dataTextView1.setText(intent.getStringExtra("data1"));
        dataTextView2.setText(intent.getStringExtra("data2"));

        closeActivityButton.setOnClickListener(v -> {
            intent.putExtra("returnedData", "some returned data");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}