package com.souricfi.android.xebiaassignment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.souricfi.android.xebiaassignment.adapter.PlanetAdapter;
import com.souricfi.android.xebiaassignment.model.Planets;
import com.souricfi.android.xebiaassignment.viewmodel.PlanetViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    PlanetViewModel planetViewModel;
    RecyclerView.LayoutManager layoutManager;
    PlanetAdapter adapter;
    List<Planets.Result> planets = new ArrayList<>();
    LiveData<Planets> planetsLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);

        planetViewModel.getPlanetsLiveData().observe(this, new Observer<Planets>() {
            @Override
            public void onChanged(@Nullable Planets result) {
                planets.clear();
                planets.addAll(result.getResults());
                adapter.setValue(planets);
            }
        });

        adapter = new PlanetAdapter(this, planets);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);


    }
}
