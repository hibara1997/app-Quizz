package com.example.cm.app_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_quiz4 extends AppCompatActivity {

    RadioGroup rg;
    Button Inext4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        rg=findViewById(R.id.rg);
        Inext4=findViewById(R.id.Inext4);
        Inext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(activity_quiz4.this, "select An answer Please", Toast.LENGTH_SHORT);
                }
                else {
                    int score=getIntent().getIntExtra("score",0);
                    Intent intent = new Intent(activity_quiz4.this, activity_score.class);
                    if(rg.getCheckedRadioButtonId()==R.id.rb3)
                    {
                        score++;
                    }
                    Toast.makeText(activity_quiz4.this,"your score is "+score,Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });
            }
}
