package br.com.herbertrf.simpleview;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Tela2Activity extends AppCompatActivity {

    private String[] tiposDeVinho = new String[]{"Branco", "Tinto", "Rosé"};
    Spinner comboTipoVinho;
    EditText inputNomeVinho, inputNotaVinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        inputNomeVinho = (EditText) findViewById(R.id.inputNomeVinho);
        inputNotaVinho = (EditText) findViewById(R.id.inputNotaVinho);

        comboTipoVinho = (Spinner) findViewById(R.id.dropTipoVinho);

        preencherDropDowTipoVinho();
    }

    /**
     * Método que preenche o combobox com uma lista de elementos
     * Para isso é necessário o uso do adapter
     */

    private void preencherDropDowTipoVinho(){

        ArrayAdapter adaptador =
new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiposDeVinho);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);

        comboTipoVinho.setAdapter(adaptador);
    }


    public void salvar(View v){

        //recupera os valores digitados
        String nomeVinho = inputNomeVinho.getText().toString();
        String notaVinho = inputNotaVinho.getText().toString();

        //recupera o elemento selecionado
        String tipoVinho = comboTipoVinho.getSelectedItem().toString();

        //exibe alerta para o usuário
        Toast toast = Toast.makeText(this, "Botão Salvar preesionado", Toast.LENGTH_LONG);
        toast.show();


        //Cria um arquivo.txt na pasta downloads
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "arquivo.txt");

        FileOutputStream outputStream;

        try {
            //cria um outputstream no arquivo no modo append
            outputStream = new FileOutputStream(file,true);
            //salva a string
            outputStream.write(nomeVinho.getBytes());
            //fecha o recurso
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cancelar(View v){

        //Criando um alerta de confirmação
        AlertDialog.Builder alerta = new AlertDialog.Builder(Tela2Activity.this);
        alerta.setTitle("Confirme sua operação");

        alerta.setMessage("Selecione se deseja prosseguir com a operação");

        alerta.setPositiveButton("Prosseguir" , new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int button){

                inputNotaVinho.setText("");
                inputNomeVinho.setText("");

                Toast toast = Toast.makeText(Tela2Activity.this, "Todos os dados foram apagados", Toast.LENGTH_LONG);
                toast.show();


            }
        });

        alerta.setNegativeButton("Não Prosseguir", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int button){


                Toast toast = Toast.makeText(Tela2Activity.this, "Dados não foram apagados", Toast.LENGTH_LONG);
                toast.show();


            }

        });

        alerta.show();

    }
}
