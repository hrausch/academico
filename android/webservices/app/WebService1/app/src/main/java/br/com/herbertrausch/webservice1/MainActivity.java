package br.com.herbertrausch.webservice1;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.herbertrausch.webservice1.adapter.PessoaAdapter;
import br.com.herbertrausch.webservice1.model.Pessoa;
import br.com.herbertrausch.webservice1.ws.RestFullClient;


public class MainActivity extends Activity {

    //Cria o adaptador para a lista
    PessoaAdapter pAdapter = new PessoaAdapter(this,new ArrayList<Pessoa>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_exemplo);
    }

    /**
     * Ao clicar no botao recuperar serah executado a chamada ao webservice em um nova thread.
     * @param v
     */
    public void recuperar(View v){

        //Objeto que sera executado em backgrounnd
        AsyncTask taskWsRecuperar = new ConnectionPessoa();
        taskWsRecuperar.execute(RestFullClient.OPERACAO_RECUPERAR);

    }

    /**
     * Ao clicar no botao recuperar serah executado a chamada ao webservice em um nova thread.
     * @param v
     */
    public void salvar(View v){

        //Objeto que sera executado em backgrounnd
        AsyncTask taskWsSalvar = new ConnectionPessoa();
        taskWsSalvar.execute(RestFullClient.OPERACAO_SALVAR);
    }


    /***
     * Implementacao da classe que ira roda em umma Thread separa da Thread da Interface
     */
    class ConnectionPessoa extends AsyncTask<Object, Void,  ArrayList<Pessoa>> {


        private RestFullClient cliente = new RestFullClient();
        @Override
        /** Este metodo eh executado por um Thread que eh controlado pela classe
         *  Quando esta Thread finaliza a execucao, automaticamente o metodo
         *  onPostExecute eh executado
         */
        protected  ArrayList<Pessoa> doInBackground(Object ... args) {

            int operacao = (int) args[0];
            ArrayList<Pessoa> list = new ArrayList<Pessoa>();

            switch (operacao){

                case RestFullClient.OPERACAO_SALVAR:

                    EditText inputNome = (EditText) findViewById(R.id.txtNome);
                    EditText inputTelefone = (EditText) findViewById(R.id.txtTelefone);

                    String nome = inputNome.getText().toString();
                    String telefone = inputTelefone.getText().toString();

                    cliente.salvarPessoa(nome, telefone);

                    list = cliente.recuperarPessoas();

                    break;

                case RestFullClient.OPERACAO_RECUPERAR:
                    list = cliente.recuperarPessoas();
                    break;
            }


            return list;

        }

        /** Este metodo eh automaticamente executado quando doInBackground() finalizar
         * Neste momento ele irah renderizar o listview com os dados recuperados no webservice
        */
        protected void onPostExecute(ArrayList<Pessoa> result) {

            ListView listView = (ListView) findViewById(R.id.listView);
            pAdapter.setLista(result);
            listView.setAdapter(pAdapter);

        }
    }
}


