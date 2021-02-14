package com.sda.syeddaniyalali.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText txtname,txtemail,txtpass,txtcpass;
    Button btnsignup;
    Spinner sproles;
    String[] roles = {"--Select--","Quiz Taker","Player"};
    TextView tvalreadyaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtname= findViewById(R.id.txtname);
        txtemail= findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpass);
        txtcpass = findViewById(R.id.txtcpass);
        btnsignup = findViewById(R.id.btnsignup);
        sproles = findViewById(R.id.sprole);
        tvalreadyaccount = findViewById(R.id.tvalreadyaccount);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,roles);
        sproles.setAdapter(adapter);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(txtpass.getText().toString().equals(txtcpass.getText().toString()))){

                    Toast.makeText(getApplicationContext(), "password Not Matched", Toast.LENGTH_SHORT).show();
                }
                if(txtemail.getText().toString().trim().isEmpty() || txtname.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Complete the Form", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sproles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(sproles.getSelectedItem().toString()=="Quiz Taker")
                {
                    Toast.makeText(SignupActivity.this, "Login Set For Quiz Taker", Toast.LENGTH_SHORT).show();
                }
                else if(sproles.getSelectedItem().toString()=="Player")
                {
                    Toast.makeText(SignupActivity.this, "Login Set For Players", Toast.LENGTH_SHORT).show();
                }
                else if(sproles.getSelectedItem().toString()=="--Select--")
                {
                    Toast.makeText(SignupActivity.this, "Please select Role", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tvalreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
