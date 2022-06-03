package com.example.controle2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Editer extends AppCompatActivity {
    Button update,supp;
    EditText nom,secteur,nb_employe;
    MyDatabase mydb=new MyDatabase(this);
    Spinner sp;
    ArrayList<Societe> lis_so;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer);
        update=(Button)findViewById(R.id.btn_update);
        supp=(Button)findViewById(R.id.btn_supp);
        nom=(EditText)findViewById(R.id.txt_nom2);
        secteur=(EditText)findViewById(R.id.txt_secteur2);
        nb_employe=(EditText)findViewById(R.id.txt_nb_employe2);
        sp=findViewById(R.id.sp);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Editer.this);
                builder1.setMessage("tu veux ajouter cette societe");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String id2=sp.getSelectedItem().toString();
                                Societe so=new Societe(Integer.getInteger(id2),nom.getText().toString(),secteur.getText().toString(),Integer.getInteger(nb_employe.getText().toString()));
                                MyDatabase.UpdateSociete(mydb.getWritableDatabase(),so);
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Editer.this);
                builder1.setMessage("vouller vraiment supprimer !!");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String id2=sp.getSelectedItem().toString();
                                Societe so=new Societe(Integer.getInteger(id2),nom.getText().toString(),secteur.getText().toString(),Integer.getInteger(nb_employe.getText().toString()));
                                MyDatabase.DeleteSociete(mydb.getWritableDatabase(),Integer.getInteger(id2));
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
        ArrayList<String> list_string=new ArrayList<>();

//        SQLiteDatabase db=mydb.getWritableDatabase();

        lis_so=MyDatabase.getAllSociete(mydb.getReadableDatabase());
        for (Societe s:lis_so){
            list_string.add(String.valueOf(s.getID()));
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,list_string);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe s=lis_so.get(i);
                nom.setText(s.getNom());
                secteur.setText(s.getSecteur_Activite());
                nb_employe.setText(s.getNb_employe());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}