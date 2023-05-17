package com.example.takvimapp;

import static com.example.takvimapp.TakvimAraclari.HaftaninGunleriArray;
import static com.example.takvimapp.TakvimAraclari.ayYilTarih;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import java.time.LocalDate;
import java.util.ArrayList;


public class HaftaGorunum extends AppCompatActivity implements TakvimUyarlama.Duzenleme{


    private TextView ayYilYazi;
    private RecyclerView takvimRecyclerView;
    private ListView olayListeGorunumu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafta_gorunum);
        baslamaNokta();

        setHaftaGoruntule();
    }

    private void setHaftaGoruntule() {
        ayYilYazi.setText(ayYilTarih(TakvimAraclari.guncelTarih));

        ArrayList<LocalDate> gunler = HaftaninGunleriArray(TakvimAraclari.guncelTarih);

        TakvimUyarlama takvimUyarlama = new TakvimUyarlama(gunler,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        takvimRecyclerView.setLayoutManager(layoutManager);
        takvimRecyclerView.setAdapter(takvimUyarlama);

        setOlayUyarlama();
    }



    private void baslamaNokta() {
        takvimRecyclerView = findViewById(R.id.TakvimGorunum);
        ayYilYazi = findViewById(R.id.ayYil);
        olayListeGorunumu = findViewById(R.id.olayListeGorunumu);

    }

    public void OncekiHafta(View view) {
        TakvimAraclari.guncelTarih = TakvimAraclari.guncelTarih.minusWeeks(1);
        setHaftaGoruntule();
    }

    public void SonrakiHafta(View view) {
        TakvimAraclari.guncelTarih = TakvimAraclari.guncelTarih.plusWeeks(1);
        setHaftaGoruntule();
    }

    public void yeniOlay(View view)
    {
    startActivity(new Intent(this, OlayGorunum.class));

    }

    @Override
    public void duzenlemeTikla(int position, LocalDate date) {
        TakvimAraclari.guncelTarih = date;
        setHaftaGoruntule();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setOlayUyarlama();
    }

    private void setOlayUyarlama() {

        ArrayList<Olay> gunlukOlaylar = Olay.tarihOlay(TakvimAraclari.guncelTarih);
        OlayUyarlama olayUyarlama = new OlayUyarlama(getApplicationContext(),gunlukOlaylar);
        olayListeGorunumu.setAdapter(olayUyarlama);

    }
}