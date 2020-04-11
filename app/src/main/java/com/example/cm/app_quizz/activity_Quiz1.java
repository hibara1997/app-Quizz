package com.example.cm.app_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_Quiz1 extends AppCompatActivity {

    RadioGroup rg;
    Button Inext1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__quiz1);
        rg = findViewById(R.id.rg);
        Inext1 = findViewById(R.id.Inext1);
        Inext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(activity_Quiz1.this, "select An answer Please", Toast.LENGTH_SHORT);
                } else {
                    int score=0;
                    Intent intent = new Intent(activity_Quiz1.this, activity_quiz2.class);
                    if(rg.getCheckedRadioButtonId()==R.id.rb1){
                        score++;
                    }
                    intent.putExtra("score",score);
                    startActivity(intent);
                }
            }
        });
    }
}
