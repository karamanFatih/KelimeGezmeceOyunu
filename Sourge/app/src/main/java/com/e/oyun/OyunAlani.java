package com.e.oyun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class OyunAlani extends AppCompatActivity {

    String ad;
    String email;
    String olusturulan_kelime = "";
    Seviye seviye;
    Boolean key = false;
    String bulunanKelimeler = "";
    String ___olusturulan_kelime = "";
    Database db;
    String oyuncuBaslangicAltKelimeleri = "-------------";
    public Oyuncu oyuncu;
    Integer artis = 0;

    int skor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_alani);


        final Button b11 = (Button) findViewById(R.id.b11);
        final Button b12 = (Button) findViewById(R.id.b12);
        final Button b13 = (Button) findViewById(R.id.b13);
        final Button b14 = (Button) findViewById(R.id.b14);
        final Button b15 = (Button) findViewById(R.id.b15);
        final Button b16 = (Button) findViewById(R.id.b16);
        final Button b17 = (Button) findViewById(R.id.b17);
        final Button b18 = (Button) findViewById(R.id.b18);

        final Button b21 = (Button) findViewById(R.id.b21);
        final Button b22 = (Button) findViewById(R.id.b22);
        final Button b23 = (Button) findViewById(R.id.b23);
        final Button b24 = (Button) findViewById(R.id.b24);
        final Button b25 = (Button) findViewById(R.id.b25);
        final Button b26 = (Button) findViewById(R.id.b26);
        final Button b27 = (Button) findViewById(R.id.b27);
        final Button b28 = (Button) findViewById(R.id.b28);

        final Button b31 = (Button) findViewById(R.id.b31);
        final Button b32 = (Button) findViewById(R.id.b32);
        final Button b33 = (Button) findViewById(R.id.b33);
        final Button b34 = (Button) findViewById(R.id.b34);
        final Button b35 = (Button) findViewById(R.id.b35);
        final Button b36 = (Button) findViewById(R.id.b36);
        final Button b37 = (Button) findViewById(R.id.b37);
        final Button b38 = (Button) findViewById(R.id.b38);

        final Button b41 = (Button) findViewById(R.id.b41);
        final Button b42 = (Button) findViewById(R.id.b42);
        final Button b43 = (Button) findViewById(R.id.b43);
        final Button b44 = (Button) findViewById(R.id.b44);
        final Button b45 = (Button) findViewById(R.id.b45);
        final Button b46 = (Button) findViewById(R.id.b46);
        final Button b47 = (Button) findViewById(R.id.b47);
        final Button b48 = (Button) findViewById(R.id.b48);

        final Button b51 = (Button) findViewById(R.id.b51);
        final Button b52 = (Button) findViewById(R.id.b52);
        final Button b53 = (Button) findViewById(R.id.b53);
        final Button b54 = (Button) findViewById(R.id.b54);
        final Button b55 = (Button) findViewById(R.id.b55);
        final Button b56 = (Button) findViewById(R.id.b56);
        final Button b57 = (Button) findViewById(R.id.b57);
        final Button b58 = (Button) findViewById(R.id.b58);

        final Button b61 = (Button) findViewById(R.id.b61);
        final Button b62 = (Button) findViewById(R.id.b62);
        final Button b63 = (Button) findViewById(R.id.b63);
        final Button b64 = (Button) findViewById(R.id.b64);
        final Button b65 = (Button) findViewById(R.id.b65);
        final Button b66 = (Button) findViewById(R.id.b66);
        final Button b67 = (Button) findViewById(R.id.b67);
        final Button b68 = (Button) findViewById(R.id.b68);

        final Button b71 = (Button) findViewById(R.id.b71);
        final Button b72 = (Button) findViewById(R.id.b72);
        final Button b73 = (Button) findViewById(R.id.b73);
        final Button b74 = (Button) findViewById(R.id.b74);
        final Button b75 = (Button) findViewById(R.id.b75);
        final Button b76 = (Button) findViewById(R.id.b76);
        final Button b77 = (Button) findViewById(R.id.b77);
        final Button b78 = (Button) findViewById(R.id.b78);

        final Button b81 = (Button) findViewById(R.id.b81);
        final Button b82 = (Button) findViewById(R.id.b82);
        final Button b83 = (Button) findViewById(R.id.b83);
        final Button b84 = (Button) findViewById(R.id.b84);
        final Button b85 = (Button) findViewById(R.id.b85);
        final Button b86 = (Button) findViewById(R.id.b86);
        final Button b87 = (Button) findViewById(R.id.b87);
        final Button b88 = (Button) findViewById(R.id.b88);

        final Button bas = (Button) findViewById(R.id.bas);


        ///////////kelimelerin konumlarını renklendirmek icin

        db = new Database(getApplicationContext());


        Bundle extras = getIntent().getExtras();
        oyuncu = (Oyuncu) getIntent().getSerializableExtra("Oyuncu");



        /*
        Intent i=getIntent();
        email=i.getStringExtra("gonderilen_email");
*/
        final EditText txtoyuncuIsim = (EditText) findViewById(R.id.oyuncuIsimText);
        final EditText txtSkor = (EditText) findViewById(R.id.skorText);
        final EditText txtSeviye = (EditText) findViewById(R.id.seviyeText);

        txtoyuncuIsim.setText(db.oyuncuAdiGetir(oyuncu.getEmail()));

        seviye = db.oyuncununKaldigiSeviyeZorlukGetir(oyuncu.getEmail()); // S : 1 ve  Z : 1
        txtSeviye.setText("S : " + seviye.getSeviye_No() + "  Z :  " + seviye.getZorluk_Seviyesi());
        if (seviye.getSeviye_No().equals("1")) {
            seviye = db.seviye1_zorluga_gore_Getir(seviye); // seviye de artık daha çok bilgi var örn : "1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76"
        }
        if (seviye.getSeviye_No().equals("2")) {
            seviye = db.seviye2_zorluga_gore_Getir(seviye); // seviye de artık daha çok bilgi var örn : "1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76"
        }
        if (seviye.getSeviye_No().equals("3")) {
            seviye = db.seviye3_zorluga_gore_Getir(seviye); // seviye de artık daha çok bilgi var örn : "1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76"
        }
        oyuncuBaslangicAltKelimeleri = seviye.altKelimeler;

        skor = Integer.valueOf(db.oyuncuSkorGetir(oyuncu.getEmail()));


        String[] separated8 = seviye.getKelimelerinKonumlandirmaBilgisi().split("B");
        System.out.println(separated8[1]);

        for (int i = 0; i <= separated8.length - 1; i++) {
            if (separated8[i].trim().equals("11")) {
                b11.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("12")) {
                b12.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("13")) {
                b13.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("14")) {
                b14.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("15")) {
                b15.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("16")) {
                b16.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("17")) {
                b17.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("18")) {
                b18.setBackgroundColor(Color.RED);
            }


            if (separated8[i].trim().equals("21")) {
                b21.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("22")) {
                b22.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("23")) {
                b23.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("24")) {
                b24.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("25")) {
                b25.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("26")) {
                b26.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("27")) {
                b27.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("28")) {
                b28.setBackgroundColor(Color.RED);
            }

            if (separated8[i].trim().equals("31")) {
                b31.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("32")) {
                b32.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("33")) {
                b33.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("34")) {
                b34.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("35")) {
                b35.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("36")) {
                b36.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("37")) {
                b37.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("38")) {
                b38.setBackgroundColor(Color.RED);
            }


            if (separated8[i].trim().equals("41")) {
                b41.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("42")) {
                b42.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("43")) {
                b43.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("44")) {
                b44.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("45")) {
                b45.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("46")) {
                b46.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("47")) {
                b47.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("48")) {
                b48.setBackgroundColor(Color.RED);
            }

            if (separated8[i].trim().equals("51")) {
                b51.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("52")) {
                b52.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("53")) {
                b53.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("54")) {
                b54.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("55")) {
                b55.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("56")) {
                b56.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("57")) {
                b57.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("58")) {
                b58.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("61")) {
                b61.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("62")) {
                b62.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("63")) {
                b63.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("64")) {
                b64.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("65")) {
                b65.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("66")) {
                b66.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("67")) {
                b67.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("68")) {
                b68.setBackgroundColor(Color.RED);
            }

            if (separated8[i].trim().equals("71")) {
                b71.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("72")) {
                b72.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("73")) {
                b73.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("74")) {
                b74.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("75")) {
                b75.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("76")) {
                b76.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("77")) {
                b77.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("78")) {
                b78.setBackgroundColor(Color.RED);
            }

            if (separated8[i].trim().equals("81")) {
                b81.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("82")) {
                b82.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("83")) {
                b83.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("84")) {
                b84.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("85")) {
                b85.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("86")) {
                b86.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("87")) {
                b87.setBackgroundColor(Color.RED);
            }
            if (separated8[i].trim().equals("88")) {
                b88.setBackgroundColor(Color.RED);
            }


        }

        //Seviye seviye_1 = new Seviye("1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76");
        final String harfler = seviye.getKullanicakHarfler();


        final Button ab11 = (Button) findViewById(R.id.ab11);
        final Button ab12 = (Button) findViewById(R.id.ab12);
        final Button ab13 = (Button) findViewById(R.id.ab13);
        final Button ab21 = (Button) findViewById(R.id.ab21);
        final Button ab22 = (Button) findViewById(R.id.ab22);
        //String buton = "ab";

        //harfleri alt butonlara butonlara yerleştirir
        for (int i = 0; i <= harfler.length() - 1; i++) {
            //Character c = harfler.charAt(i);
            //System.out.println(harfler.charAt(i));
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 2; k++) {
                    if (j == 1 && k == 1 && ab11.getText().equals("")) {

                        ab11.setText(String.valueOf(harfler.charAt(i)));
                        j = 3;
                        k = 2;

                    }
                    if (j == 1 && k == 2 && ab12.getText().equals("")) {
                        ab12.setText(String.valueOf(harfler.charAt(i)));
                        j = 3;
                        k = 2;
                    }
                    if (j == 1 && k == 3 && ab13.getText().equals("")) {
                        ab13.setText(String.valueOf(harfler.charAt(i)));
                        j = 3;
                        k = 3;
                    }
                    if (j == 2 && k == 1 && ab21.getText().equals("")) {
                        ab21.setText(String.valueOf(harfler.charAt(i)));
                        j = 3;
                        k = 2;
                    }
                    if (j == 2 && k == 2 && ab22.getText().equals("")) {
                        ab22.setText(String.valueOf(harfler.charAt(i)));
                        j = 3;
                        k = 2;
                    }


                }

            }

        }


        //"FAL LAF","B53B56B57 B56B66B76"

        //olusturulan_kelime = "AR";      //test amacli

        ab11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int atanacakIndis = 0;
                if (!ab11.getText().equals("")) {
                    olusturulan_kelime += ab11.getText();
                    if (olusturulan_kelime.length() > 1) {

                        String currentString4 = seviye.getAltKelimeler();
                        String[] separated4 = currentString4.split(" ");

                        for (int i = 0; i <= separated4.length - 1; i++) {


                            if (olusturulan_kelime.contains(separated4[i].trim()) && !bulunanKelimeler.contains(olusturulan_kelime) && !separated4[i].trim().equals("")) {
                                ___olusturulan_kelime = separated4[i];
                                atanacakIndis = i;
                                i = separated4.length - 1;
                                key = true;
                            } else {
                                key = false;
                            }
                        }

                        if (key) {

                            String currentString3 = seviye.getKelimelerinKonumlandirmaBilgisi();
                            String[] separated3 = currentString3.split(" ");


                            String currentString1 = separated3[atanacakIndis];
                            // seviye.setKelimelerinKonumlandirmaBilgisi(seviye.getKelimelerinKonumlandirmaBilgisi().replaceAll(separated3[atanacakIndis], ""));
                            String[] separated1 = currentString1.split("B");

                            //"FAL LAF","B53B56B57 B56B66B76"
                            for (int i = 1; i <= ___olusturulan_kelime.length(); i++) {
                                if (separated1[i].equals("11")) {
                                    b11.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("12")) {
                                    b12.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("13")) {
                                    b13.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("14")) {
                                    b14.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("15")) {
                                    b15.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("16")) {
                                    b16.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("17")) {
                                    b17.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("18")) {
                                    b18.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("21")) {
                                    b21.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("22")) {
                                    b22.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("23")) {
                                    b23.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("24")) {
                                    b24.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("25")) {
                                    b25.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("26")) {
                                    b26.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("27")) {
                                    b27.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("28")) {
                                    b28.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("31")) {
                                    b31.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("32")) {
                                    b32.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("33")) {
                                    b33.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("34")) {
                                    b34.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("35")) {
                                    b35.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("36")) {
                                    b36.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("37")) {
                                    b37.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("38")) {
                                    b38.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("41")) {
                                    b41.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("42")) {
                                    b42.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("43")) {
                                    b43.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("44")) {
                                    b44.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("45")) {
                                    b45.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("46")) {
                                    b46.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("47")) {
                                    b47.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("48")) {
                                    b48.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("51")) {
                                    b51.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("52")) {
                                    b52.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("53")) {
                                    b53.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("54")) {
                                    b54.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("55")) {
                                    b55.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("56")) {
                                    b56.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("57")) {
                                    b57.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("58")) {
                                    b58.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("61")) {
                                    b61.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("62")) {
                                    b62.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("63")) {
                                    b63.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("64")) {
                                    b64.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("65")) {
                                    b65.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("66")) {
                                    b66.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("67")) {
                                    b67.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("68")) {
                                    b68.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("71")) {
                                    b71.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("72")) {
                                    b72.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("73")) {
                                    b73.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("74")) {
                                    b74.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("75")) {
                                    b75.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("76")) {
                                    b76.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("77")) {
                                    b77.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("78")) {
                                    b78.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("81")) {
                                    b81.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("82")) {
                                    b82.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("83")) {
                                    b83.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("84")) {
                                    b84.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("85")) {
                                    b85.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("86")) {
                                    b86.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("87")) {
                                    b87.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("88")) {
                                    b88.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                }


                            }
                            bulunanKelimeler += " " + ___olusturulan_kelime;

                            skor += 10;
                            txtSkor.setText(String.valueOf(skor));


                            if (bulunanKelimeler.trim().length() == seviye.getAltKelimeler().trim().length()) {

                                Toast.makeText(getApplicationContext(), "Tebrikler Bölümü Tamamladınız :)", Toast.LENGTH_LONG).show();

                                // oyuncu.setZorluk((String.valueOf(Integer.valueOf(oyuncu.getZorluk()) + 1)));
                                // db.oyuncuSeviyeSkorGuncelle(oyuncu);


                            }


                            String[] separated56 = bulunanKelimeler.split(" ");
                            for (int g = 0; g <= separated56.length - 1; g++) {
                                if (separated56[g].trim().equals(olusturulan_kelime)) {

                                } else {
                                    olusturulan_kelime = "";
                                }

                            }
                            key = false;


                        }


                    }
                }

            }
        });


        ab12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int atanacakIndis = 0;
                if (!ab12.getText().equals("")) {
                    olusturulan_kelime += ab12.getText();
                    if (olusturulan_kelime.length() > 1) {

                        String currentString4 = seviye.getAltKelimeler();
                        String[] separated4 = currentString4.split(" ");

                        for (int i = 0; i <= separated4.length - 1; i++) {


                            if (olusturulan_kelime.contains(separated4[i].trim()) && !bulunanKelimeler.contains(olusturulan_kelime) && !separated4[i].trim().equals("")) {
                                ___olusturulan_kelime = separated4[i];
                                atanacakIndis = i;
                                i = separated4.length - 1;
                                key = true;
                            } else {
                                key = false;
                            }
                        }

                        if (key) {

                            String currentString3 = seviye.getKelimelerinKonumlandirmaBilgisi();
                            String[] separated3 = currentString3.split(" ");


                            String currentString1 = separated3[atanacakIndis];
                            // seviye.setKelimelerinKonumlandirmaBilgisi(seviye.getKelimelerinKonumlandirmaBilgisi().replaceAll(separated3[atanacakIndis], ""));
                            String[] separated1 = currentString1.split("B");

                            //"FAL LAF","B53B56B57 B56B66B76"
                            for (int i = 1; i <= ___olusturulan_kelime.length(); i++) {
                                if (separated1[i].equals("11")) {
                                    b11.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("12")) {
                                    b12.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("13")) {
                                    b13.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("14")) {
                                    b14.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("15")) {
                                    b15.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("16")) {
                                    b16.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("17")) {
                                    b17.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("18")) {
                                    b18.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("21")) {
                                    b21.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("22")) {
                                    b22.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("23")) {
                                    b23.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("24")) {
                                    b24.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("25")) {
                                    b25.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("26")) {
                                    b26.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("27")) {
                                    b27.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("28")) {
                                    b28.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("31")) {
                                    b31.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("32")) {
                                    b32.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("33")) {
                                    b33.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("34")) {
                                    b34.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("35")) {
                                    b35.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("36")) {
                                    b36.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("37")) {
                                    b37.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("38")) {
                                    b38.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("41")) {
                                    b41.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("42")) {
                                    b42.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("43")) {
                                    b43.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("44")) {
                                    b44.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("45")) {
                                    b45.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("46")) {
                                    b46.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("47")) {
                                    b47.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("48")) {
                                    b48.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("51")) {
                                    b51.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("52")) {
                                    b52.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("53")) {
                                    b53.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("54")) {
                                    b54.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("55")) {
                                    b55.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("56")) {
                                    b56.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("57")) {
                                    b57.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("58")) {
                                    b58.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("61")) {
                                    b61.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("62")) {
                                    b62.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("63")) {
                                    b63.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("64")) {
                                    b64.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("65")) {
                                    b65.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("66")) {
                                    b66.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("67")) {
                                    b67.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("68")) {
                                    b68.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("71")) {
                                    b71.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("72")) {
                                    b72.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("73")) {
                                    b73.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("74")) {
                                    b74.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("75")) {
                                    b75.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("76")) {
                                    b76.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("77")) {
                                    b77.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("78")) {
                                    b78.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("81")) {
                                    b81.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("82")) {
                                    b82.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("83")) {
                                    b83.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("84")) {
                                    b84.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("85")) {
                                    b85.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("86")) {
                                    b86.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("87")) {
                                    b87.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("88")) {
                                    b88.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                }


                            }
                            bulunanKelimeler += " " + ___olusturulan_kelime;
                            skor += 10;
                            txtSkor.setText(String.valueOf(skor));


                            if (bulunanKelimeler.trim().length() == seviye.getAltKelimeler().trim().length()) {

                                Toast.makeText(getApplicationContext(), "Tebrikler Bölümü Tamamladınız :)", Toast.LENGTH_LONG).show();

                                //  oyuncu.setZorluk((String.valueOf(Integer.valueOf(oyuncu.getZorluk()) + 1)));
                                // db.oyuncuSeviyeSkorGuncelle(oyuncu);


                            }


                            String[] separated56 = bulunanKelimeler.split(" ");
                            for (int g = 0; g <= separated56.length - 1; g++) {
                                if (separated56[g].trim().equals(olusturulan_kelime)) {

                                } else {
                                    olusturulan_kelime = "";
                                }

                            }
                            key = false;


                        }


                    }
                }

            }
        });
        ab13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int atanacakIndis = 0;
                if (!ab13.getText().equals("")) {
                    olusturulan_kelime += ab13.getText();
                    if (olusturulan_kelime.length() > 1) {

                        String currentString4 = seviye.getAltKelimeler();
                        String[] separated4 = currentString4.split(" ");

                        for (int i = 0; i <= separated4.length - 1; i++) {


                            if (olusturulan_kelime.contains(separated4[i].trim()) && !bulunanKelimeler.contains(olusturulan_kelime) && !separated4[i].trim().equals("")) {
                                ___olusturulan_kelime = separated4[i];
                                atanacakIndis = i;
                                i = separated4.length - 1;
                                key = true;
                            } else {
                                key = false;
                            }
                        }

                        if (key) {

                            String currentString3 = seviye.getKelimelerinKonumlandirmaBilgisi();
                            String[] separated3 = currentString3.split(" ");


                            String currentString1 = separated3[atanacakIndis];
                            // seviye.setKelimelerinKonumlandirmaBilgisi(seviye.getKelimelerinKonumlandirmaBilgisi().replaceAll(separated3[atanacakIndis], ""));
                            String[] separated1 = currentString1.split("B");

                            //"FAL LAF","B53B56B57 B56B66B76"
                            for (int i = 1; i <= ___olusturulan_kelime.length(); i++) {
                                if (separated1[i].equals("11")) {
                                    b11.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("12")) {
                                    b12.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("13")) {
                                    b13.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("14")) {
                                    b14.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("15")) {
                                    b15.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("16")) {
                                    b16.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("17")) {
                                    b17.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("18")) {
                                    b18.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("21")) {
                                    b21.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("22")) {
                                    b22.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("23")) {
                                    b23.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("24")) {
                                    b24.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("25")) {
                                    b25.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("26")) {
                                    b26.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("27")) {
                                    b27.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("28")) {
                                    b28.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("31")) {
                                    b31.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("32")) {
                                    b32.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("33")) {
                                    b33.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("34")) {
                                    b34.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("35")) {
                                    b35.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("36")) {
                                    b36.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("37")) {
                                    b37.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("38")) {
                                    b38.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("41")) {
                                    b41.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("42")) {
                                    b42.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("43")) {
                                    b43.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("44")) {
                                    b44.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("45")) {
                                    b45.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("46")) {
                                    b46.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("47")) {
                                    b47.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("48")) {
                                    b48.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("51")) {
                                    b51.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("52")) {
                                    b52.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("53")) {
                                    b53.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("54")) {
                                    b54.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("55")) {
                                    b55.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("56")) {
                                    b56.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("57")) {
                                    b57.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("58")) {
                                    b58.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("61")) {
                                    b61.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("62")) {
                                    b62.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("63")) {
                                    b63.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("64")) {
                                    b64.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("65")) {
                                    b65.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("66")) {
                                    b66.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("67")) {
                                    b67.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("68")) {
                                    b68.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("71")) {
                                    b71.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("72")) {
                                    b72.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("73")) {
                                    b73.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("74")) {
                                    b74.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("75")) {
                                    b75.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("76")) {
                                    b76.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("77")) {
                                    b77.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("78")) {
                                    b78.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("81")) {
                                    b81.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("82")) {
                                    b82.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("83")) {
                                    b83.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("84")) {
                                    b84.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("85")) {
                                    b85.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("86")) {
                                    b86.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("87")) {
                                    b87.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("88")) {
                                    b88.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                }


                            }
                            bulunanKelimeler += " " + ___olusturulan_kelime;

                            skor += 10;
                            txtSkor.setText(String.valueOf(skor));


                            if (bulunanKelimeler.trim().length() == seviye.getAltKelimeler().trim().length()) {

                                Toast.makeText(getApplicationContext(), "Tebrikler Bölümü Tamamladınız :)", Toast.LENGTH_LONG).show();

                                // oyuncu.setZorluk((String.valueOf(Integer.valueOf(oyuncu.getZorluk()) + 1)));
                                // db.oyuncuSeviyeSkorGuncelle(oyuncu);


                            }


                            String[] separated56 = bulunanKelimeler.split(" ");
                            for (int g = 0; g <= separated56.length - 1; g++) {
                                if (separated56[g].trim().equals(olusturulan_kelime)) {

                                } else {
                                    olusturulan_kelime = "";
                                }

                            }
                            key = false;


                        }


                    }
                }


            }
        });


        ab21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                int atanacakIndis = 0;
                if (!ab21.getText().equals("")) {
                    olusturulan_kelime += ab21.getText();
                    if (olusturulan_kelime.length() > 1) {

                        String currentString4 = seviye.getAltKelimeler();
                        String[] separated4 = currentString4.split(" ");

                        for (int i = 0; i <= separated4.length - 1; i++) {


                            if (olusturulan_kelime.contains(separated4[i].trim()) && !bulunanKelimeler.contains(olusturulan_kelime) && !separated4[i].trim().equals("")) {
                                ___olusturulan_kelime = separated4[i];
                                atanacakIndis = i;
                                i = separated4.length - 1;
                                key = true;
                            } else {
                                key = false;
                            }
                        }

                        if (key) {

                            String currentString3 = seviye.getKelimelerinKonumlandirmaBilgisi();
                            String[] separated3 = currentString3.split(" ");


                            String currentString1 = separated3[atanacakIndis];
                            // seviye.setKelimelerinKonumlandirmaBilgisi(seviye.getKelimelerinKonumlandirmaBilgisi().replaceAll(separated3[atanacakIndis], ""));
                            String[] separated1 = currentString1.split("B");

                            //"FAL LAF","B53B56B57 B56B66B76"
                            for (int i = 1; i <= ___olusturulan_kelime.length(); i++) {
                                if (separated1[i].equals("11")) {
                                    b11.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("12")) {
                                    b12.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("13")) {
                                    b13.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("14")) {
                                    b14.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("15")) {
                                    b15.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("16")) {
                                    b16.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("17")) {
                                    b17.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("18")) {
                                    b18.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("21")) {
                                    b21.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("22")) {
                                    b22.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("23")) {
                                    b23.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("24")) {
                                    b24.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("25")) {
                                    b25.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("26")) {
                                    b26.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("27")) {
                                    b27.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("28")) {
                                    b28.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("31")) {
                                    b31.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("32")) {
                                    b32.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("33")) {
                                    b33.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("34")) {
                                    b34.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("35")) {
                                    b35.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("36")) {
                                    b36.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("37")) {
                                    b37.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("38")) {
                                    b38.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("41")) {
                                    b41.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("42")) {
                                    b42.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("43")) {
                                    b43.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("44")) {
                                    b44.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("45")) {
                                    b45.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("46")) {
                                    b46.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("47")) {
                                    b47.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("48")) {
                                    b48.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("51")) {
                                    b51.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("52")) {
                                    b52.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("53")) {
                                    b53.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("54")) {
                                    b54.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("55")) {
                                    b55.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("56")) {
                                    b56.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("57")) {
                                    b57.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("58")) {
                                    b58.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("61")) {
                                    b61.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("62")) {
                                    b62.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("63")) {
                                    b63.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("64")) {
                                    b64.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("65")) {
                                    b65.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("66")) {
                                    b66.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("67")) {
                                    b67.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("68")) {
                                    b68.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("71")) {
                                    b71.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("72")) {
                                    b72.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("73")) {
                                    b73.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("74")) {
                                    b74.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("75")) {
                                    b75.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("76")) {
                                    b76.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("77")) {
                                    b77.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("78")) {
                                    b78.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("81")) {
                                    b81.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("82")) {
                                    b82.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("83")) {
                                    b83.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("84")) {
                                    b84.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("85")) {
                                    b85.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("86")) {
                                    b86.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("87")) {
                                    b87.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("88")) {
                                    b88.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                }


                            }
                            bulunanKelimeler += " " + ___olusturulan_kelime;
                            skor += 10;
                            txtSkor.setText(String.valueOf(skor));


                            if (bulunanKelimeler.trim().length() == seviye.getAltKelimeler().trim().length()) {

                                Toast.makeText(getApplicationContext(), "Tebrikler Bölümü Tamamladınız :)", Toast.LENGTH_LONG).show();

                                //  oyuncu.setZorluk((String.valueOf(Integer.valueOf(oyuncu.getZorluk()) + 1)));
                                //  db.oyuncuSeviyeSkorGuncelle(oyuncu);


                            }

                            String[] separated56 = bulunanKelimeler.split(" ");
                            for (int g = 0; g <= separated56.length - 1; g++) {
                                if (separated56[g].trim().equals(olusturulan_kelime)) {

                                } else {
                                    olusturulan_kelime = "";
                                }

                            }

                            key = false;

                        }


                    }
                }

            }


        });
        ab22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int atanacakIndis = 0;
                if (!ab22.getText().equals("")) {
                    olusturulan_kelime += ab22.getText();
                    if (olusturulan_kelime.length() > 1) {

                        String currentString4 = seviye.getAltKelimeler();
                        String[] separated4 = currentString4.split(" ");

                        for (int i = 0; i <= separated4.length - 1; i++) {


                            if (olusturulan_kelime.contains(separated4[i].trim()) && !bulunanKelimeler.contains(olusturulan_kelime) && !separated4[i].trim().equals("")) {
                                ___olusturulan_kelime = separated4[i];
                                atanacakIndis = i;
                                i = separated4.length - 1;
                                key = true;
                            } else {
                                key = false;
                            }
                        }

                        if (key) {

                            String currentString3 = seviye.getKelimelerinKonumlandirmaBilgisi();
                            String[] separated3 = currentString3.split(" ");


                            String currentString1 = separated3[atanacakIndis];
                            // seviye.setKelimelerinKonumlandirmaBilgisi(seviye.getKelimelerinKonumlandirmaBilgisi().replaceAll(separated3[atanacakIndis], ""));
                            String[] separated1 = currentString1.split("B");

                            //"FAL LAF","B53B56B57 B56B66B76"
                            for (int i = 1; i <= ___olusturulan_kelime.length(); i++) {
                                if (separated1[i].equals("11")) {
                                    b11.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("12")) {
                                    b12.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("13")) {
                                    b13.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("14")) {
                                    b14.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("15")) {
                                    b15.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("16")) {
                                    b16.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("17")) {
                                    b17.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("18")) {
                                    b18.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("21")) {
                                    b21.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("22")) {
                                    b22.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("23")) {
                                    b23.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("24")) {
                                    b24.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("25")) {
                                    b25.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("26")) {
                                    b26.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("27")) {
                                    b27.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("28")) {
                                    b28.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("31")) {
                                    b31.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("32")) {
                                    b32.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("33")) {
                                    b33.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("34")) {
                                    b34.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("35")) {
                                    b35.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("36")) {
                                    b36.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("37")) {
                                    b37.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("38")) {
                                    b38.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("41")) {
                                    b41.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("42")) {
                                    b42.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("43")) {
                                    b43.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("44")) {
                                    b44.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("45")) {
                                    b45.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("46")) {
                                    b46.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("47")) {
                                    b47.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("48")) {
                                    b48.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("51")) {
                                    b51.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("52")) {
                                    b52.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("53")) {
                                    b53.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("54")) {
                                    b54.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("55")) {
                                    b55.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("56")) {
                                    b56.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("57")) {
                                    b57.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("58")) {
                                    b58.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("61")) {
                                    b61.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("62")) {
                                    b62.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("63")) {
                                    b63.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("64")) {
                                    b64.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("65")) {
                                    b65.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("66")) {
                                    b66.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("67")) {
                                    b67.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("68")) {
                                    b68.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("71")) {
                                    b71.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("72")) {
                                    b72.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("73")) {
                                    b73.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("74")) {
                                    b74.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("75")) {
                                    b75.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("76")) {
                                    b76.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("77")) {
                                    b77.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("78")) {
                                    b78.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("81")) {
                                    b81.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("82")) {
                                    b82.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("83")) {
                                    b83.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("84")) {
                                    b84.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("85")) {
                                    b85.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("86")) {
                                    b86.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("87")) {
                                    b87.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                } else if (separated1[i].equals("88")) {
                                    b88.setText(String.valueOf(___olusturulan_kelime.charAt(i - 1)));
                                }


                            }
                            bulunanKelimeler += " " + ___olusturulan_kelime;

                            skor += 10;
                            txtSkor.setText(String.valueOf(skor));


                            if (bulunanKelimeler.trim().length() == seviye.getAltKelimeler().trim().length()) {

                                Toast.makeText(getApplicationContext(), "Tebrikler Bölümü Tamamladınız :)", Toast.LENGTH_LONG).show();

                                // oyuncu.setZorluk((String.valueOf(Integer.valueOf(oyuncu.getZorluk()) + 1)));
                                // db.oyuncuSeviyeSkorGuncelle(oyuncu);


                            }


                            String[] separated56 = bulunanKelimeler.split(" ");
                            for (int g = 0; g <= separated56.length - 1; g++) {
                                if (separated56[g].trim().equals(olusturulan_kelime)) {

                                } else {
                                    olusturulan_kelime = "";
                                }

                            }
                            key = false;


                        }


                    }
                }


            }
        });


        bas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String a, b, c, d, e;

                a = String.valueOf(ab11.getText());
                b = String.valueOf(ab12.getText());
                c = String.valueOf(ab13.getText());
                d = String.valueOf(ab21.getText());
                e = String.valueOf(ab22.getText());

                ab11.setText(e);
                ab12.setText(d);
                ab13.setText(d);
                ab21.setText(b);
                ab22.setText(a);

            }
        });


        b88.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                olusturulan_kelime = "";


                if (Integer.valueOf(Integer.valueOf(oyuncu.getZorluk())) <= 5) {
                    oyuncu.setZorluk((String.valueOf(Integer.valueOf(oyuncu.getZorluk()) + 1)));

                } else {
                    oyuncu.setSeviye((String.valueOf(Integer.valueOf(oyuncu.getSeviye()) + 1)));
                    if (oyuncu.getSeviye().trim().equals("4")) {
                        Toast.makeText(getApplicationContext(), "Tebrikler OYUN BİTTİ !!!!", Toast.LENGTH_LONG).show();
                    }
                    if (oyuncu.getZorluk().equals("6")) {
                        oyuncu.setZorluk("1");
                    }

                }

                db.oyuncuSeviyeSkorGuncelle(oyuncu);
                txtSeviye.setText("S : " + seviye.getSeviye_No() + "  Z :  " + seviye.getZorluk_Seviyesi());

                String currentString31 = seviye.getKelimelerinKonumlandirmaBilgisi();
                String[] separated31 = currentString31.split("B");


                //"FAL LAF","B53B56B57 B56B66B76"
                for (int i = 1; i <= separated31.length - 1; i++) {

                    System.out.println(currentString31.length() - 1);

                    if (separated31[i].trim().equals("11")) {
                        b11.setText(" ");
                        b11.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("12")) {
                        b12.setText("");
                        b12.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("13")) {
                        b13.setText("");
                        b13.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("14")) {
                        b14.setText("");
                        b14.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("15")) {
                        b15.setText("");
                        b15.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("16")) {
                        b16.setText("");
                        b16.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("17")) {
                        b17.setText("");
                        b17.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("18")) {
                        b18.setText("");
                        b18.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("21")) {
                        b21.setText("");
                        b21.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("22")) {
                        b22.setText("");
                        b22.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("23")) {
                        b23.setText("");
                        b23.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("24")) {
                        b24.setText("");
                        b24.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("25")) {
                        b25.setText("");
                        b25.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("26")) {
                        b26.setText("");
                        b26.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("27")) {
                        b27.setText("");
                        b27.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("28")) {
                        b28.setText("");
                        b28.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("31")) {
                        b31.setText("");
                        b31.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("32")) {
                        b32.setText("");
                        b32.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("33")) {
                        b33.setText("");
                        b33.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("34")) {
                        b34.setText("");
                        b34.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("35")) {
                        b35.setText("");
                        b35.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("36")) {
                        b36.setText("");
                        b36.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("37")) {
                        b37.setText("");
                        b37.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("38")) {
                        b38.setText("");
                        b38.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("41")) {
                        b41.setText("");
                        b41.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("42")) {
                        b42.setText("");
                        b42.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("43")) {
                        b43.setText("");
                        b43.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("44")) {
                        b44.setText("");
                        b44.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("45")) {
                        b45.setText("");
                        b45.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("46")) {
                        b46.setText("");
                        b46.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("47")) {
                        b47.setText("");
                        b47.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("48")) {
                        b48.setText("");
                        b48.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("51")) {
                        b51.setText("");
                        b51.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("52")) {
                        b52.setText("");
                        b52.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("53")) {
                        b53.setText("");
                        b53.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("54")) {
                        b54.setText("");
                        b54.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("55")) {
                        b55.setText("");
                        b55.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("56")) {
                        b56.setText("");
                        b56.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("57")) {
                        b57.setText("");
                        b57.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("58")) {
                        b58.setText("");
                        b58.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("61")) {
                        b61.setText("");
                        b61.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("62")) {
                        b62.setText("");
                        b62.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("63")) {
                        b63.setText("");
                        b63.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("64")) {
                        b64.setText("");
                        b64.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("65")) {
                        b65.setText("");
                        b65.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("66")) {
                        b66.setText("");
                        b66.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("67")) {
                        b67.setText("");
                        b67.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("68")) {
                        b68.setText("");
                        b68.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("71")) {
                        b71.setText("");
                        b71.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("72")) {
                        b72.setText("");
                        b72.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("73")) {
                        b73.setText("");
                        b73.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("74")) {
                        b74.setText("");
                        b74.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("75")) {
                        b75.setText("");
                        b75.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("76")) {
                        b76.setText("");
                        b76.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("77")) {
                        b77.setText("");
                        b77.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("78")) {
                        b78.setText("");
                        b78.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("81")) {
                        b81.setText("");
                        b81.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("82")) {
                        b82.setText("");
                        b82.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("83")) {
                        b83.setText("");
                        b83.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("84")) {
                        b84.setText("");
                        b84.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("85")) {
                        b85.setText("");
                        b85.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("86")) {
                        b86.setText("");
                        b86.setBackgroundColor(Color.GRAY);
                    }
                    if (separated31[i].trim().equals("87")) {
                        b87.setText("");
                        b87.setBackgroundColor(Color.GRAY);
                    }


                }


                seviye = db.oyuncununKaldigiSeviyeZorlukGetir(oyuncu.getEmail()); // S : 1 ve  Z : 2

                if (seviye.getSeviye_No().equals("1")) {
                    seviye = db.seviye1_zorluga_gore_Getir(seviye); // seviye de artık daha çok bilgi var örn : "1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76"
                }
                if (seviye.getSeviye_No().equals("2")) {
                    seviye = db.seviye2_zorluga_gore_Getir(seviye); // seviye de artık daha çok bilgi var örn : "1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76"
                }
                if (seviye.getSeviye_No().equals("3")) {
                    seviye = db.seviye3_zorluga_gore_Getir(seviye); // seviye de artık daha çok bilgi var örn : "1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76"
                }
                txtSeviye.setText("S : " + seviye.getSeviye_No() + "  Z :  " + seviye.getZorluk_Seviyesi());

                String[] separated81 = seviye.getKelimelerinKonumlandirmaBilgisi().split("B");

                for (int i = 1; i <= separated81.length - 1; i++) {
                    if (separated81[i].trim().equals("11")) {
                        b11.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("12")) {
                        b12.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("13")) {
                        b13.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("14")) {
                        b14.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("15")) {
                        b15.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("16")) {
                        b16.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("17")) {
                        b17.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("18")) {
                        b18.setBackgroundColor(Color.RED);
                    }


                    if (separated81[i].trim().equals("21")) {
                        b21.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("22")) {
                        b22.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("23")) {
                        b23.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("24")) {
                        b24.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("25")) {
                        b25.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("26")) {
                        b26.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("27")) {
                        b27.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("28")) {
                        b28.setBackgroundColor(Color.RED);
                    }

                    if (separated81[i].trim().equals("31")) {
                        b31.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("32")) {
                        b32.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("33")) {
                        b33.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("34")) {
                        b34.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("35")) {
                        b35.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("36")) {
                        b36.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("37")) {
                        b37.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("38")) {
                        b38.setBackgroundColor(Color.RED);
                    }


                    if (separated81[i].trim().equals("41")) {
                        b41.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("42")) {
                        b42.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("43")) {
                        b43.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("44")) {
                        b44.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("45")) {
                        b45.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("46")) {
                        b46.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("47")) {
                        b47.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("48")) {
                        b48.setBackgroundColor(Color.RED);
                    }

                    if (separated81[i].trim().equals("51")) {
                        b51.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("52")) {
                        b52.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("53")) {
                        b53.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("54")) {
                        b54.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("55")) {
                        b55.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("56")) {
                        b56.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("57")) {
                        b57.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("58")) {
                        b58.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("61")) {
                        b61.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("62")) {
                        b62.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("63")) {
                        b63.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("64")) {
                        b64.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("65")) {
                        b65.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("66")) {
                        b66.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("67")) {
                        b67.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("68")) {
                        b68.setBackgroundColor(Color.RED);
                    }

                    if (separated81[i].trim().equals("71")) {
                        b71.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("72")) {
                        b72.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("73")) {
                        b73.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("74")) {
                        b74.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("75")) {
                        b75.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("76")) {
                        b76.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("77")) {
                        b77.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("78")) {
                        b78.setBackgroundColor(Color.RED);
                    }

                    if (separated81[i].trim().equals("81")) {
                        b81.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("82")) {
                        b82.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("83")) {
                        b83.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("84")) {
                        b84.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("85")) {
                        b85.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("86")) {
                        b86.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("87")) {
                        b87.setBackgroundColor(Color.RED);
                    }
                    if (separated81[i].trim().equals("88")) {
                        b88.setBackgroundColor(Color.RED);
                    }


                }

                //Seviye seviye_1 = new Seviye("1","1","FAL","FAL","FAL LAF","B53B56B57 B56B66B76");
                ab11.setText("");
                ab12.setText("");
                ab13.setText("");
                ab21.setText("");
                ab22.setText("");

                final String harfler1 = seviye.getKullanicakHarfler();


                //harfleri alt butonlara butonlara yerleştirir
                for (int i = 0; i <= harfler1.length() - 1; i++) {
                    //Character c = harfler1.charAt(i);
                    //System.out.println(harfler1.charAt(i));
                    for (int j = 1; j <= 3; j++) {
                        for (int k = 1; k <= 3; k++) {
                            if (j == 1 && k == 1 && ab11.getText().equals("")) {

                                ab11.setText(String.valueOf(harfler1.charAt(i)));
                                j = 3;
                                k = 2;

                            }
                            if (j == 1 && k == 2 && ab12.getText().equals("")) {
                                ab12.setText(String.valueOf(harfler1.charAt(i)));
                                j = 3;
                                k = 2;
                            }
                            if (j == 1 && k == 3 && ab13.getText().equals("")) {
                                ab13.setText(String.valueOf(harfler1.charAt(i)));
                                j = 3;
                                k = 2;
                            }
                            if (j == 2 && k == 1 && ab21.getText().equals("")) {
                                ab21.setText(String.valueOf(harfler1.charAt(i)));
                                j = 3;
                                k = 2;
                            }
                            if (j == 2 && k == 2 && ab22.getText().equals("")) {
                                ab22.setText(String.valueOf(harfler1.charAt(i)));
                                j = 3;
                                k = 2;
                            }


                        }

                    }

                }


            }
        });


    }


}


