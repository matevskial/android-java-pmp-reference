package com.matevskial.androidjavapmpreference;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomDialogFragment extends DialogFragment {

    private Button positiveButton;
    private Button negativeButton;
    private EditText editText;

    public CustomDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CustomDialogFragment.
     */
    public static CustomDialogFragment newInstance() {
        return new CustomDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.dialogfragment_custom_dialog, container, false);
        DialogsExampleActivity parentActivity = (DialogsExampleActivity) getActivity();
        positiveButton = v.findViewById(R.id.positiveButton);
        negativeButton = v.findViewById(R.id.negativeButton);
        editText = v.findViewById(R.id.editText);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DialogsExampleActivity parentActivity = (DialogsExampleActivity) getActivity();
        positiveButton.setOnClickListener(listenedView -> {
            if(parentActivity != null) {
                parentActivity.changeText(editText.getText().toString());
            }
            dismiss();
        });

        negativeButton.setOnClickListener(listenedView -> dismiss());
    }
}