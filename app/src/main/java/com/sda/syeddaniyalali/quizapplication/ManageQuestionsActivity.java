package com.sda.syeddaniyalali.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ManageQuestionsActivity extends AppCompatActivity {
        EditText txtquest;
        Spinner spcat;
        Button btnsubmit;
        ListView lstquestions;

    String[] cat = {"--Select--","English","Maths"};

    ArrayList<String> Mquestions=new ArrayList<String>();
    ArrayList<String> Equestion=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_questions);

        txtquest = findViewById(R.id.txtquest);
        spcat = findViewById(R.id.spcat);
        btnsubmit=findViewById(R.id.btnsubmit);
        lstquestions = findViewById(R.id.lstQuestion);

        //AddItems
        Mquestions.add("2+4=6?");
        Mquestions.add("6+6=6?");
        Mquestions.add("5+9=16?");
        Mquestions.add("7*3=21?");
        Mquestions.add("2+4=6?");
        Mquestions.add("2/2=1?");

        Equestion.add("Earth is Round? ");
        Equestion.add("Earth is Oval? ");
        Equestion.add("Earth is Triangular ");
        Equestion.add("Earth is Round? ");
        Equestion.add("Earth is Oval? ");
        Equestion.add("Earth is Triangular ");



        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,cat);
        spcat.setAdapter(adapter);

        ArrayAdapter adapterE = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,Equestion);
        lstquestions.setAdapter(adapterE);

        spcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spcat.getSelectedItem().toString()=="English")
                {
                    ArrayAdapter adapterE = new ArrayAdapter(ManageQuestionsActivity.this,R.layout.support_simple_spinner_dropdown_item,Equestion);
                    lstquestions.setAdapter(adapterE);
                }
                else if(spcat.getSelectedItem().toString()=="Maths")
                {
                    ArrayAdapter adapterM = new ArrayAdapter(ManageQuestionsActivity.this,R.layout.support_simple_spinner_dropdown_item,Mquestions);
                    lstquestions.setAdapter(adapterM);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Equestion.add(txtquest.getText().toString());

                ArrayAdapter adapterE = new ArrayAdapter(ManageQuestionsActivity.this,R.layout.support_simple_spinner_dropdown_item,Equestion);
                lstquestions.setAdapter(adapterE);
            }
        });


    }
}
