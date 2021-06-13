package com.example.teo.anagramgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button newGame;
    private Button Settings;
    private Button Sound_on;
    private Button Sound_off;
    private Button About;
    Intent in1;
    Intent in2;
    Intent in3;
    Bundle b;
    Intent intent;
    static int choice = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        About = (Button) findViewById(R.id.About);
        newGame = (Button) findViewById(R.id.NewGame);
        Settings = (Button) findViewById(R.id.Settings);
        Sound_on = (Button) findViewById(R.id.sound_on);
        Sound_off = (Button) findViewById(R.id.sound_off);
        if (choice == 1) {
            CommonMethod.SoundPlayer(MainActivity.this, R.raw.sound);
            CommonMethod.player.start();
        }
        if (choice == 0)
        {
            CommonMethod.player.stop();
        }

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in1 = new Intent(MainActivity.this, GameActivity.class);
                b = intent.getBundleExtra(SettingsActivity.Settings);
                in1.putExtra(SettingsActivity.Settings, b);
                startActivityForResult(in1,1);
            }
        });
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in2 = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(in2);
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in3 = new Intent(MainActivity.this,About_activity.class);
                startActivity(in3);
            }
        });
        Sound_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 1;
                if (!CommonMethod.player.isPlaying()){
                        CommonMethod.SoundPlayer(MainActivity.this, R.raw.sound);
                }

            }
        });
        Sound_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = 0;
                CommonMethod.player.stop();
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        CommonMethod.player.pause();
    }
    protected void onResume(){
        super.onResume();
        if (choice == 1){
            CommonMethod.player.start();
        }
    }
}
