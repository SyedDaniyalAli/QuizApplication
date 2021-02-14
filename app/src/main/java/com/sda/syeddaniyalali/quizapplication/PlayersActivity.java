package com.sda.syeddaniyalali.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayersActivity extends AppCompatActivity {
        Button btnquiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        btnquiz = findViewById(R.id.btnquiz);



        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayersActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
