package com.example.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laboratorio6.entidades.Usuario;


public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, password;
    Button btnIngresar, btnRegistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nombre = (EditText) findViewById(R.id.login_nombre);
        password = (EditText) findViewById(R.id.login_contraseña);
        btnIngresar = (Button) findViewById(R.id.btnlogin_ingresar);
        btnRegistrar = (Button) findViewById(R.id.btnlogin_registrar);

        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        dao = new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlogin_ingresar:
                String n = nombre.getText().toString();
                String p = password.getText().toString();
                if(n.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error: Campos Vacios",Toast.LENGTH_LONG).show();
                }else if(dao.login(n,p)==1){
                    Usuario ux = dao.getUsuario(n,p);
                    Toast.makeText(this,"Datos Correctos",Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(this,MainActivity.class);
                    i2.putExtra("id",ux.getId());
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this,"Nombre y/o Password incorrectos",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnlogin_registrar:
                Intent i = new Intent(this,Register.class);
                startActivity(i);
                break;
        }
    }
}
