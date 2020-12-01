package com.example.sampleroyaandroid.repository;

import android.content.Context;


import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.networkApi.ApiClient;
import com.example.sampleroyaandroid.networkApi.ApiCountries;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CountriesRepository  {
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

    private  void setAdapter(List<CountryModel> models){
        // TODO: 30/11/2020 set adapter
    }

    private void getAllCountry(){
        apiCountries.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CountryModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<CountryModel> countryModels) {
                        setAdapter(countryModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}