package com.example.sampleroyaandroid.networkApi;

import android.database.Observable;
import com.example.sampleroyaandroid.model.CountryModel;
import retrofit2.http.GET;

public interface ApiCountries {
    @GET("/all")
    Observable<CountryModel> getCountries();
}
