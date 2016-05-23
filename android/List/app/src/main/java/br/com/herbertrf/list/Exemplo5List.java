package br.com.herbertrf.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;

import br.com.herbertrf.list.adapter.PessoaAdapter;
import br.com.herbertrf.list.model.Pessoa;


public class Exemplo5List extends Activity implements AdapterView.OnItemClickListener {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo4_list);

        listView = (ListView) findViewById(R.id.listView);

        ArrayList<Pessoa> list = new ArrayList<Pessoa>();

        list.add(new Pessoa("Pedro","3590-4849",12));
        list.add(new Pessoa("Joao","3590-4849",18));

        PessoaAdapter pAdapter = new PessoaAdapter(this,list);


        listView.setAdapter(pAdapter);
        listView.setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Pessoa p = (Pessoa) listView.getAdapter().getItem(position);

        EditText ed = (EditText) findViewById(R.id.editText);
        ed.setText(p.getNome());

        Toast.makeText(this, "CLICADO: " + p.getNome(), Toast.LENGTH_SHORT).show();
    }
}
