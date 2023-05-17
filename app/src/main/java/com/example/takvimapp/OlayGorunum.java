package com.example.takvimapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalTime;

public class OlayGorunum extends AppCompatActivity {


    private EditText olayAdi;
    private TextView olayTarihi,olayZamani;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olay_gorunum);
        initWidgets();
        time = LocalTime.now();
        olayTarihi.setText("Tarih: " + TakvimAraclari.formattedTarih(TakvimAraclari.guncelTarih));
        olayZamani.setText("Zaman: " + TakvimAraclari.formattedZaman(time));
    }

    private void initWidgets() {
        olayAdi = findViewById(R.id.olayAdi);
        olayTarihi = findViewById(R.id.olayTarihi);
        olayZamani = findViewById(R.id.olayZamani);
    }

    public void yeniOlayKaydet(View view) {
    String olayAdi1 = olayAdi.getText().toString();
    Olay yeniOlay = new Olay(olayAdi1,TakvimAraclari.guncelTarih,time);
    Olay.olayListe.add(yeniOlay);
    finish();

    }
}