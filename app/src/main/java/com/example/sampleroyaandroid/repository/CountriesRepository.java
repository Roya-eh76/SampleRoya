package com.example.sampleroyaandroid.repository;

import android.content.Context;
import android.util.Log;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.networkApi.ApiClient;
import com.example.sampleroyaandroid.networkApi.ApiCountries;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesRepository  {
    private ApiCountries apiCountries;
    public static CountriesRepository instance;
    public Context context;
    private ApiClient apiClient;
    private MutableLiveData<List<CountryModel>> list=new MutableLiveData<>();

    public CountriesRepository(Context Contex) {
        this.context = Contex;
        apiClient=ApiClient.getInstance(Contex);
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

    public void getAllCountry(){
/*        apiCountries.getCountries()
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
                });*/

        Call<List<CountryModel>> call = apiCountries.getCountries();
        call.enqueue(getRetrofitCountryCallback());


    }


    public MutableLiveData<List<CountryModel>> getList() {
        return list;
    }

    private Callback<List<CountryModel>> getRetrofitCountryCallback() {
        return new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                List<CountryModel> countriesItems =response.body();
                list.setValue(countriesItems);
                Log.d("dsfdf","pass");

            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                Log.d("dsfdf","failed");
            }

        };
    }

}