package com.example.takvimapp;

import android.app.usage.UsageEvents;
import android.media.metrics.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Olay
{
    public static ArrayList<Olay> olayListe = new ArrayList<>();

    public  static  ArrayList<Olay> tarihOlay(LocalDate date)
    {
        ArrayList<Olay> olaylar= new ArrayList<>();

        for (Olay olay : olayListe)
        {
            if (olay.getDate().equals(date))
                olaylar.add(olay);
        }

        return olaylar;
    }

    private  String name;
    private LocalDate date;
    private LocalTime time;


    public Olay(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
