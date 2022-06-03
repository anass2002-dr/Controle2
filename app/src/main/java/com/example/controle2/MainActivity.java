package com.example.controle2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ajouter,editer,liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajouter=(Button)findViewById(R.id.btn_ajouter);
        editer=(Button)findViewById(R.id.btn_edite);
        liste=(Button)findViewById(R.id.btn_list);


        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.example.controle2.Ajouter.class);
                startActivity(intent);
            }
        });
        editer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.example.controle2.Editer.class);
                startActivity(intent);
            }
        });
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.example.controle2.Lister.class);
                startActivity(intent);
            }
        });
    }
}