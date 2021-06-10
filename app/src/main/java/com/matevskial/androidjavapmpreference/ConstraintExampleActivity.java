package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Activity for demonstrating constraint layout
 *
 * Contains simple button that generates the text that the TextView displays
 */
public class ConstraintExampleActivity extends AppCompatActivity {

    private Button generateButton;
    private TextView displayGeneratedText;

    private String[] textCollection = new String[]{"Text 1", "Text 2", "Text 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_example);
        generateButton = findViewById(R.id.generateButton);
        displayGeneratedText = findViewById(R.id.displayGeneratedText);

        generateButton.setOnClickListener(v -> displayGeneratedText.setText(generateText()));
    }

    private String generateText() {
        int idx = new Random().nextInt(textCollection.length);
        return textCollection[idx];
    }
}