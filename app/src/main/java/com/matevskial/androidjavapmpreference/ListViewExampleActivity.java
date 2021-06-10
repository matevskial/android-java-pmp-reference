package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewExampleActivity extends AppCompatActivity {
    private ListView entriesListView;

    private String[] entries;
    private ArrayAdapter<String> entriesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
        entriesListView = findViewById(R.id.entriesListView);

        entries = new String[]{"Entry 1", "Entry 2", "Entry 3"};
        entriesListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, entries);
        entriesListView.setAdapter(entriesListAdapter);
        entriesListView.setOnItemClickListener((list, row, index, rowId) -> {
            entries[index] = entries[index] + " x";
            entriesListAdapter.notifyDataSetChanged();
        });
    }
}