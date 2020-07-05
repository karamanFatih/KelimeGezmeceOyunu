package com.e.oyun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {


    private static final String veritabani_adi = "veritabani_oyun";
    private static final String oyun_tablosu = "oyun";
    private static final int veritabani_versiyon = 1;

    private static final String seviyeler_1_tablosu = "seviyeler_1_tablosu";
    private static final String seviyeler_2_tablosu = "seviyeler_2_tablosu";
    private static final String seviyeler_3_tablosu = "seviyeler_3_tablosu";


    public Database(@Nullable Context context) {

        super(context, veritabani_adi, null, veritabani_versiyon);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tablolar oluşturulur

        String sql_oyuncuTablosuOlusturma = "CREATE TABLE " + oyun_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, oyuncuAdi TEXT," +
                "oyuncuEmail TEXT,oyuncuSeviye TEXT,oyuncuZorluk TEXT,oyuncuSkor TEXT)";
        db.execSQL(sql_oyuncuTablosuOlusturma);
        String sql_seviyler_TablosuOlusturma = "CREATE TABLE " + seviyeler_1_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " seviye TEXT,zorluk TEXT,kelime TEXT,harfler TEXT,altKelimeler TEXT,konumlandirma TEXT)";
        db.execSQL(sql_seviyler_TablosuOlusturma);

        String sql_seviyler_TablosuOlusturma2 = "CREATE TABLE " + seviyeler_2_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " seviye TEXT,zorluk TEXT,kelime TEXT,harfler TEXT,altKelimeler TEXT,konumlandirma TEXT)";
        db.execSQL(sql_seviyler_TablosuOlusturma2);
        String sql_seviyler_TablosuOlusturma3 = "CREATE TABLE " + seviyeler_3_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " seviye TEXT,zorluk TEXT,kelime TEXT,harfler TEXT,altKelimeler TEXT,konumlandirma TEXT)";
        db.execSQL(sql_seviyler_TablosuOlusturma3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + oyun_tablosu);
    }

    public long ekleOyuncu(Oyuncu oyuncu) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("OyuncuAdi", oyuncu.getAd());
        cv.put("OyuncuEmail", oyuncu.getEmail());
        cv.put("OyuncuSeviye", oyuncu.getSeviye());
        cv.put("OyuncuZorluk", oyuncu.getZorluk());
        cv.put("oyuncuSkor", "0");

        long id = db.insert(oyun_tablosu, null, cv);
        return id;
    }

    public long ekleSeviye1e(Seviye seviye) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("seviye", seviye.getSeviye_No());
        cv.put("zorluk", seviye.getZorluk_Seviyesi());
        cv.put("kelime", seviye.getKelime());
        cv.put("harfler", seviye.getKullanicakHarfler());
        cv.put("altKelimeler", seviye.getAltKelimeler());
        cv.put("konumlandirma", seviye.getKelimelerinKonumlandirmaBilgisi());

        long id = db.insert(seviyeler_1_tablosu, null, cv);
        return id;
    }

    public long ekleSeviye2e(Seviye seviye) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("seviye", seviye.getSeviye_No());
        cv.put("zorluk", seviye.getZorluk_Seviyesi());
        cv.put("kelime", seviye.getKelime());
        cv.put("harfler", seviye.getKullanicakHarfler());
        cv.put("altKelimeler", seviye.getAltKelimeler());
        cv.put("konumlandirma", seviye.getKelimelerinKonumlandirmaBilgisi());

        long id = db.insert(seviyeler_2_tablosu, null, cv);
        return id;
    }

    public long ekleSeviye3e(Seviye seviye) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("seviye", seviye.getSeviye_No());
        cv.put("zorluk", seviye.getZorluk_Seviyesi());
        cv.put("kelime", seviye.getKelime());
        cv.put("harfler", seviye.getKullanicakHarfler());
        cv.put("altKelimeler", seviye.getAltKelimeler());
        cv.put("konumlandirma", seviye.getKelimelerinKonumlandirmaBilgisi());

        long id = db.insert(seviyeler_3_tablosu, null, cv);
        return id;
    }

    public Seviye seviye1_zorluga_gore_Getir(Seviye seviye) {


        try {

            SQLiteDatabase db = this.getReadableDatabase();


            Cursor cursor = db.rawQuery("select * from seviyeler_1_tablosu where zorluk='" + seviye.getZorluk_Seviyesi() + "'", null);

            cursor.moveToFirst();
            seviye.setSeviye_No(cursor.getString(cursor.getColumnIndex("seviye")));
            seviye.setZorluk_Seviyesi(cursor.getString(cursor.getColumnIndex("zorluk")));
            seviye.setKelime(cursor.getString(cursor.getColumnIndex("kelime")));
            seviye.setKullanicakHarfler(cursor.getString(cursor.getColumnIndex("harfler")));
            seviye.setAltKelimeler(cursor.getString(cursor.getColumnIndex("altKelimeler")));
            seviye.setKelimelerinKonumlandirmaBilgisi(cursor.getString(cursor.getColumnIndex("konumlandirma")));
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return seviye;
    }



    public Seviye seviye2_zorluga_gore_Getir(Seviye seviye) {


        try {

            SQLiteDatabase db = this.getReadableDatabase();


            Cursor cursor = db.rawQuery("select * from seviyeler_2_tablosu where zorluk='" + seviye.getZorluk_Seviyesi() + "'", null);

            cursor.moveToFirst();
            seviye.setSeviye_No(cursor.getString(cursor.getColumnIndex("seviye")));
            seviye.setZorluk_Seviyesi(cursor.getString(cursor.getColumnIndex("zorluk")));
            seviye.setKelime(cursor.getString(cursor.getColumnIndex("kelime")));
            seviye.setKullanicakHarfler(cursor.getString(cursor.getColumnIndex("harfler")));
            seviye.setAltKelimeler(cursor.getString(cursor.getColumnIndex("altKelimeler")));
            seviye.setKelimelerinKonumlandirmaBilgisi(cursor.getString(cursor.getColumnIndex("konumlandirma")));
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return seviye;
    }

    public Seviye seviye3_zorluga_gore_Getir(Seviye seviye) {


        try {

            SQLiteDatabase db = this.getReadableDatabase();


            Cursor cursor = db.rawQuery("select * from seviyeler_3_tablosu where zorluk='" + seviye.getZorluk_Seviyesi() + "'", null);

            cursor.moveToFirst();
            seviye.setSeviye_No(cursor.getString(cursor.getColumnIndex("seviye")));
            seviye.setZorluk_Seviyesi(cursor.getString(cursor.getColumnIndex("zorluk")));
            seviye.setKelime(cursor.getString(cursor.getColumnIndex("kelime")));
            seviye.setKullanicakHarfler(cursor.getString(cursor.getColumnIndex("harfler")));
            seviye.setAltKelimeler(cursor.getString(cursor.getColumnIndex("altKelimeler")));
            seviye.setKelimelerinKonumlandirmaBilgisi(cursor.getString(cursor.getColumnIndex("konumlandirma")));
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return seviye;
    }


    public void oyuncuSeviyeSkorGuncelle(Oyuncu oyuncu) {

        // String sql_oyuncuTablosuOlusturma = "CREATE TABLE " + oyun_tablosu + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, oyuncuAdi TEXT," +
        //         "oyuncuEmail TEXT,oyuncuSeviye TEXT,oyuncuZorluk TEXT,oyuncuSkor TEXT)";
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = " update oyun set oyuncuSeviye ='" + oyuncu.getSeviye() + "',oyuncuZorluk='" + oyuncu.getZorluk() + "' where oyuncuEmail='" + oyuncu.getEmail() + "'";
        db.execSQL(sql);

    }

    public String aktifOyuncuGetir(String email) {
        // String _email="";
        String _ad = "";
        String _skor = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from oyun where oyuncuEmail='" + email + "'", null);

            cursor.moveToFirst();
            _ad = cursor.getString(cursor.getColumnIndex("oyuncuAdi"));
            // _email = cursor.getString(cursor.getColumnIndex("oyuncuEmail"));
            _skor = cursor.getString(cursor.getColumnIndex("oyuncuSkor"));
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "oyuncu :  " + _ad + "                                     skor : " + _skor;
    }

    public String oyuncuAdiGetir(String email) {

        String _ad = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from oyun where oyuncuEmail='" + email + "'", null);

            cursor.moveToFirst();
            _ad = cursor.getString(cursor.getColumnIndex("oyuncuAdi"));
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return _ad;
    }

    public String oyuncuSkorGetir(String email) {

        String _skor = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from oyun where oyuncuEmail='" + email + "'", null);

            cursor.moveToFirst();
            _skor = cursor.getString(cursor.getColumnIndex("oyuncuSkor"));
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return _skor;
    }




    public Seviye oyuncununKaldigiSeviyeZorlukGetir(String email) {
        Seviye seviye;
        String _seviye = "";
        String _zorluk = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from oyun where oyuncuEmail='" + email + "'", null);

            cursor.moveToFirst();
            _seviye = cursor.getString(cursor.getColumnIndex("oyuncuSeviye"));
            _zorluk = cursor.getString(cursor.getColumnIndex("oyuncuZorluk"));

            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        seviye = new Seviye(_seviye, _zorluk);

        return seviye;
    }

    public Boolean oyuncuVarmiKontrolEt(String email) {
        String _email = "";

        try {

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from oyun where oyuncuEmail='" + email + "'", null);

            cursor.moveToFirst();

            _email = cursor.getString(cursor.getColumnIndex("oyuncuEmail"));

            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (_email.equals("")) {
            return false;
        } else {
            return true;
        }

    }


}
