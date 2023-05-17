package com.example.takvimapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class OlayUyarlama extends ArrayAdapter<Olay> {


    public OlayUyarlama(@NonNull Context context, List<Olay> olays) {
        super(context, 0,olays);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Olay olay = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.olay_sinifi, parent, false);

        TextView olaySinifi = convertView.findViewById(R.id.olaySinifi);

        String olayBaslik = olay.getName() +" "+ TakvimAraclari.formattedZaman(olay.getTime());
        olaySinifi.setText(olayBaslik);
        return convertView;
    }
}
