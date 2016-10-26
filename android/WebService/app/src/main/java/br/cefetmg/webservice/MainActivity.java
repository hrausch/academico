package br.cefetmg.webservice;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.cefetmg.webservice.adapter.EnderecoAdapter;
import br.cefetmg.webservice.model.Endereco;
import br.cefetmg.webservice.restclient.RestFulClient;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EnderecoAdapter eAdapter;

    EditText editRua, editCidade, editEstado;
    Endereco objEndereco;
    Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo4_list);

        btnSalvar = (Button) findViewById(R.id.button);

        listView = (ListView) findViewById(R.id.listView);

        ArrayList<Endereco> list = new ArrayList<Endereco>();

        eAdapter = new EnderecoAdapter(this,list);
        listView.setAdapter(eAdapter);
    }


    public void salvarEBuscarEndereco(View v){

        btnSalvar.setEnabled(false);

        objEndereco = new Endereco();

        editRua = (EditText) findViewById(R.id.editRua);
        editCidade = (EditText) findViewById(R.id.editCidade);
        editEstado = (EditText) findViewById(R.id.editUF);



        objEndereco.setRua(editRua.getText().toString());
        objEndereco.setCidade(editCidade.getText().toString());
        objEndereco.setEstado(editEstado.getText().toString());

        AsyncTask taskWs = new ConnectionEndereco();
        taskWs.execute();

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


            //salva e em seguida lista os dados registrados
            ArrayList<Endereco> list = new ArrayList<Endereco>();

            cliente.salvarEndereco(objEndereco);
            String jsonEnderecos = cliente.recuperarEnderecos();

            list = Endereco.fromArrayJson(jsonEnderecos);

            return list;

        }

        /** Este metodo eh automaticamente executado quando doInBackground() finalizar
         * Neste momento ele irah renderizar o listview com os dados recuperados no webservice
         */
        protected void onPostExecute(ArrayList<Endereco> result) {
<<<<<<< HEAD

=======
            Context context = getApplicationContext();
            CharSequence text = "Registro salvo com sucesso!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            btnSalvar.setEnabled(true);

            eAdapter.setLista(result);
            listView.setAdapter(eAdapter);

>>>>>>> c77745dd9da69d22e557391c68a91292cd0424b9

        }
    }
}
