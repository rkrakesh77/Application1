package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Button b;
    AdView ad1,ad2;
    InterstitialAd inter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Gson gson=new Gson();
       *//* Employee e=new Employee("Rakesh","abc@gmail.com",24);
        String json=gson.toJson(e);*//*
       String son="{\"age\": 24,\"mail\": \"abc@gmail.com\",\"name\": \"Rakesh\"}";
        Employee e = gson.fromJson(son,Employee.class);*/
        b=findViewById(R.id.button);
        ad1=findViewById(R.id.ad1);
        ad2=findViewById(R.id.ad2);

        MobileAds.initialize(getApplicationContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdRequest ad=new AdRequest.Builder().build();

        
        ad1.loadAd(ad);
        ad2.loadAd(ad);

        ad1.setAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(int i) {
                Toast.makeText(MainActivity.this, "Not Loaded", Toast.LENGTH_SHORT).show();
            }
        });

       inter=new InterstitialAd(this);
        inter.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        inter.loadAd(new AdRequest.Builder().build());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.show();
            }
        });

    }


}