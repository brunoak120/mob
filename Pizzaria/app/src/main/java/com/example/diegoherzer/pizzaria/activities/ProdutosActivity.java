package com.example.diegoherzer.pizzaria.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diegoherzer.pizzaria.R;

public class ProdutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
    }

    public void telaCadastrar(View view) {
        Intent intent = new Intent(getApplicationContext(), ProdutosCadastrarActivity.class);
        startActivity(intent);
    }

    public void telaModificar(View view) {
        Intent intent = new Intent(getApplicationContext(), ProdutosModificarActivity.class);
        startActivity(intent);
    }

    public void telaListar(View view) {
        Intent intent = new Intent(getApplicationContext(), ProdutosListarActivity.class);
        startActivity(intent);
    }

    public void telaExcluir(View view) {
        Intent intent = new Intent(getApplicationContext(), ProdutosExcluirActivity.class);
        startActivity(intent);
    }

    public void voltarTela(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}

