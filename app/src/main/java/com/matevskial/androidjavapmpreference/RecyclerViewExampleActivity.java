package com.matevskial.androidjavapmpreference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewExampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private String[] entries;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);
        recyclerView = findViewById(R.id.recyclerView);

        entries = new String[]{"Entry 1", "Entry 2", "Entry 3"};
        adapter = new CustomAdapter(entries);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private static class CustomViewHolder extends RecyclerView.ViewHolder {

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setItemViewData(String itemData) {
            TextView itemTextView = itemView.findViewById(R.id.viewHolderItemTextView);
            itemTextView.setText(itemData);
        }
    }

    private static class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

        private String[] arr;

        public CustomAdapter(String[] arr) {
            this.arr = arr;
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View recyclerListItem = inflater.inflate(R.layout.view_holder_item, parent, false);
            CustomViewHolder viewHolder = new CustomViewHolder(recyclerListItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            String itemData = arr[position];
            holder.setItemViewData(itemData);
        }

        @Override
        public int getItemCount() {
            return arr.length;
        }
    }
}