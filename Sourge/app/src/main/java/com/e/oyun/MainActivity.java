package com.e.oyun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Date;

public class MainActivity extends AppCompatActivity {


    long id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText txtad = (EditText) findViewById(R.id.nameText);
        final EditText txtemail = (EditText) findViewById(R.id.emailText);
        Button btnOK = (Button) findViewById(R.id.button);




        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ad = txtad.getText().toString();
                String email = txtemail.getText().toString();

                if (ad.isEmpty() || email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alanları boş geçemezsiniz!", Toast.LENGTH_LONG).show();
                    return;
                }

                Oyuncu oyuncu = new Oyuncu(ad, email, "1");
                oyuncu.setAd(ad);
                oyuncu.setEmail(email);
                Database db = new Database(getApplicationContext());
               /* Seviye seviye_1 = new Seviye("1", "1", "FAL", "FAL", "FAL LAF", "B53B54B55 B55B65B75");
                db.ekleSeviye1e(seviye_1);
                Seviye seviye_2 = new Seviye("1", "2", "KARA", "KAR", "KARA ARA KAR", "B44B45B46B47 B36B46B56 B44B54B64");
                db.ekleSeviye1e(seviye_2);
                Seviye seviye_3 = new Seviye("1", "3", "HAL", "HAL", "HAL ALA AL", "B44B45B46 B45B55B65 B36B46");
                db.ekleSeviye1e(seviye_3);
                Seviye seviye_4 = new Seviye("1", "4", "HAN", "HAN", "HAN ANA AN AH", "B44B45B46 B45B55B65 B36B46 B65B66");
                db.ekleSeviye1e(seviye_4);
                Seviye seviye_5 = new Seviye("1", "5", "ADAM", "ADM", "ADAM DAM AMA AD", "B44B45B46B47 B34B44B54 B37B47B57 B57B58");
                db.ekleSeviye1e(seviye_5);
                Seviye seviye_6 = new Seviye("1", "6", "AKYAKA", "AYK", "YAY YAYA YAKA AK AYAK AY", "B21B31B41 B41B42B43B44 B43B53B63B73 B62B63 B73B74B75B76 B75B85");
                db.ekleSeviye1e(seviye_6);

                Seviye seviye_2_1 = new Seviye("2", "1", "ANLAMA", "ANLM", "ANLAMA MAMA AL", "B22B23B24B25B26B27 B26B36B46B56 B56B57");
                db.ekleSeviye2e(seviye_2_1);
                Seviye seviye_2_2 = new Seviye("2", "2", "EGEMEN", "EGHN", "EGEMEN EGE MEN NEM", "B22B23B24B25B26B27 B13B23B33 B25B35B45 B27B37B47");
                db.ekleSeviye2e(seviye_2_2);
                Seviye seviye_2_3 = new Seviye("2", "3", "ANLAMA", "ANLM", "ANLAMA MAMA AL", "B22B23B24B25B26B27 B26B36B46B56 B56B57");
                db.ekleSeviye2e(seviye_2_3);
                Seviye seviye_2_4 = new Seviye("2", "4", "EGEMEN", "EGHN", "EGEMEN EGE MEN NEM", "B22B23B24B25B26B27 B13B23B33 B25B35B45 B27B37B47");
                db.ekleSeviye2e(seviye_2_4);
                Seviye seviye_2_5 = new Seviye("2", "5", "ANLAMA", "ANLM", "ANLAMA MAMA AL", "B22B23B24B25B26B27 B26B36B46B56 B56B57");
                db.ekleSeviye2e(seviye_2_5);
                Seviye seviye_2_6 = new Seviye("2", "6", "EGEMEN", "EGHN", "EGEMEN EGE MEN NEM", "B22B23B24B25B26B27 B13B23B33 B25B35B45 B27B37B47");
                db.ekleSeviye2e(seviye_2_6);

                Seviye seviye_3_1 = new Seviye("3", "1", "ANLAMA", "ANPLM", "ANLAMA MAMA AL", "B22B23B24B25B26B27 B26B36B46B56 B56B57");
                db.ekleSeviye3e(seviye_3_1);
                Seviye seviye_3_2 = new Seviye("3", "2", "EGEMEN", "EGPHN", "EGEMEN EGE MEN NEM", "B22B23B24B25B26B27 B13B23B33 B25B35B45 B27B37B47");
                db.ekleSeviye3e(seviye_3_2);
                Seviye seviye_3_3 = new Seviye("3", "3", "ANLAMA", "ANPLM", "ANLAMA MAMA AL", "B22B23B24B25B26B27 B26B36B46B56 B56B57");
                db.ekleSeviye3e(seviye_3_3);
                Seviye seviye_3_4 = new Seviye("3", "4", "EGEMEN", "EGHPN", "EGEMEN EGE MEN NEM", "B22B23B24B25B26B27 B13B23B33 B25B35B45 B27B37B47");
                db.ekleSeviye3e(seviye_3_4);
                Seviye seviye_3_5 = new Seviye("3", "5", "ANLAMA", "ANLPM", "ANLAMA MAMA AL", "B22B23B24B25B26B27 B26B36B46B56 B56B57");
                db.ekleSeviye3e(seviye_3_5);
                Seviye seviye_3_6 = new Seviye("3", "6", "EGEMEN", "EGHPN", "EGEMEN EGE MEN NEM", "B22B23B24B25B26B27 B13B23B33 B25B35B45 B27B37B47");
                db.ekleSeviye3e(seviye_3_6);*/

                if (db.oyuncuVarmiKontrolEt(email).equals(false)) {
                    id = db.ekleOyuncu(oyuncu);
                }

                db.close();
                System.out.println(db);

                if (id > 0) {
                    Toast.makeText(getApplicationContext(), "Kayit Basarili ID : " + id, Toast.LENGTH_LONG).show();
                    txtad.setText("");
                    txtemail.setText("");

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Oyuncu", oyuncu);
                    Intent intent = new Intent(getApplicationContext(), OyunAlani.class);
                    intent.putExtras(bundle);
                    startActivity(intent);


/*
                    Intent intent = new Intent(getApplicationContext(), OyunAlani.class);
                    intent.putExtra("gonderilen_email",email);
                    startActivity(intent);
*/


                } else {

                    txtad.setText("");
                    txtemail.setText("");


                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Oyuncu", oyuncu);
                    Intent intent = new Intent(getApplicationContext(), OyunAlani.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

/*
                    Intent intent = new Intent(getApplicationContext(), OyunAlani.class);
                    intent.putExtra("gonderilen_email",email);
                    startActivity(intent);
                    Toast.makeText( getApplicationContext(),"Kayitli Oyuncu ", Toast.LENGTH_LONG).show();*/
                }


            }
        });


    }
}
