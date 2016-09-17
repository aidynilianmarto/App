package com.example.pc.olx.Shop;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.olx.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationHomeFragment extends DialogFragment {

    public InformationHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_information_home, container, false);
        return root;
    }
    @Override
    public void onDismiss(DialogInterface dialog) {

    }

}
