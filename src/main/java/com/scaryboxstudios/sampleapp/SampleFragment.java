package com.scaryboxstudios.sampleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class SampleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);

        // Set the text contents
        Bundle args = getArguments();
        if (args != null) {
            String textContents = args.getString("tc");
            if (textContents != null) {
                TextView tv = (TextView) view.findViewById(R.id.text_contents);
                tv.setText(textContents);
            }
        }

        return view;
    }
}
