package com.example.teo.anagramgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class StatisticsActivity extends AppCompatActivity {
    private Button Form;
    private Button Reset;
    private TextView Stats;
    private TextView RightAns;
    private TextView WrongAns;
    private double  rightans;
    private  double wrongans;
    private double total;
    DecimalFormat df = new DecimalFormat("#.00");
    DecimalFormat df1 = new DecimalFormat("#");
    private double stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Form = (Button) findViewById(R.id.Form);
        Reset = (Button) findViewById(R.id.Reset);
        RightAns = (TextView) findViewById(R.id.right_ans);
        WrongAns = (TextView) findViewById(R.id.wrong_ans);
        Stats = (TextView) findViewById(R.id.Stats);
        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra(GameActivity.Statistics);
        if (b != null) {
            total = b.getInt("total");
            rightans = b.getInt("right_ans");
            wrongans = b.getInt("wrong_ans");
        }

        if (MainActivity.choice == 1)
        {
            CommonMethod.player.start();
        }
        Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (total != 0) {
                    stats = (rightans / total);
                }
                else if (rightans == 0){
                    Stats.setText("0.0%");
                }
                else{
                    stats = 0.0;
                }
                Stats.setText("Total right answers:"+"\n"+ df.format(stats*100) + "%");
                RightAns.setText("Right answers:"+"\n"+df1.format(rightans));
                WrongAns.setText("Wrong answers:"+"\n"+df1.format(wrongans));
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RightAns.setText("0");
                WrongAns.setText("0");
                Stats.setText("0%");
            }
        });
    }
}
