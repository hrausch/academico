package herbertrausch.simpleintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Tela2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView valorRecebido = (TextView) findViewById(R.id.textView);

        /**
         * Recupera o parametro enviado da Tela1
         */
        Intent it2 = getIntent();

        if(it2 != null){
            Bundle parametros2 = it2.getExtras();
            if(parametros2 != null){
                String nome = parametros2.getString("nome_digitado");
                valorRecebido.setText(nome);

            }
        }
    }



}
