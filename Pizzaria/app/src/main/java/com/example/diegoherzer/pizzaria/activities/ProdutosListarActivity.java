package com.example.diegoherzer.pizzaria.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.diegoherzer.pizzaria.R;
import com.example.diegoherzer.pizzaria.dao.ProdutoDAO;
import com.example.diegoherzer.pizzaria.model.Produto;

import java.util.ArrayList;

public class ProdutosListarActivity extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_listar);

        listaProdutos();
    }

    public void listaProdutos() {
        ProdutoDAO daoProduto = ProdutoDAO.newInstance(this);
        ArrayList<String> produtos = daoProduto.listarNomesProdutos();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                produtos );
        lista = (ListView)findViewById(R.id.listaProdutos);
        lista.setAdapter(arrayAdapter);
    }
}
