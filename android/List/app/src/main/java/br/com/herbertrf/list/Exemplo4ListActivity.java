package br.com.herbertrf.list;

import android.app.ListActivity;
import android.os.Bundle;


import java.util.ArrayList;

import br.com.herbertrf.list.adapter.PessoaAdapter;
import br.com.herbertrf.list.model.Pessoa;


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
