package com.souricfi.android.xebiaassignment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.souricfi.android.xebiaassignment.R;
import com.souricfi.android.xebiaassignment.model.Planets;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetDetailsActivity extends AppCompatActivity {

    Planets.Result planet;

    @BindView(R.id.image)
    ImageView ivPlanet;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvClimate)
    TextView tvClimate;

    @BindView(R.id.tvDiameter)
    TextView tvDiameter;

    @BindView(R.id.tvGravity)
    TextView tvGravity;

    @BindView(R.id.tvOrbitalPeriod)
    TextView tvOrbitalPeriod;

    @BindView(R.id.tvPopulation)
    TextView tvPopulation;

    @BindView(R.id.tvTerrain)
    TextView tvTerrain;

    @BindView(R.id.tvWater)
    TextView tvWater;

    @BindView(R.id.tvRotationPeriod)
    TextView tvRotationPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        planet = (Planets.Result) getIntent().getSerializableExtra("planet");

        Picasso.get().load(planet.getImage()).into(ivPlanet);
        getSupportActionBar().setTitle(planet.getName());

        tvName.setText(planet.getName());
        tvClimate.setText(planet.getClimate());
        tvDiameter.setText(planet.getDiameter());
        tvGravity.setText(planet.getGravity());
        tvOrbitalPeriod.setText(planet.getOrbitalPeriod());
        tvPopulation.setText(planet.getPopulation());
        tvRotationPeriod.setText(planet.getRotationPeriod());
        tvTerrain.setText(planet.getTerrain());
        tvWater.setText(planet.getSurfaceWater());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
