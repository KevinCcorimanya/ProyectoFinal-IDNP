package com.example.laboratorio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.laboratorio6.fragemtns.TrainingFragment;
import com.example.laboratorio6.fragemtns.MapFragment;
import com.example.laboratorio6.fragemtns.StatisticsFragment;
import com.example.laboratorio6.fragemtns.TrainingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        showSelectedFragment(new TrainingFragment());
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.menu_home){
                    showSelectedFragment(new TrainingFragment());
                }
                if (menuItem.getItemId() == R.id.menu_map){
                    showSelectedFragment(new MapFragment());
                }
                if (menuItem.getItemId() == R.id.menu_statistics){
                    showSelectedFragment(new StatisticsFragment());
                }
                return true;
            }
        });
    }

    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}