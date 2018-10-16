package com.souricfi.android.xebiaassignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.souricfi.android.xebiaassignment.R;
import com.souricfi.android.xebiaassignment.activity.PlanetDetailsActivity;
import com.souricfi.android.xebiaassignment.model.Planets;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PRATHITAH-1 on 5/10/2018.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private Context context;
    List<Planets.Result> planets = new ArrayList<>();

    List<Integer> images = new ArrayList<>();

    public PlanetAdapter(Context context, List<Planets.Result> planets) {
        this.context = context;
        this.planets = planets;

        images.add(R.drawable.planet_1);
        images.add(R.drawable.planet_2);
        images.add(R.drawable.planet_3);
        images.add(R.drawable.planet_earth);
        images.add(R.drawable.planet_jupiter);
        images.add(R.drawable.planet_mars);
        images.add(R.drawable.planet_mercury);
        images.add(R.drawable.planet_neptune);
        images.add(R.drawable.planet_saturn);
        images.add(R.drawable.planet_uranus);
        images.add(R.drawable.planet_venus);
        images.add(R.drawable.planet_1);
    }

    public void setValue(List<Planets.Result> planets) {
        this.planets = planets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Planets.Result planet = planets.get(position);
        final int image = position < images.size() ? images.get(position) : images.get(images.size() - position);
        Picasso.get().load(image).placeholder(R.drawable.ic_launcher_foreground).into(holder.imageView);
        holder.txtPlanetName.setText(planet.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlanetDetailsActivity.class);
                planet.setImage(image);
                intent.putExtra("planet", planet);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivPlanet)
        CircleImageView imageView;

        @BindView(R.id.txtPlanetName)
        TextView txtPlanetName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

//            txtPlanetName = itemView.findViewById(R.id.txtPlanetName);
        }
    }
}