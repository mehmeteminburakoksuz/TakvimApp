package com.example.takvimapp;

import static com.example.takvimapp.TakvimAraclari.ayYilTarih;
import static com.example.takvimapp.TakvimAraclari.aylarinGunleriArray;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.time.LocalDate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements TakvimUyarlama.Duzenleme{

    private TextView ayYilYazi;
    private RecyclerView takvimRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baslamaNokta();
       TakvimAraclari.guncelTarih = LocalDate.now();
        setAylariGoruntule();
    }




    private void setAylariGoruntule() {
        ayYilYazi.setText(ayYilTarih(TakvimAraclari.guncelTarih));

        ArrayList<LocalDate> aylardakiGunler = aylarinGunleriArray(TakvimAraclari.guncelTarih);

        TakvimUyarlama takvimUyarlama = new TakvimUyarlama(aylardakiGunler,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        takvimRecyclerView.setLayoutManager(layoutManager);
        takvimRecyclerView.setAdapter(takvimUyarlama);


    }




    private void baslamaNokta() {
        takvimRecyclerView = findViewById(R.id.TakvimGorunum);
        ayYilYazi = findViewById(R.id.ayYil);

    }


    public void OncekiAy(View view) {

        TakvimAraclari.guncelTarih = TakvimAraclari.guncelTarih.minusMonths(1);
        setAylariGoruntule();

    }

    public void SonrakiAy(View view) {
        TakvimAraclari.guncelTarih = TakvimAraclari.guncelTarih.plusMonths(1);
        setAylariGoruntule();


    }

    @Override
    public void duzenlemeTikla(int position, LocalDate date) {
        if(date!=null) {
            TakvimAraclari.guncelTarih = date;
            setAylariGoruntule();
        }
    }

    public void  HaftalikOlaylar(View view) {
        startActivity(new Intent(this,HaftaGorunum.class));


    }
}
