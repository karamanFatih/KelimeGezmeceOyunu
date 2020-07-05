package com.e.oyun;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Seviye  {

    String seviye_No = "";
    String zorluk_Seviyesi = "";
    String kelime = "";
    String kullanicakHarfler = "";
    String altKelimeler = "";
    String kelimelerinKonumlandirmaBilgisi = "";


    public Seviye(String seviye_No, String zorluk_Seviyesi, String kelime, String kullanicakHarfler, String altKelimeler, String kelimelerinKonumlandirmaBilgisi) {
        this.seviye_No = seviye_No;
        this.zorluk_Seviyesi = zorluk_Seviyesi;
        this.kelime = kelime;
        this.kullanicakHarfler = kullanicakHarfler;
        this.altKelimeler = altKelimeler;
        this.kelimelerinKonumlandirmaBilgisi = kelimelerinKonumlandirmaBilgisi;
    }
    public Seviye(String seviye_No, String zorluk_Seviyesi) {
        this.seviye_No = seviye_No;
        this.zorluk_Seviyesi = zorluk_Seviyesi;

    }


    public String getSeviye_No() {
        return seviye_No;
    }

    public void setSeviye_No(String seviye_No) {
        this.seviye_No = seviye_No;
    }

    public String getZorluk_Seviyesi() {
        return zorluk_Seviyesi;
    }

    public void setZorluk_Seviyesi(String zorluk_Seviyesi) {
        this.zorluk_Seviyesi = zorluk_Seviyesi;
    }

    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }

    public String getKullanicakHarfler() {
        return kullanicakHarfler;
    }

    public void setKullanicakHarfler(String kullanicakHarfler) {
        this.kullanicakHarfler = kullanicakHarfler;
    }

    public String getAltKelimeler() {
        return altKelimeler;
    }

    public void setAltKelimeler(String altKelimeler) {
        this.altKelimeler = altKelimeler;
    }

    public String getKelimelerinKonumlandirmaBilgisi() {
        return kelimelerinKonumlandirmaBilgisi;
    }

    public void setKelimelerinKonumlandirmaBilgisi(String kelimelerinKonumlandirmaBilgisi) {
        this.kelimelerinKonumlandirmaBilgisi = kelimelerinKonumlandirmaBilgisi;
    }





}
