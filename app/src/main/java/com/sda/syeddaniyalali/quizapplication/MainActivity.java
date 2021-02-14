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

import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
EditText txtemail,txtpass;
Button btnlogin;
TextView tvaccount;
Spinner Lsprole;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtemail=findViewById(R.id.txtemail);
        txtpass = findViewById(R.id.txtpass);
        tvaccount = findViewById(R.id.tvaccount);
        btnlogin=findViewById(R.id.btnlogin);
        Lsprole=findViewById(R.id.Lsprole);
        String[] roles = {"--Select--","Quiz Taker","Player"};

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,roles);
        Lsprole.setAdapter(adapter);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!(txtemail.getText().toString().isEmpty() || txtpass.getText().toString().isEmpty()))
                {
                    if(Lsprole.getSelectedItem().toString()=="Quiz Taker")
                    {
                        Intent intent = new Intent(MainActivity.this, ManageQuestionsActivity.class);
                        startActivity(intent);
                    }
                    else if(Lsprole.getSelectedItem().toString()=="Player")
                    {
                        Intent intent = new Intent(MainActivity.this, PlayersActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Please Select Role", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Complete the Form", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Lsprole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(Lsprole.getSelectedItem().toString()=="Quiz Taker")
                {
                    Toast.makeText(MainActivity.this, "Login Set For Quiz Taker", Toast.LENGTH_SHORT).show();
                }
                else if(Lsprole.getSelectedItem().toString()=="Player")
                {
                    Toast.makeText(MainActivity.this, "Login Set For Players", Toast.LENGTH_SHORT).show();
                }
                else if(Lsprole.getSelectedItem().toString()=="--Select--")
                {
                    Toast.makeText(MainActivity.this, "Please select Role", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
