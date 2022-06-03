package com.example.controle2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter extends AppCompatActivity {
    Button enregistre,annuler;
    EditText nom,secteur,nb_employe;
    MyDatabase mydb=new MyDatabase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        enregistre=(Button)findViewById(R.id.btn_enregistre);
        annuler=(Button)findViewById(R.id.btn_annuler);
        nom=(EditText)findViewById(R.id.txt_nom);
        secteur=(EditText)findViewById(R.id.txt_secteur);
        nb_employe=(EditText)findViewById(R.id.txt_nb_employe);

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Ajouter.this, com.example.controle2.MainActivity.class);
                startActivity(intent);
            }
        });
        enregistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=mydb.getWritableDatabase();
                Societe societe=new Societe(nom.getText().toString(),secteur.getText().toString(),Integer.valueOf(nb_employe.getText().toString()));
                if(MyDatabase.AddSociete(db,societe)==-1)
                    Toast.makeText(Ajouter.this, "error", Toast.LENGTH_SHORT).show();
                else Toast.makeText(Ajouter.this, "ajouter avec succès", Toast.LENGTH_SHORT).show();
            }
        });
    }
}