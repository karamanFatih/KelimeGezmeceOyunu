package com.e.oyun;

import java.io.Serializable;

public class Oyuncu implements Serializable {
    private  int Id;
    String ad;
    String email;
    String seviye ="1";
    String zorluk ="1";

    public Oyuncu(String ad, String email,String seviye) {
        this.ad = ad;
        this.email = email;
        this.seviye = seviye;
    }

    public String getZorluk() {
        return zorluk;
    }

    public void setZorluk(String zorluk) {
        this.zorluk = zorluk;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAd() {
        return ad;
    }

    public String getSeviye() {
        return seviye;
    }

    public void setSeviye(String seviye) {
        this.seviye = seviye;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
