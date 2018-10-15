package com.souricfi.android.xebiaassignment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.souricfi.android.xebiaassignment.R;
import com.souricfi.android.xebiaassignment.model.Planets;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PRATHITAH-1 on 5/10/2018.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {

    private Context context;
    List<Planets.Result> planets = new ArrayList<>();

    public PlanetAdapter(Context context, List<Planets.Result> planets) {
        this.context = context;
        this.planets = planets;
    }

    public void setValue(List<Planets.Result> planets){
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
        Planets.Result planet = planets.get(position);
        holder.txtPlanetName.setText(planet.getName());
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
//            ButterKnife.bind(this,itemView);

            txtPlanetName = itemView.findViewById(R.id.txtPlanetName);
        }
    }
}