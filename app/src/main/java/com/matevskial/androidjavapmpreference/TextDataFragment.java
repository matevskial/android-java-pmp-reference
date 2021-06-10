package com.matevskial.androidjavapmpreference;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextDataFragment extends Fragment {

    private static final String ARG_TEXT_DATA = "textData";

    private String textData;

    private TextView textDataTextView;

    public TextDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param textData data that the fragment willl display
     * @return A new instance of fragment TextDataFragment.
     */
    public static TextDataFragment newInstance(String textData) {
        TextDataFragment fragment = new TextDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT_DATA, textData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_text_data, container, false);
        textDataTextView = v.findViewById(R.id.textDataTextView);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        if(arguments != null) {
            textData = getArguments().getString(ARG_TEXT_DATA);
        } else {
            textData = "";
        }

        textDataTextView.setText(textData);
    }
}