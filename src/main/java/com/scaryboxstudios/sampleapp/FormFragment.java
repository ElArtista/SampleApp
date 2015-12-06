package com.scaryboxstudios.sampleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;

public class FormFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_form, container, false);

        Button btn = (Button) view.findViewById(R.id.form_btn_submit);
        btn.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    CoordinatorLayout cdl = (CoordinatorLayout) view.findViewById(R.id.form_coord_layout);
                    Snackbar.make(cdl, R.string.foodle, Snackbar.LENGTH_SHORT).show();
                }
            }
        );

        return view;
    }
}
