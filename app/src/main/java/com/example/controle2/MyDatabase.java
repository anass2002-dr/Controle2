package com.example.controle2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    private static String db_name="societe";
    public MyDatabase(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table Societe (ID integer primary key autoincrement,Raison_Sociale Text, Secteur_activite Text, nb_employe integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "DROP TABLE Societe";
        db.execSQL(query);
    }
}
