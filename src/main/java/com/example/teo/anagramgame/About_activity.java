package com.example.teo.anagramgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class About_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_activity);
        if (MainActivity.choice == 1){
            CommonMethod.player.start();
        }
    }
}
