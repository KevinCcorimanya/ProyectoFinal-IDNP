package com.example.laboratorio6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laboratorio6.entidades.Usuario;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText correo, nombre, password;
    Button btnRegistrarse, btnAnonimo;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nombre = (EditText) findViewById(R.id.register_nombre);
        correo = (EditText) findViewById(R.id.register_correo);
        password = (EditText) findViewById(R.id.register_password);
        btnRegistrarse = (Button) findViewById(R.id.btnregister_registrar);
        btnAnonimo = (Button) findViewById(R.id.btnregister_anonimo);

        btnRegistrarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnregister_registrar:
                Usuario u = new Usuario();
                u.setCorreo(correo.getText().toString());
                u.setNombre(nombre.getText().toString());
                u.setPassword(password.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this,"Error: Campos Vacios",Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"Error: Registro exitoso",Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(this,Login.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this,"Usuario ya registrado !!!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnregister_anonimo:
                break;
        }
    }
}
