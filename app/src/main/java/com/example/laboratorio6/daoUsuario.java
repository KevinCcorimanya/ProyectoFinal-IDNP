package com.example.laboratorio6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.laboratorio6.entidades.Usuario;

import java.util.*;

public class daoUsuario {

    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "DBUsuarios";
    String tabla = "create table if not exists usuario(id integer primary key autoincrement, correo text, nombre text, password text)";

    public daoUsuario(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertUsuario(Usuario u){
        if(buscar(u.getCorreo())==0){
            ContentValues cv = new ContentValues();
            cv.put("correo",u.getCorreo());
            cv.put("nombre",u.getNombre());
            cv.put("password",u.getPassword());
            return (sql.insert("usuario",null,cv)>0);
        }else{
            return false;
        }
    }

    private int buscar(String correo) {
        int x = 0;
        lista = selectUsuario();
        for (Usuario us: lista) {
            if(us.getCorreo().equals(u))
                x++;
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuario(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setCorreo(cr.getString(1));
                u.setNombre(cr.getString(2));
                u.setPassword(cr.getString(3));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

    public int login(String u, String p){
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                if(cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());
        }
        return a;
    }

    public Usuario getUsuario(String u, String p) {
        lista = selectUsuario();
        for (Usuario us:lista) {
            if(us.getNombre().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }

    public Usuario getUsuariobyID(int id) {
        lista = selectUsuario();
        for (Usuario us:lista) {
            if(us.getId()==id){
                return us;
            }
        }
        return null;
    }
}
