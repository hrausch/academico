package br.com.herbertrf.simpleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Tela1Activity extends AppCompatActivity {

    //Define os objetos da tela
    EditText editTotalConta ;
    EditText editTotalPessoa ;
    EditText editTotalPPessoa ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Recupera os componentes do XML em forma de objetos
        editTotalConta = (EditText) findViewById(R.id.inputTotalConta);
        editTotalPessoa = (EditText) findViewById(R.id.inputTotalPessoa);
        editTotalPPessoa = (EditText) findViewById(R.id.inputResultado);
    }


    public void calcularConta(View v){

        //Recupera o valor presente em cada campo da tela atribuindo à variável
        String valorDigitadoConta = editTotalConta.getText().toString();
        //converte a string em double
        double totalConta = Double.parseDouble(valorDigitadoConta);


        //pega o valor digitado e converte para double
        double totalPessoa = Double.parseDouble(editTotalPessoa.getText().toString());

        //realiza o calculo por pessoa
        double resultado = totalConta/totalPessoa;

        // atribui o resultado no campo na tela
        editTotalPPessoa.setText( String.valueOf( resultado ) );

    }

    public void limparTela(View v){

        editTotalConta.setText("");
        editTotalPessoa.setText("");
        editTotalPPessoa.setText("");
    }
}
