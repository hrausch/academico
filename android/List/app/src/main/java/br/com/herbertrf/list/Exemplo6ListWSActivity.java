package br.com.herbertrf.list;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.herbertrf.list.adapter.EnderecoAdapter;
import br.com.herbertrf.list.adapter.PessoaAdapter;
import br.com.herbertrf.list.model.Endereco;
import br.com.herbertrf.list.model.Pessoa;
import br.com.herbertrf.list.restclient.RestFulClient;

public class Exemplo6ListWSActivity extends AppCompatActivity {

    ListView listView;
    EnderecoAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo4_list);

        listView = (ListView) findViewById(R.id.listView);

        ArrayList<Endereco> list = new ArrayList<Endereco>();

        eAdapter = new EnderecoAdapter(this,list);
        listView.setAdapter(eAdapter);


    }


    public void buscarWs(View v){
        carregarListaEnderecos();
    }

    public void carregarListaEnderecos(){
        //Objeto que sera executado em backgrounnd
        AsyncTask taskWsRecuperar = new ConnectionEndereco();
        taskWsRecuperar.execute();
    }




    /***
     * Implementacao da classe que ira roda em umma Thread separa da Thread da Interface
     */
    class ConnectionEndereco extends AsyncTask<Object, Void,  ArrayList<Endereco>> {


        private RestFulClient cliente = new RestFulClient();


        /** Este metodo eh executado por um Thread que eh controlado pela classe
         *  Quando esta Thread finaliza a execucao, automaticamente o metodo
         *  onPostExecute eh executado
         */
        @Override
        protected  ArrayList<Endereco> doInBackground(Object ... args) {

//            int operacao = (int) args[0];
            ArrayList<Endereco> list = new ArrayList<Endereco>();

            String jsonEnderecos = cliente.recuperarEnderecos();
            list = Endereco.fromArrayJson(jsonEnderecos);

            return list;

        }

        /** Este metodo eh automaticamente executado quando doInBackground() finalizar
         * Neste momento ele irah renderizar o listview com os dados recuperados no webservice
         */
        protected void onPostExecute(ArrayList<Endereco> result) {

            ListView listView = (ListView) findViewById(R.id.listView);
            eAdapter.setLista(result);
            listView.setAdapter(eAdapter);

        }
    }

}
