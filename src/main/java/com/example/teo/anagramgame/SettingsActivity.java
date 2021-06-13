package com.example.teo.anagramgame;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;


public class SettingsActivity extends AppCompatActivity {

    private RadioGroup Difficulty;
    private RadioGroup Vibrate;
    private Button Save;
    static Intent intent;
    Bundle b = new Bundle();
    static int choice = 0;
    static int vib = 1;
    static String Settings = "Settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Difficulty = (RadioGroup) findViewById(R.id.difficulty);
        Vibrate = (RadioGroup) findViewById(R.id.vibrate);
        Save = (Button) findViewById(R.id.Save);
         intent = new Intent(SettingsActivity.this,MainActivity.class);
        if (MainActivity.choice == 1)
        {
            CommonMethod.player.start();
        }
        Difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup Difficulty, int checkedID) {
                if (checkedID == R.id.Diff_easy) {
                    choice = 0;
                } else if (checkedID == R.id.Diff_medium) {
                    choice = 1;
                } else if (checkedID == R.id.Diff_hard) {
                    choice = 2;
                }
            }
        });
        Vibrate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
        public void onCheckedChanged(RadioGroup Vibrate, int checkedID){
            if (checkedID == R.id.Vibrate_yes){
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
                vib = 1;
            }
            else if (checkedID == R.id.Vibrate_no){
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(0);
                vib = 0;
            }
        }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.putInt("choice",choice);
                b.putInt("vib",vib);
                intent.putExtra(Settings,b);
                startActivityForResult(intent,0);
                if (MainActivity.choice == 1){
                    CommonMethod.player.reset();
                    MainActivity.choice = 1;
                }
            }
        });
    }
}
