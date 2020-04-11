package com.example.cm.app_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity_quiz_3 extends AppCompatActivity {

    RadioGroup rg;
    Button Inext3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_3);
        rg=findViewById(R.id.rg);
        Inext3=findViewById(R.id.Inext3);
        Inext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Activity_quiz_3.this, "select An answer Please", Toast.LENGTH_SHORT);
                }
                else {
                    int score=getIntent().getIntExtra("score",0);
                    Intent intent = new Intent(Activity_quiz_3.this, activity_quiz4.class);
                    if(rg.getCheckedRadioButtonId()==R.id.rb3)
                    {
                        score++;
                    }
                    intent.putExtra("score",score);
                    startActivity(intent);
                }


            }
        });
        }
    }