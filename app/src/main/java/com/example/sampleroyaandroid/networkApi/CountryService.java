package com.example.sampleroyaandroid.networkApi;


import com.example.sampleroyaandroid.model.CountryModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface CountryService {
    Observable<List<CountryModel>> getAllCountries();
}
