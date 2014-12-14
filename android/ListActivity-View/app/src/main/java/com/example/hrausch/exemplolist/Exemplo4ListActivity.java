package com.example.hrausch.exemplolist;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.hrausch.exemplolist.adapter.PessoaAdapter;
import com.example.hrausch.exemplolist.model.Pessoa;

import java.util.ArrayList;


public class Exemplo4ListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Pessoa> list = new ArrayList<Pessoa>();

        list.add(new Pessoa("Pedro","3590-4849",12));
        list.add(new Pessoa("Joao","3590-4849",18));

        setListAdapter(new PessoaAdapter(this,list));

    }



}
