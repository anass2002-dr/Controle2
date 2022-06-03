package com.example.controle2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lister extends AppCompatActivity {
    ListView li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);
        li=findViewById(R.id.list);
        ArrayList<Societe> ss=new ArrayList<>();

        MyDatabase db=new MyDatabase(this);
        ss=MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<String> stt=new ArrayList<>();
        for (Societe s:ss){
            stt.add("nom de societe :"+s.getNom()+"\n"+"nom employer :"+s.getNb_employe());
        }
        ArrayAdapter<String> arr=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,stt);
        li.setAdapter(arr);
    }
}