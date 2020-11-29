package com.example.sampleroyaandroid.repository;

import android.database.Observable;

import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.networkApi.ApiCountries;
import com.example.sampleroyaandroid.networkApi.CountryService;

import java.util.List;

public class CountriesRepository implements CountryService {
    private ApiCountries apiCountries;

    public CountriesRepository() {
     }

    @Override
    public Observable<List<CountryModel>> getAllCountries() {
        return null;
    }
}
