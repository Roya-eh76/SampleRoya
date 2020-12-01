package com.example.sampleroyaandroid.networkApi;

 import com.example.sampleroyaandroid.model.CountryModel;

 import java.util.List;

 import io.reactivex.rxjava3.core.Observable;
 import retrofit2.Call;
 import retrofit2.http.GET;

public interface ApiCountries {
    @GET("all")
    Call<List<CountryModel>> getCountries();
}
