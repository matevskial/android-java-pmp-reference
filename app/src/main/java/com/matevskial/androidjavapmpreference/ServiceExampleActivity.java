package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ServiceExampleActivity extends AppCompatActivity {

    private TextView bigNumberTextView;
    private Button startBigNumberServiceButton;

    private static class ReceiverForBigNumberService extends BroadcastReceiver {
        private final TextView textView;

        public ReceiverForBigNumberService(TextView textView) {
            this.textView = textView;
        }
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra("bigNumber");
            textView.setText(data);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);
        bigNumberTextView = findViewById(R.id.bigNumberTextView);
        startBigNumberServiceButton = findViewById(R.id.startBigNumberServiceButton);

        IntentFilter filter = new IntentFilter();
        filter.addAction("calculateBigNumber");
        registerReceiver(new ReceiverForBigNumberService(bigNumberTextView), filter);

        startBigNumberServiceButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalculateBigNumberService.class);
            intent.setAction("calculateBigNumber");
            startService(intent);
        });

    }
}