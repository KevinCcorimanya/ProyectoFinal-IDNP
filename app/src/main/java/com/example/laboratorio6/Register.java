package com.example.laboratorio6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //Método para el botón Login
    public void Login(View view){
        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }
}
