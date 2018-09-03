package com.ksntechnology.filemangement.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ksntechnology.filemangement.R;

public class Fragment1 extends Fragment {

    public static Fragment1 newInstance() {
        Fragment1 fm = new Fragment1();
        Bundle args = new Bundle();
        fm.setArguments(args);
        return fm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment1, container, false
        );

        initInstance(view);
        return view;
    }

    private void initInstance(View view) {
    }

}
