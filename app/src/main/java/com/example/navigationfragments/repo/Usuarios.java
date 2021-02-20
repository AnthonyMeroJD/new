package com.example.navigationfragments.repo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.utils.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {

    public  static  void  eliminarUsuario(Context context,String cedula){
        String qry="DELETE FROM usuarioss WHERE cedula= "+cedula;
        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
            enlaceBaseDatos.execSQL(qry);
        }catch (Exception e){

        }
    }

    public static void EditarUsuario(Context context,String cedula,Usuario user){
        String qry="UPDATE usuarioss\n" +
                "SET nombre = \""+user.getNombre().trim()+"\" , "+
                "pass = "+user.getPassword().trim()+" , "+
                "numero = "+user.getTelefono().trim()+" , "+
                "direccion =\""+user.getDireccion().trim()+"\" , "+
                "ciudad = \""+user.getCiudad().trim()+"\" , "+
                "cedula = "+user.getCedula().trim()+"  "+
                "WHERE cedula = "+cedula;
        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
            enlaceBaseDatos.execSQL(qry);
        }catch (Exception e){

        }

    }

    public static Usuario getUserByCi(Context context,String cedula)throws NullPointerException{
        Usuario user=null;

        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
            Cursor c = enlaceBaseDatos.rawQuery(" SELECT * FROM usuarioss WHERE cedula= "+cedula.trim(),
                    null);
            if (c!=null ) {
                c.moveToFirst();
                do {
                    String nombre = c.getString(c.getColumnIndex("nombre"));
                    String pass = c.getString(c.getColumnIndex("pass"));
                    String numero = c.getString(c.getColumnIndex("numero"));
                    String direccion = c.getString(c.getColumnIndex("direccion"));
                    String ciudad = c.getString(c.getColumnIndex("ciudad"));
                    String rol = c.getString(c.getColumnIndex("rol"));
                    user = new Usuario(cedula, nombre, pass,ciudad, numero, direccion, rol);
                    break;
                } while (c.moveToNext());
                return user;
            }else {return null;}

        }catch(Exception e) {
            return user;
        }

    }

    public static  List<Usuario> getUsersByLikeCedula(Context context, String cedula) throws NullPointerException{
        List<Usuario> arrayUsuario = new ArrayList<Usuario>();

        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
        Cursor c = enlaceBaseDatos.rawQuery(" SELECT * FROM usuarioss WHERE cedula LIKE \""+cedula.trim()+"%\"",
                null);
        if (c!=null ){
            c.moveToFirst();
            do {
                String nombre=c.getString(c.getColumnIndex("nombre"));
                String pass=c.getString(c.getColumnIndex("pass"));
                String numero=c.getString(c.getColumnIndex("numero"));
                String direccion=c.getString(c.getColumnIndex("direccion"));
                String ciudad=c.getString(c.getColumnIndex("ciudad"));
                String rol=c.getString(c.getColumnIndex("rol"));
                Usuario user=new Usuario(cedula,nombre,pass,ciudad,numero,direccion,rol);
                arrayUsuario.add(user);
            }while (c.moveToNext());
        }
        return arrayUsuario;
        }catch (Exception e){
            return null;
        }
    }

    public static  List<Usuario> getUsersByRank(Context context, String initFecha,String finalFecha) throws NullPointerException{
        List<Usuario> arrayUsuario = new ArrayList<Usuario>();
        String sql= " SELECT * FROM usuarioss WHERE fecha_creacion BETWEEN "+initFecha +" AND "+ finalFecha;
        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
            Cursor c = enlaceBaseDatos.rawQuery(sql,
                    null);
            if (c!=null ){
                c.moveToFirst();
                do {
                    String nombre=c.getString(c.getColumnIndex("nombre"));
                    String pass=c.getString(c.getColumnIndex("pass"));
                    String numero=c.getString(c.getColumnIndex("numero"));
                    String direccion=c.getString(c.getColumnIndex("direccion"));
                    String ciudad=c.getString(c.getColumnIndex("ciudad"));
                    String rol=c.getString(c.getColumnIndex("rol"));
                    String ci=c.getString(c.getColumnIndex("cedula"));
                    Usuario user=new Usuario(ci,nombre,pass,ciudad,numero,direccion,rol);
                    arrayUsuario.add(user);
                }while (c.moveToNext());
            }
            return arrayUsuario;
        }catch (Exception e){
            System.out.println("null");
            return null;
        }
    }

    public static  List<Usuario> getAllUsers(Context context){
        List<Usuario> arrayUsuario = new ArrayList<Usuario>();
        try {


        SQLHelper sqlHelper = new SQLHelper(context);
        SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
        Cursor c = enlaceBaseDatos.rawQuery(" SELECT * FROM usuarioss ",
                null);
        if (c!=null){
            c.moveToFirst();
            do {
                String nombre=c.getString(c.getColumnIndex("nombre"));
                String cedula=c.getString(c.getColumnIndex("cedula"));
                String pass=c.getString(c.getColumnIndex("pass"));
                String numero=c.getString(c.getColumnIndex("numero"));
                String direccion=c.getString(c.getColumnIndex("direccion"));
                String ciudad=c.getString(c.getColumnIndex("ciudad"));
                String rol=c.getString(c.getColumnIndex("rol"));
                System.out.println(c.getString(c.getColumnIndex("fecha_creacion")));
                Usuario user=new Usuario(cedula,nombre,pass,ciudad,numero,direccion,rol);
                arrayUsuario.add(user);
            }while (c.moveToNext());
        }
        return arrayUsuario;
        }catch (Exception e){
            return arrayUsuario;
        }
    }

    public static boolean registrar(Usuario usuario, Context context){

        SQLHelper sqlHelper = new SQLHelper(context);
        SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
        if (enlaceBaseDatos != null){
            ContentValues cv = new ContentValues();
            cv.put("cedula", usuario.getCedula());
            cv.put("nombre", usuario.getNombre());
            cv.put("pass", usuario.getPassword());
            cv.put("numero",usuario.getTelefono());
            cv.put("direccion", usuario.getDireccion());
            cv.put("ciudad", usuario.getCiudad());
            cv.put("rol", usuario.getRol());
            enlaceBaseDatos.insert("usuarioss",   null, cv);
            return true;

        }else{
            return false;
        }

       
    }

    public static boolean inicarSesion(String cedula, String password, Context context){
        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
            Cursor c = enlaceBaseDatos.rawQuery(" SELECT cedula , pass FROM usuarioss WHERE cedula="+cedula+" AND "+"pass="+password,
                    null);
            boolean validate = false;
            if (c!=null){
                validate=true;
            }
            return validate;
        }catch (Exception e){
            Toast.makeText(context,"Error en las credenciales",Toast.LENGTH_LONG);
            return false;
        }

    }

    public static String whoIsThisUser(String cedula, String password, Context context){
        try {
            SQLHelper sqlHelper = new SQLHelper(context);
            SQLiteDatabase enlaceBaseDatos = sqlHelper.getWritableDatabase();
            Cursor c = enlaceBaseDatos.rawQuery(" SELECT rol FROM usuarioss WHERE cedula="+cedula+" AND "+"pass="+password,
                    null);
            String rol = "undefine";
            if (c!=null){
                c.moveToFirst();
                do {
                    rol=c.getString(c.getColumnIndex("rol"));
                }while (c.moveToNext());
            }
            return rol;
        }catch (Exception e){
            Toast.makeText(context,"Error en las credenciales",Toast.LENGTH_LONG);
            return "undefine";
        }

    }




}
