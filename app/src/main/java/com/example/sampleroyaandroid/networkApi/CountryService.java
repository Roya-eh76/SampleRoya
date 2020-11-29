package com.example.sampleroyaandroid.networkApi;

import android.database.Observable;

import com.example.sampleroyaandroid.model.CountryModel;

import java.util.List;

public interface CountryService {
    Observable<List<CountryModel>> getAllCountries();

}
