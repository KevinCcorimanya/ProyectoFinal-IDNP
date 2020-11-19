package com.example.laboratorio6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laboratorio6.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoCorreo,campoNombre,campoPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        campoCorreo= (EditText) findViewById(R.id.campoCorreo);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoPassword= (EditText) findViewById(R.id.campoPassword);
    }
    
    public void onClick(View view){
        //registrarUsuarios();
        registrarUsuariosSql();

    }

    private void registrarUsuariosSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (correo,nombre,password) values('kcc@unsa.edu.pe','Kevin','1234')

        String insert="INSERT INTO "+Utilidades.TABLA_USUARIO
                +" ( " +Utilidades.CAMPO_CORREO+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_PASSWORD+") " +
                " VALUES ('"+campoCorreo.getText().toString()+"', '"+campoNombre.getText().toString()+"','"
                +campoPassword.getText().toString()+"')";

        db.execSQL(insert);

        db.close();
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_CORREO,campoCorreo.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD,campoPassword.getText().toString());

        Long correoResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CORREO,values);

        Toast.makeText(getApplicationContext(), "Correo Registro: "+correoResultante,Toast.LENGTH_SHORT).show();
        db.close();

    }
}
