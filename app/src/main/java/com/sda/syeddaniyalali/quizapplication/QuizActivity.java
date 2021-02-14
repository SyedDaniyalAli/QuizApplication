package com.sda.syeddaniyalali.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    TextView tvtime,tvquest;
    RadioButton radioButton, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
}
