package com.example.takvimapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class TakvimGorunum extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final ArrayList<LocalDate> gunler;
    public final View parentView;
    public final TextView gunVeAy;
    private final TakvimUyarlama.Duzenleme duzenleme;
    public TakvimGorunum( @NonNull View itemView, TakvimUyarlama.Duzenleme duzenleme,ArrayList<LocalDate> gunler) {
        super(itemView);
        parentView = itemView.findViewById(R.id.parentView);
        gunVeAy=itemView.findViewById(R.id.sinifGunleri);
        this.duzenleme = duzenleme;
        itemView.setOnClickListener(this);
        this.gunler=gunler;
    }

    @Override
    public void onClick(View view) {
        duzenleme.duzenlemeTikla(getAdapterPosition(),gunler.get(getAdapterPosition()));
    }
}
