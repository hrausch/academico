package br.com.herbertrf.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.herbertrf.list.R;
import br.com.herbertrf.list.model.Pessoa;

import java.util.List;

/**
 * Created by hrausch on 30/11/14.
 */
public class PessoaAdapter extends BaseAdapter{
    private Context context;
    private List<Pessoa> lista;

    public PessoaAdapter(Context context, List<Pessoa> lista) {
        this.context = context;
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
        TextView textNome = (TextView) v.findViewById(R.id.txtNome);
        textNome.setText(obj.getNome());

        TextView textTelefone = (TextView) v.findViewById(R.id.txtTelefone);
        textTelefone.setText(obj.getTelefone());

        TextView textIdade = (TextView) v.findViewById(R.id.txtIdade);
        textIdade.setText(String.valueOf(obj.getIdade()));

        return v;
    }


}
