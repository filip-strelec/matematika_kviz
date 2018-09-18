package com.example.android.matematikakviz;

import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = false;
    int brojac1 = 0;
    int brojac2 = 0;

    TextView operacija;
    TextView counter;

    int i1;
    int i2;
    int zbroj;
    int razlika;
    int suma;
    int kolicnik;
    Button tajmer;
    Button kreni;

    Button odgovor1;
    Button odgovor2;
    Button odgovor3;
    Button odgovor4;
    int rezultat;

    CountDownTimer tikTok;

    int broj1;
    int broj2;
    int broj3;
    int broj4;


    public void funkcija() {
        Random r = new Random();
        i1 = r.nextInt(80 - 1);
        i2 = r.nextInt(50 - 1);
        int i3 = r.nextInt(10 - 2) + 2;
        int i4 = r.nextInt(10 - 2) + 4;
        zbroj = i1 + i2;
        razlika = i1 - i2;
        suma = i1 * i2;

        String zbrojString = Integer.toString(i1) + "+" + Integer.toString(i2);
        String razlikaString = Integer.toString(i1) + "-" + Integer.toString(i2);
        String sumaString = Integer.toString(i1) + "*" + Integer.toString(i2);

        kreni.setVisibility(View.INVISIBLE);

        if (35 < i1 && i1 <= 67) {
            if (i2 <= 25) {

                operacija.setText(zbrojString);

                rezultat = zbroj;
                odgovor1.setText(Integer.toString(zbroj - i3));
                odgovor4.setText(Integer.toString(zbroj + 10));
                odgovor2.setText(Integer.toString(zbroj + i4));
                odgovor3.setText(Integer.toString(zbroj));
                Log.i("zbroj", zbrojString);


            } else {

                operacija.setText(zbrojString);

                rezultat = zbroj;
                odgovor3.setText(Integer.toString(zbroj - i3));
                odgovor2.setText(Integer.toString(zbroj + 10));
                odgovor1.setText(Integer.toString(zbroj + i4));
                odgovor4.setText(Integer.toString(zbroj));
                Log.i("zbroj", zbrojString);


            }


        } else if (10 < i1 && i1 <= 35) {

            if (i2 <= 25) {

                operacija.setText(razlikaString);
                rezultat = razlika;
                odgovor4.setText(Integer.toString(razlika - i3));
                odgovor2.setText(Integer.toString(razlika));
                odgovor1.setText(Integer.toString(razlika + i4));
                odgovor3.setText(Integer.toString(razlika + 2));
                Log.i("razlika", razlikaString);
            } else {


                operacija.setText(razlikaString);
                rezultat = razlika;
                odgovor2.setText(Integer.toString(razlika - 10));
                odgovor3.setText(Integer.toString(razlika));
                odgovor4.setText(Integer.toString(razlika + i4));
                odgovor1.setText(Integer.toString(razlika + 6));

            }

        } else if (i1 <= 10) {

            if (i2 <= 25) {

                operacija.setText(sumaString);
                rezultat = suma;
                odgovor1.setText(Integer.toString(suma - i3));
                odgovor3.setText(Integer.toString(suma));
                odgovor2.setText(Integer.toString(suma + i4));
                odgovor4.setText(Integer.toString(suma + 2));
                Log.i("suma", sumaString);
            } else {
                operacija.setText(sumaString);
                rezultat = suma;
                odgovor2.setText(Integer.toString(suma - i3));
                odgovor4.setText(Integer.toString(suma));
                odgovor1.setText(Integer.toString(suma + i4));
                odgovor3.setText(Integer.toString(suma + 3));
                Log.i("suma", sumaString);

            }
        } else {
            if (i2 <= 25) {


                operacija.setText(sumaString);
            rezultat = suma;
            odgovor3.setText(Integer.toString(suma - i3));
            odgovor1.setText(Integer.toString(suma));
            odgovor2.setText(Integer.toString(suma + i4));
            odgovor4.setText(Integer.toString(suma + 10));
            Log.i("suma", sumaString);}
            else {

                operacija.setText(sumaString);
                rezultat = suma;
                odgovor1.setText(Integer.toString(suma - 10));
                odgovor3.setText(Integer.toString(suma));
                odgovor4.setText(Integer.toString(suma + 4));
                odgovor2.setText(Integer.toString(suma + 6));
            }

        }
        broj1 = Integer.parseInt(odgovor1.getText().toString());
        broj2 = Integer.parseInt(odgovor2.getText().toString());
        broj3 = Integer.parseInt(odgovor3.getText().toString());
        broj4 = Integer.parseInt(odgovor4.getText().toString());

    }

    public void pokretanje() {
        gameActive = true;
        brojac1 = 0;
        brojac2 = 0;
        funkcija();


        tikTok = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int sekunde = (int) millisUntilFinished / 1000;
                String sekunkd = Integer.toString(sekunde);
                tajmer.setText(sekunkd + "s");
            }

            @Override
            public void onFinish() {

                gameActive = false;
                kreni.setVisibility(View.VISIBLE);
                kreni.setText(brojac1 + "/" + brojac2);
                tajmer.setText("RESET");

                Log.i("gg", "dada");
            }
        };
        tikTok.start();
    }

    public void kreni(View view) {
        pokretanje();

    }

    public void reset(View view) {
        if (tikTok != null) {
            kreni.setText("KRENI");

            tikTok.cancel();
            counter.setText("0/0");
            kreni.setVisibility(View.VISIBLE);

        }


    }

    public void gumb1(View view) {


        if (rezultat == broj1) {
            brojac1++;
            brojac2++;

            funkcija();
            Log.i("d", "dela");

        } else {
            Log.i("d", "krivo");

            brojac2++;
            funkcija();

        }
        counter.setText(brojac1 + "/" + brojac2);
    }


    public void gumb2(View view) {


        if (rezultat == broj2) {
            brojac1++;
            brojac2++;

            funkcija();
            Log.i("d", "dela");

        } else {
            Log.i("d", "krivo");

            brojac2++;
            funkcija();

        }
        counter.setText(brojac1 + "/" + brojac2);
    }


    public void gumb3(View view) {


        if (rezultat == broj3) {
            brojac1++;
            brojac2++;

            funkcija();
            Log.i("d", "dela");

        } else {
            Log.i("d", "krivo");

            brojac2++;
            funkcija();

        }
        counter.setText(brojac1 + "/" + brojac2);
    }

    public void gumb4(View view) {


        if (rezultat == broj4) {
            brojac1++;
            brojac2++;

            funkcija();
            Log.i("d", "dela");

        } else {
            Log.i("d", "krivo");

            brojac2++;
            funkcija();

        }
        counter.setText(brojac1 + "/" + brojac2);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tajmer = (Button) findViewById(R.id.tajmer);
        kreni = (Button) findViewById(R.id.kreni);
        operacija = (TextView) findViewById(R.id.textView5);
        odgovor1 = (Button) findViewById(R.id.button1);
        odgovor2 = (Button) findViewById(R.id.button2);
        odgovor3 = (Button) findViewById(R.id.button3);
        odgovor4 = (Button) findViewById(R.id.button4);
        counter = (TextView) findViewById(R.id.textView4);

    }
}
