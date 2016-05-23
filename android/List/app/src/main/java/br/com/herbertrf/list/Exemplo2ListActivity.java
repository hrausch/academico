/**
 * Exemplo retirado do livro: Google Android 3ª Edicao. Ricardo Lecheta
 */
package br.com.herbertrf.list;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.HashMap;


public class Exemplo2ListActivity extends ListActivity {

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

        // Array que define as chaves do HashMap
        String[] from = new String[] { "nome","fone" };

        // text1 e text2 são padrões do android para o layout nativo "two_line_list_item"
        int[] to = new int[] { android.R.id.text1, android.R.id.text2 };
        int layoytNativo = android.R.layout.two_line_list_item;

        setListAdapter(new SimpleAdapter(this,list,layoytNativo, from,to));
    }
}
