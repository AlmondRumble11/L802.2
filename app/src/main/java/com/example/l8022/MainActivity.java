package com.example.l8022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity {
    Button pois;
    Button osta;
    Button lisaa;
    TextView teksti;
    TextView viesti;
    EditText valinta;
    double raha = 0;
    int ticket = 1;
    BottleDispencer bd = BottleDispencer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pois = (Button) findViewById(R.id.nosto);
        osta = (Button) findViewById(R.id.osta);
        lisaa = (Button) findViewById(R.id.lisaa);
        teksti = (TextView) findViewById(R.id.ui);
        viesti = (TextView) findViewById(R.id.tulostus);
        valinta = (EditText) findViewById(R.id.valinta);
        if (ticket == 1){
            bd.lisaaPullot();
            ticket = 0;}
        viesti.setText("You have "+String.format("%.2f", bd.raha)+"€ to spend");;


        int n = 0;

        for (Bottle i : bd.getList()) {
            teksti.append((n + 1) + ". Name: " + i.getName()+"\n"+"	Size: " + i.getSize() + "	Price: " + i.getPrice()+"\n");
            n++;
        }
    }


        public void addMoney(View v){
            double lisays = 1;
            bd.addMoney(lisays);
            viesti.setText("You have "+String.format("%.2f", bd.raha)+"€ to spend");
            ilmotus("Added "+String.format("%.2f", lisays)+" to balance");


        }
        public void returnMoney(View v){
            ilmotus("Klink klink. Money came out! You got "+String.format("%.2f", bd.raha)+"€ back");
            raha = bd.returnMoney();

            viesti.setText("You have "+String.format("%.2f", bd.raha)+"€ to spend");

        }



        public void buyBottle(View v) {
            try {
                int valinta1 = Integer.parseInt(valinta.getText().toString());
                int kokoalussa = bd.getList().size();
                if (valinta1 > bd.getList().size()) {
                    ilmotus("Please select one of the sodas shown");
                } else {
                    bd.buyBottle(valinta1);
                    int kokolopussa = bd.getList().size();
                    if (kokoalussa != kokolopussa) {
                        ilmotus("You got soda " + valinta1 + ". Hope you enjoy it!!");
                    } else if (bd.raha < bd.getList().get(valinta1 - 1).getPrice()) {
                        ilmotus("Not enough money. Add money first");
                    }
                    int n = 0;
                    teksti.setText("");
                    for (Bottle i : bd.getList()) {
                        teksti.append((n + 1) + ". Name: " + i.getName() + "\n" + "	Size: " + i.getSize() + "   Price: " + i.getPrice() + "\n");
                        n++;
                    }
                    valinta.setText("");
                }
                    viesti.setText("You have " + String.format("%.2f", bd.raha) + "€ to spend");
                }catch(NumberFormatException nfe){
                    ilmotus("Please select one of the sodas shown");
                }


        }
        public void ilmotus(String s){
            Toast.makeText(MainActivity.this, s,Toast.LENGTH_SHORT).show();


        }


}
