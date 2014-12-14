package herbertrausch.simpleintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Tela1Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
    }



    public void enviarTela2(View v){

        EditText inputNome = (EditText) findViewById(R.id.editText);
        String nome = inputNome.getText().toString();

        //Instancia uma "intencao" de ir para a Tela2Activity
        Intent it = new Intent(this, Tela2Activity.class);

        /**
         * Passagem de parametros para outra activity eh opcional.
         * Eh realizado só quando for necessario
          */
        Bundle parametros = new Bundle();
        parametros.putString("nome_digitado", nome);
        it.putExtras(parametros);

        // Inicia a tela
        startActivity(it);

    }
}
