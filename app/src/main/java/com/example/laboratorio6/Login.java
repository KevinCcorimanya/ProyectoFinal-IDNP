package com.example.laboratorio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.laboratorio6.fragemtns.HomeFragment;
import com.example.laboratorio6.fragemtns.MapFragment;
import com.example.laboratorio6.fragemtns.StatisticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //método el botón para mandar a register
    public void Register(View view){
        Intent register = new Intent(this,Register.class);
        startActivity(register);
    }
}
