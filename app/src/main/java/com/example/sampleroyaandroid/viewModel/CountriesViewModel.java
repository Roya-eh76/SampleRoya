package com.example.sampleroyaandroid.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.repository.CountriesRepository;

import java.util.List;

public class CountriesViewModel extends ViewModel {
    private MutableLiveData<List<CountryModel>> list = new MutableLiveData<List<CountryModel>>();
    private CountriesRepository countriesRepository;



    public MutableLiveData<List<CountryModel>> getList(Context context) {
        countriesRepository = CountriesRepository.getInstance(context);
        return countriesRepository.getList();
    }
}

