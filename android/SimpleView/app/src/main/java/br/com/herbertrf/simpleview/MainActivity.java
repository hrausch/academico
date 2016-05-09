package br.com.herbertrf.simpleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTela1(View v){

        //Abre a tela Tela1Activity
        Intent it = new Intent(this, Tela1Activity.class);
        startActivity(it);

    }

    public void abrirTela2(View v){

        //Abre a tela Tela1Activity
        Intent it = new Intent(this, Tela2Activity.class);
        startActivity(it);
    }
}
