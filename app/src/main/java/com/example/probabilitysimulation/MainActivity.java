package com.example.probabilitysimulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button gobutton;
    EditText probtext;
    EditText repeattext;
    TextView result;
    TextView got;
    TextView miss;
    double probability;
    int repetition;
    int tenfold=100;
    Random rand = new Random();
    String resultstring="";
    int randnum;
    int probint;
    int gotcha=0;
    int none=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        probtext= findViewById(R.id.probtext);
        repeattext= findViewById(R.id.repeattext);
        result = findViewById(R.id.result);
        got = findViewById(R.id.gotcount);
        miss = findViewById(R.id.misscount);

        gobutton=findViewById(R.id.gobutton);

        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotcha=0;
                none=0;
                tenfold=100;
                resultstring="";

                if(probtext.getText().toString().isEmpty())
                {
                    probability=0;
                }
                else
                {
                    probability= Double.parseDouble(probtext.getText().toString());
                }

                if(repeattext.getText().toString().isEmpty())
                {
                    repetition=0;
                }
                else
                {
                    repetition = Integer.parseInt(repeattext.getText().toString());
                }

                while(probability<10)
                {
                    probability*=10;
                    tenfold*=10;
                }

                probint = (int) probability;

                for(int i=0;i<repetition;i++)
                {
                    randnum= (rand.nextInt(tenfold))+1;

                    if(randnum<=probint)
                    {
                        resultstring+="Gotcha!\n";
                        gotcha+=1;
                    }
                    else
                    {
                        resultstring+="None\n";
                        none+=1;
                    }
                }

                result.setText(resultstring);
                got.setText(gotcha+"");
                miss.setText(none+"");
            }
        });



    }
}
