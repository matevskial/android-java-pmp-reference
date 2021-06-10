package com.matevskial.androidjavapmpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class FragmentExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
        TextDataFragment fragment1 = TextDataFragment.newInstance("fragment 1");
        TextDataFragment fragment2 = TextDataFragment.newInstance("fragment 2");
        getSupportFragmentManager().beginTransaction()
                .add(R.id.textDataFragment1, fragment1)
                .add(R.id.textDataFragment2, fragment2)
                .commit();
    }
}