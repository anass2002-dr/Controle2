package com.example.controle2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static String db_name="societe";
    public static String table_name="Societe";
    public static String id="id";
    public static String raison="Raison_Sociale";
    public static String secteur="Secteur_activite";
    public static String nb_employe="nb_employe";
    public MyDatabase(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+table_name+" ("+id+"integer primary key autoincrement,"+raison+" Text, "+secteur+" Text, "+nb_employe+" integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "DROP TABLE Societe";
        db.execSQL(query);
    }

    public static long AddSociete(SQLiteDatabase db, Societe e){
        ContentValues ct = new ContentValues();
        ct.put(id,e.getID());
        ct.put(raison,e.getNom());
        ct.put(secteur,e.getSecteur_Activite());
        ct.put(nb_employe,e.getNb_employe());
        return db.insert(table_name,null,ct);
    }
    public static long UpdateSociete(SQLiteDatabase db, Societe e){
        ContentValues ct = new ContentValues();
        ct.put(id,e.getID());
        ct.put(raison,e.getNom());
        ct.put(secteur,e.getSecteur_Activite());
        ct.put(nb_employe,e.getNb_employe());
        return db.update(table_name,ct,"id="+e.getID(),null);
    }
    public static long  DeleteSociete(SQLiteDatabase db, int id){
        return db.delete(table_name,"id="+id,null);
    }
    public static ArrayList<Societe>  getAllSociete(SQLiteDatabase db){
        ArrayList<Societe> so = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + table_name,null);

        while(cursor.moveToNext()){
            Societe p = new Societe();
            p.setID(cursor.getInt(0));
            p.setNom(cursor.getString(1));
            p.setSecteur_Activite(cursor.getString(2));
            p.setNb_employe(cursor.getInt(3));
            so.add(p);
        }
        return so;
    }
    public static Societe getOneSociete(SQLiteDatabase db, int id){
        Societe s = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + table_name + " WHERE id = " + id,null);

        if(cursor.moveToNext()){
            s = new Societe();
            s.setID(cursor.getInt(0));
            s.setNom(cursor.getString(1));
            s.setSecteur_Activite(cursor.getString(2));
            s.setNb_employe(cursor.getInt(3));
        }

        return s;
    }
}
