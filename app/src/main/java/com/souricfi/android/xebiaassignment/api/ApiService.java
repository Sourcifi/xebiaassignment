package com.souricfi.android.xebiaassignment.api;

import com.souricfi.android.xebiaassignment.model.Planets;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/planets")
    Call<Planets> getPlanets();
}
