package com.example.takvimapp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class TakvimAraclari {

    public static LocalDate guncelTarih;

    public static String formattedTarih(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }

    public static String formattedZaman(LocalTime time)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }


    public static String ayYilTarih(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);

    }

    public static ArrayList<LocalDate> aylarinGunleriArray(LocalDate tarih) {


        ArrayList<LocalDate> aylarinGunleriArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(tarih);

        int aylarinGunleri = yearMonth.lengthOfMonth();

        LocalDate ilkAy = TakvimAraclari.guncelTarih.withDayOfMonth(1);
        int haftaninGunleri = ilkAy.getDayOfWeek().getValue();

        for(int i=1;i<=42;i++){
            if(i <= haftaninGunleri || i > aylarinGunleri + haftaninGunleri ){
                aylarinGunleriArray.add(null);
            }
            else{
                aylarinGunleriArray.add(LocalDate.of(guncelTarih.getYear(),guncelTarih.getMonth(),i - haftaninGunleri));
            }
        }
        return aylarinGunleriArray;
    }

    public static ArrayList<LocalDate> HaftaninGunleriArray(LocalDate guncelTarih) {

        ArrayList<LocalDate> gunler = new ArrayList<>();
        LocalDate current = tarihPazar(guncelTarih);
        LocalDate sonTarih = current.plusWeeks(1);

        while (current.isBefore(sonTarih)){
            gunler.add(current);
            current.plusDays(1);
        }

        return gunler;
    }

    private static LocalDate tarihPazar(LocalDate current) {

        LocalDate birHaftaOnce = current.minusWeeks(1);

        while(current.isAfter(birHaftaOnce)){

            if(current.getDayOfWeek()==DayOfWeek.SUNDAY)
                return current;
            current= current.minusDays(1);
        }
        return null;

    }



}
