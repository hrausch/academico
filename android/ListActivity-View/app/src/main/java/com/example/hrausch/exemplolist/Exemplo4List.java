package com.example.hrausch.exemplolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.hrausch.exemplolist.adapter.PessoaAdapter;
import com.example.hrausch.exemplolist.model.Pessoa;

import java.util.ArrayList;


public class Exemplo4List extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo4_list);

        ArrayList<Pessoa> list = new ArrayList<Pessoa>();

        list.add(new Pessoa("Pedro","3590-4849",12));
        list.add(new Pessoa("Joao","3590-4849",18));

        PessoaAdapter pAdapter = new PessoaAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(pAdapter);


    }



}
