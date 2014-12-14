package br.com.herbertrausch.webservice1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.herbertrausch.webservice1.R;
import br.com.herbertrausch.webservice1.model.Pessoa;


/**
 * Created by hrausch on 30/11/14.
 */
public class PessoaAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Pessoa> lista;

    public PessoaAdapter(Context context, ArrayList<Pessoa> lista) {
        this.context = context;
        this.lista = lista;
    }

    public void setLista(ArrayList<Pessoa> lista) {
        this.lista = lista;
    }

    public int getCount() {
        return lista.size();
    }
    public Object getItem(int posicao) {
        Pessoa obj = lista.get(posicao);
        return obj;
    }
    public long getItemId(int posicao) {
        return posicao;
    }
    public View getView(int posicao, View convertView, ViewGroup parent) {

        Pessoa obj = lista.get(posicao);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.layout_agenda_pessoa, null);

        // Atualiza o valor do Text
        TextView textNome = (TextView) v.findViewById(R.id.lblNome);
        textNome.setText(obj.getNome());

        TextView textTelefone = (TextView) v.findViewById(R.id.lblTelefone);
        textTelefone.setText(obj.getTelefone());

        TextView textIdade = (TextView) v.findViewById(R.id.lblIdade);
        textIdade.setText(String.valueOf(obj.getIdade()));

        return v;
    }


}
