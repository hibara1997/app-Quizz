package com.example.cm.app_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_quiz2 extends AppCompatActivity {

    RadioGroup rg;
    Button Inext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        rg=findViewById(R.id.rg);
        Inext2=findViewById(R.id.Inext2);
        Inext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(activity_quiz2.this,"select An answer Please",Toast.LENGTH_SHORT);
                }
                else
                {
                    int score=getIntent().getIntExtra("score",0);
                    Intent intent = new Intent(activity_quiz2.this,Activity_quiz_3.class);
                    if(rg.getCheckedRadioButtonId()==R.id.rb4)
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
