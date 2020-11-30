package com.example.sampleroyaandroid.repository;

import android.content.Context;


import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.networkApi.ApiClient;
import com.example.sampleroyaandroid.networkApi.ApiCountries;
import com.example.sampleroyaandroid.networkApi.CountryService;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CountriesRepository implements CountryService {
    private ApiCountries apiCountries;
    public static CountriesRepository instance;
    public Context context;
    private ApiClient apiClient;


    public CountriesRepository(Context Contex) {
        this.context = Contex;
        apiCountries=apiClient.getRetrofit().create(ApiCountries.class);
    }

    public static CountriesRepository getInstance(Context context) {
        if (instance == null)
            instance = new CountriesRepository(context);

        return instance;
    }

    @Override
    public Observable<List<CountryModel>> getAllCountries() {
        return apiCountries.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<CountryModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<CountryModel> countryModels) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }});
                }
    }

