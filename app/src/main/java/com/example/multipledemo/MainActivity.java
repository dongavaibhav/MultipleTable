package com.example.multipledemo;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // declare the variable
    private Button btnStore, btnGetAll;
    private EditText etName, etHobby, etCity;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        findId();
        clickListener();
    }

    private void findId() {
        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetAll = (Button) findViewById(R.id.btnget);
        etName = (EditText) findViewById(R.id.etname);
        etHobby = (EditText) findViewById(R.id.ethobby);
        etCity = (EditText) findViewById(R.id.etcity);
    }

    private void clickListener() {
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidationEditText validation = new ValidationEditText();
                validation.validEdittext(etName, etHobby, etCity, databaseHelper);
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetAllUsersActivity.class);
                startActivity(intent);
            }
        });
    }
}