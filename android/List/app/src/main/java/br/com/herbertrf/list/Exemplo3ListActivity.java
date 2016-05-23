/**
 * Exemplo retirado do livro: Google Android 3ª Edicao. Ricardo Lecheta
 */
package br.com.herbertrf.list;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class Exemplo3ListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();


        for (int i = 0; i < 10; i++) {
            HashMap<String,String> item = new HashMap<String,String>();
            item.put( "nome","Nome "+i );
            item.put( "fone","Fone "+i );
            list.add(item);
        }

        String[] from = new String[] { "nome","fone" };
        int[] to = new int[] { R.id.nome, R.id.fone};

        setListAdapter(new SimpleAdapter(this,list,R.layout.layout_contatos_fone, from,to));
    }
}
