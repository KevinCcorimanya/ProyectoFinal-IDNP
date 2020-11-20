package com.example.laboratorio6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    //Método para el botón Login
    public void Login(View view){
        Intent login = new Intent(this,Login.class);
        startActivity(login);
    }

    //método para ingresar en modo anónimo
    public void MainActivity(View view){
        Intent mainActivity = new Intent(Register.this,MainActivity.class);
        startActivity(mainActivity);
    }

    public void registrarUsuario(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnOpcionRegistro:
                miIntent=new Intent(this,RegistroUsuariosActivity.class);
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}
