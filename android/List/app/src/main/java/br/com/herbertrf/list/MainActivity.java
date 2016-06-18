package br.com.herbertrf.list;

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

    public void abrirExemplo1(View v){
        Intent i = new Intent(this, Exemplo1ListActivity.class);
        startActivity(i);
    }

    public void abrirExemplo2(View v){
        Intent i = new Intent(this, Exemplo2ListActivity.class);
        startActivity(i);
    }

    public void abrirExemplo3(View v){
        Intent i = new Intent(this, Exemplo3ListActivity.class);
        startActivity(i);
    }

    public void abrirExemplo4_1(View v){
        Intent i = new Intent(this, Exemplo4ListActivity.class);
        startActivity(i);
    }

    public void abrirExemplo4_2(View v){
        Intent i = new Intent(this, Exemplo4List.class);
        startActivity(i);
    }

    public void abrirExemplo5(View v){
        Intent i = new Intent(this, Exemplo5List.class);
        startActivity(i);
    }

    public void abrirExemplo6(View v){
        Intent i = new Intent(this, Exemplo6ListWSActivity.class);
        startActivity(i);
    }
}
