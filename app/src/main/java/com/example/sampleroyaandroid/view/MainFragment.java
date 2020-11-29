package com.example.sampleroyaandroid.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleroyaandroid.R;
import com.example.sampleroyaandroid.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_main, container, false);

        return binding.getRoot();
    }
}