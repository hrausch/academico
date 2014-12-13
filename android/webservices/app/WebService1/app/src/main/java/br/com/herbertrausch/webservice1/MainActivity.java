package br.com.herbertrausch.webservice1;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import br.com.herbertrausch.webservice1.R;
import ws.RestFullClient;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_exemplo);

         AsyncTask taskWs = new Connection();
        taskWs.execute();
    }



    public void recuperar(View v){
        Log.i("WS", "pressionado");
    }

    class Connection extends AsyncTask<Object, Void, String> {
        @Override
        protected String doInBackground(Object ... args0) {

            String content = "";
            RestFullClient cliente = new RestFullClient();
            content = cliente.testeGet();

            return content;

        }

        // This is called when doInBackground() is finished
        protected void onPostExecute(String result) {
            EditText input1 = (EditText) findViewById(R.id.editText);
            input1.setText(result);

        }
    }
}


