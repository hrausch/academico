package br.cefetmg.sqllite;


import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.cefetmg.sqllite.adapter.EnderecoAdapter;
import br.cefetmg.sqllite.database.DatabaseConector;
import br.cefetmg.sqllite.model.Endereco;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editRua, editCidade, editEstado;
    Button btnSalvar;

    ArrayList<Endereco> list;
    EnderecoAdapter eAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo4_list);

        btnSalvar = (Button) findViewById(R.id.button);

        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<Endereco>();

    }


    public void salvarEBuscarEndereco(View v){


        editRua = (EditText) findViewById(R.id.editRua);
        editCidade = (EditText) findViewById(R.id.editCidade);
        editEstado = (EditText) findViewById(R.id.editUF);


        DatabaseConector dbCon = new DatabaseConector(MainActivity.this);

        dbCon.open();
        dbCon.insertEndereco(editRua.getText().toString(), editEstado.getText().toString(), editCidade.getText().toString() );

        preencherArrayCursor( dbCon.getAllEnderecos(), list);

        eAdapter = new EnderecoAdapter(this,list);
        listView.setAdapter(eAdapter);

        dbCon.close();


    }

    public void preencherArrayCursor(Cursor cursor, ArrayList<Endereco> lista){

        try {

            //Realiza um loop por todos os registros e os adiciona no arraylist
            while (cursor.moveToNext()) {
                Endereco obj = new Endereco();

                int indexRua = cursor.getColumnIndex("rua");
                int indexEstado = cursor.getColumnIndex("estado");
                int indexCidade = cursor.getColumnIndex("cidade");

                obj.setEstado(cursor.getString(indexEstado));
                obj.setCidade(cursor.getString(indexCidade));
                obj.setRua(cursor.getString(indexRua));

                lista.add(obj);

            }
        } finally {
            cursor.close();
        }
    }




}
