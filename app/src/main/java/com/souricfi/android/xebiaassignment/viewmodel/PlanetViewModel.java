package com.souricfi.android.xebiaassignment.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.souricfi.android.xebiaassignment.api.ApiClient;
import com.souricfi.android.xebiaassignment.model.Planets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetViewModel extends ViewModel {

    private Planets planets;
    private LiveData<Planets> planetsLiveData;
    private MutableLiveData<Planets> planetsMutableLiveData = new MutableLiveData<>();


    public PlanetViewModel() {
    }

    public PlanetViewModel(Planets planets) {
        this.planets = planets;
    }

    public Planets getPlanets() {
        if (planets == null) {
            planets = ApiClient.getPlanets();
        }
        return planets;
    }


    public LiveData<Planets> getPlanetsLiveData() {

        if (planetsLiveData == null) {
            planetsLiveData = ApiClient.getPlanetsLiveData();
        }
        return planetsLiveData;
    }
}
