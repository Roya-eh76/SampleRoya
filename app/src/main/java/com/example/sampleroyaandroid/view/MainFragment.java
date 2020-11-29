package com.example.sampleroyaandroid.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleroyaandroid.R;
import com.example.sampleroyaandroid.databinding.FragmentMainBinding;
import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.view.adapter.CountriesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private CountriesAdapter countriesAdapter;


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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        countriesAdapter = new CountriesAdapter(null, requireContext());
        binding.recyclerView.setAdapter(countriesAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));


        return binding.getRoot();
    }
}