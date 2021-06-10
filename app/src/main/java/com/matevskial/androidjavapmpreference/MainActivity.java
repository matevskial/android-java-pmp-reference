package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


/**
 * * This is an activity class since it extends the AppCompatActivity class
 *
 * * An activity is class that is responsible for drawing some user interface,
 * dynamically modify the user interface and handle user interaction
 *
 * * Every activity class is tied to an xml file describing the layout of the user interface
 */
public class MainActivity extends AppCompatActivity {

    private Button constraintExampleButton;
    private Button listViewExampleButton;
    private Button recyclerViewExampleButton;

    /**
     * Predefined methods like this are called for the setup of the activity
     * This method specifies which layout xml file to inflateso it can be displayed and manipulated with
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintExampleButton = findViewById(R.id.constraintExampleButton);
        listViewExampleButton = findViewById(R.id.listViewExampleButton);
        recyclerViewExampleButton = findViewById(R.id.recyclerViewExampleButton);

        constraintExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConstraintExampleActivity.class);
            startActivity(intent);
        });

        listViewExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListViewExampleActivity.class);
            startActivity(intent);
        });

        recyclerViewExampleButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, RecyclerViewExampleActivity.class);
            startActivity(intent);
        });
    }
}