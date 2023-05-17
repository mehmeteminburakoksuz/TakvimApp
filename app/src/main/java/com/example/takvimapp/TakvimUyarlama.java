package com.example.takvimapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class TakvimUyarlama extends RecyclerView.Adapter<TakvimGorunum>
{

    private final ArrayList<LocalDate> gunler;
    private final Duzenleme duzenleme;

    public TakvimUyarlama(ArrayList<LocalDate> gunler, Duzenleme duzenleme)
    {
        this.gunler = gunler;
        this.duzenleme = duzenleme;
    }

    @NonNull
    @Override
    public TakvimGorunum onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.takvim_sinifi,parent,false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
       if(gunler.size() > 15) //Ay görünümü
        layoutParams.height =(int) (parent.getHeight() * 0.166666666);
        else // Hafta görünümü
           layoutParams.height = (int) parent.getHeight();

        return new TakvimGorunum( view, duzenleme,gunler);
    }

    @Override
    public void onBindViewHolder(@NonNull TakvimGorunum gorunum, int position) {
        final LocalDate date = gunler.get(position);
        if (date==null)
           gorunum.gunVeAy.setText("");
        else {
            gorunum.gunVeAy.setText(String.valueOf(date.getDayOfMonth()));
            if(date.equals(TakvimAraclari.guncelTarih))
                gorunum.parentView.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public int getItemCount() {
        return gunler.size();
    }
    public interface Duzenleme{
        void duzenlemeTikla(int position,LocalDate date);

    }

}
