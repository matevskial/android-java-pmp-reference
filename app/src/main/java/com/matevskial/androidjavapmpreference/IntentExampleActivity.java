package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class IntentExampleActivity extends AppCompatActivity {
    private static final int INTENT_CALLED_ACTIVITY_RESULT_REQ_CODE = 6009;
    private Button startActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example);
        startActivityButton = findViewById(R.id.startActivityButton);

        startActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalledWithIntentActivity.class);
            String extraData1 = "One";
            String extraData2 = "Two";
            intent.putExtra("data1", extraData1);
            intent.putExtra("data2", extraData2);
            startActivityForResult(intent, INTENT_CALLED_ACTIVITY_RESULT_REQ_CODE);
        });
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent intent) {
        super.onActivityResult(reqCode, resCode, intent);
        String returnedData = intent.getStringExtra("returnedData");
        Toast.makeText(this, String.format("Got back: %s", returnedData),
                Toast.LENGTH_SHORT).show();
    }
}