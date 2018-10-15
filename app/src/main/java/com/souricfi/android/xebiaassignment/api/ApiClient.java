package com.souricfi.android.xebiaassignment.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.souricfi.android.xebiaassignment.model.Planets;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASEURL = "https://swapi.co/";

    static Retrofit retrofit;

    private static Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static ApiService getApiClient() {
        if (retrofit == null) {
            retrofit = getRetrofit();
        }

        return retrofit.create(ApiService.class);
    }

    static Planets planets;

    public static Planets getPlanets() {
        getApiClient().getPlanets().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                if (response.isSuccessful()) {
                    planets = response.body();
                }
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {

            }
        });

        return planets;
    }


    public static LiveData<Planets> getPlanetsLiveData() {
        final MutableLiveData<Planets> mutableLiveData = new MutableLiveData<>();
        getApiClient().getPlanets().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
