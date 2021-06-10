package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DialogsExampleActivity extends AppCompatActivity {
    private Button showAlertDialogButton;
    private Button showCustomDialogButton;
    private TextView textView;

    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs_example);
        showAlertDialogButton = findViewById(R.id.showAlertDialogButton);
        showCustomDialogButton = findViewById(R.id.showCustomDialogButton);
        textView = findViewById(R.id.textView);

        text = "Some text";
        textView.setText(text);

        showAlertDialogButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm modification");
            builder.setMessage("Do you want to modify the text?");
            builder.setPositiveButton("Yes", (dialog, id) -> {
                text += " x";
                textView.setText(text);
            });
            builder.setNegativeButton("No", (dialog, id) -> dialog.cancel());
            builder.create().show();
        });

        showCustomDialogButton.setOnClickListener(v -> {
            FragmentManager manager = getSupportFragmentManager();
            CustomDialogFragment fragment = CustomDialogFragment.newInstance();
            fragment.show(manager, "CUSTOM_FRAGMENT");
        });
    }

    protected void changeText(String newText) {
        text = newText;
        textView.setText(text);
    }
}