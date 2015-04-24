package com.example.hrausch.exemplolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hrausch.exemplolist.adapter.PessoaAdapter;
import com.example.hrausch.exemplolist.model.Pessoa;

import java.util.ArrayList;


public class Exemplo5List extends Activity implements AdapterView.OnItemClickListener {

    ListView listView = (ListView) findViewById(R.id.listView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo4_list);

        ArrayList<Pessoa> list = new ArrayList<Pessoa>();

        list.add(new Pessoa("Pedro","3590-4849",12));
        list.add(new Pessoa("Joao","3590-4849",18));

        PessoaAdapter pAdapter = new PessoaAdapter(this,list);


        listView.setAdapter(pAdapter);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Pessoa p = (Pessoa) listView.getAdapter().getItem(position);

        Toast.makeText(this, "Pessoa selecionada: " + p.getNome(),Toast.LENGTH_SHORT).show();
    }
}
