package com.example.diegoherzer.pizzaria.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.diegoherzer.pizzaria.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void telaGerenciar(View view) {
        Intent intent = new Intent(getApplicationContext(), ProdutosActivity.class);
        startActivity(intent);
    }

    public void telaIniciaVenda(View view) {
        Intent intent = new Intent(getApplicationContext(), VendaIniciarActivity.class);
        startActivity(intent);
    }

}
