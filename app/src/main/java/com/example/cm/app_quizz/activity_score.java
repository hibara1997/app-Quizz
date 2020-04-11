package com.example.cm.app_quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class activity_score extends AppCompatActivity {

    CircleProgress circleprogress;
    Button Retry,Exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        circleprogress=findViewById(R.id.circle_progress);
        Retry=findViewById(R.id.Retry);
        Exit=findViewById(R.id.Exit);

        Intent i = getIntent();
        int x = i.getIntExtra("score",0);
        circleprogress.setMax(4);
        circleprogress.setProgress(x);

        Retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_score.this,activity_Quiz1.class);
                startActivity(intent);
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_score.this,login_activity.class);
                startActivity(intent);
            }
        });
    }
}
