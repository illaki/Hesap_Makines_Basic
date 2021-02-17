package com.mcanererdem.hesapmakinesbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etSayiBir,etSayiIki;
    int sayi1,sayi2;
    TextView tvSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSayiBir = findViewById(R.id.editTextNumber);
        etSayiIki = findViewById(R.id.editTextNumber2);
        tvSonuc = findViewById(R.id.textViewSonuc);
    }

    public void hesapla(View view) {
        boolean devam = false;
        try {
            if(etSayiBir.getText().toString() != null && !etSayiBir.getText().toString().matches("")) {
                sayi1 = Integer.valueOf(etSayiBir.getText().toString());

                if (etSayiIki.getText().toString() != null && !etSayiIki.getText().toString().matches("")){
                    sayi2 = Integer.valueOf(etSayiIki.getText().toString());
                    devam = true;

                }else {
                    Toast.makeText(this,"Boş Bırakma!",Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(this,"Boş Bırakma!",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e) {
            Toast.makeText(this,"Hata: " + e.toString(),Toast.LENGTH_LONG).show();
        }


        if (view.getId() == R.id.buttonTopla && devam) {
            yazdir(sayi1 + sayi2);

        }else if (view.getId() == R.id.buttonCikar && devam){
            yazdir(sayi1 - sayi2);

        }else if (view.getId() == R.id.buttonCarp && devam) {
            yazdir(sayi1 * sayi2);

        }else if (view.getId() == R.id.buttonBol  && devam){
            if (sayi2 != 0) {
                yazdir(sayi1 / sayi2);
                }
            else {
                yazdir(0);
            }
        }
    }

    public void yazdir(int gelenSayi) {
        tvSonuc.setText(String.valueOf(gelenSayi));
        etSayiBir.setText("");
        etSayiIki.setText("");
    }
}