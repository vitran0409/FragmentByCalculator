package com.example.vitran.demofragmentbycalculator.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vitran.demofragmentbycalculator.R;

public class DetailFragment extends Fragment {
    TextView tvkq;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_detail, container, true);
        tvkq = fragmentView.findViewById(R.id.tvkq);
        return fragmentView;
    }

}
