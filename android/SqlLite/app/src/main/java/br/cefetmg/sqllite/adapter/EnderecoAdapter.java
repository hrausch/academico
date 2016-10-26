package br.cefetmg.sqllite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.cefetmg.sqllite.R;
import br.cefetmg.sqllite.model.Endereco;


/**
 * Created by hrausch on 30/11/14.
 */
public class EnderecoAdapter extends BaseAdapter{
    private Context context;
    private List<Endereco> lista;

    public EnderecoAdapter(Context context, List<Endereco> lista) {
        this.context = context;
        this.lista = lista;
    }

    public void setLista( List<Endereco> e){
        this.lista = e;
    }

    public int getCount() {
        return lista.size();
    }
    public Object getItem(int posicao) {
        Endereco obj = lista.get(posicao);
        return obj;
    }
    public long getItemId(int posicao) {
        return posicao;
    }
    public View getView(int posicao, View convertView, ViewGroup parent) {

        Endereco obj = lista.get(posicao);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.layout_agenda_pessoa, null);

        // Atualiza o valor do Text
        TextView textNome = (TextView) v.findViewById(R.id.txtNome);
        textNome.setText(obj.getRua());

        TextView textTelefone = (TextView) v.findViewById(R.id.txtTelefone);
        textTelefone.setText(obj.getCidade());

        TextView textIdade = (TextView) v.findViewById(R.id.txtIdade);
        textIdade.setText(String.valueOf(obj.getEstado()));

        return v;
    }


}
