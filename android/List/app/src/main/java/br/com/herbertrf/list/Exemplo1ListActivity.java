/**
 * Exemplo retirado do livro: Google Android 3ª Edicao. Ricardo Lecheta
 */
package br.com.herbertrf.list;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class Exemplo1ListActivity extends ListActivity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // Array de Strings para visualizar na Lista
        String[] itens = new String[] { "Nome 1", "Nome 2", "Nome 3" };

        // Utiliza o adaptador ArrayAdapter, para exibir o array de Strings na tela.
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itens);

        setListAdapter(adaptador);
    }

}


