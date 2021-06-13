package com.example.teo.anagramgame;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity {
    private TextView word;
    private EditText find_word;
    private String wordtofind;
    private Button validate;
    private Button Form;
    int right_ans = 0;
    int wrong_ans = 0;
    private int total = 0;
    private int choice;
    private int vib;
    static String Statistics = "Statistics";
    Bundle b;
    Intent intent;
    Bundle b1 = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_1);
        intent = getIntent();
        Form = (Button) findViewById(R.id.Form);
        word = (TextView) findViewById(R.id.word);
        find_word = (EditText) findViewById(R.id.find_word);
        validate = (Button) findViewById(R.id.validate);
        b = intent.getBundleExtra(SettingsActivity.Settings);
        generate();
        if (b != null) {
            if (b.containsKey("vib")) {
                vib = b.getInt("vib");
            }
            if (b.containsKey("choice")) {
                choice = b.getInt("choice");
            }
        }
        else {
            choice = 0;
            vib = 1;
        }
        if (MainActivity.choice == 1)
        {
            CommonMethod.player.start();
        }
        generate();
            validate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String w = find_word.getText().toString();
                    if (wordtofind.equals(w)) {
                        if (vib == 1) {
                            Vibrator a = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            a.vibrate(500);
                            Toast.makeText(getApplication().getBaseContext(), "Congragulations!", Toast.LENGTH_SHORT).show();
                            generate();
                            find_word.setText("");
                            right_ans++;
                            total++;
                        }
                        else {
                            Toast.makeText(getApplication().getBaseContext(), "Congragulations!", Toast.LENGTH_SHORT).show();
                            generate();
                            find_word.setText("");
                            right_ans++;
                            total++;
                        }
                    }
                    else {
                        if (vib == 1) {
                            Vibrator a = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            a.vibrate(1000);
                            Toast.makeText(getApplication().getBaseContext(), "Please try again :(", Toast.LENGTH_SHORT).show();
                            find_word.setText("");
                            wrong_ans++;
                            total++;
                        }
                        else{
                            Toast.makeText(getApplication().getBaseContext(), "Please try again :(", Toast.LENGTH_SHORT).show();
                            find_word.setText("");
                            wrong_ans++;
                            total++;
                        }
                    }
                }
            });
            Form.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    intent = new Intent(GameActivity.this,StatisticsActivity.class);
                    b1.putInt("right_ans", right_ans);
                    b1.putInt("wrong_ans", wrong_ans);
                    b1.putInt("total", total);
                    intent.putExtra(Statistics,b1);
                    startActivityForResult(intent,0);
                }
        });
    }
    private void generate() {
        if (choice == 0) {
            wordtofind = AnagramGame.getRandomWord();
        }
        else if (choice == 1){
            wordtofind = AnagramGame.getRandomWordMedium();
        }
        else if (choice == 2){
            wordtofind = AnagramGame.getRandomWordExpert();
        }
        String shuffledword = AnagramGame.ShuffleWord(wordtofind);
        word.setText(shuffledword);
    }
}
