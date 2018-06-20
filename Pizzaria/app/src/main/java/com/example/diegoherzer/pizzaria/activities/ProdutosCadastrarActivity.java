package com.example.diegoherzer.pizzaria.activities;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.diegoherzer.pizzaria.R;
import com.example.diegoherzer.pizzaria.dao.ProdutoDAO;
import com.example.diegoherzer.pizzaria.model.Produto;

public class ProdutosCadastrarActivity extends AppCompatActivity {
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_cadastrar);
    }

    public void salvarProduto(View view) {
        int id = -1;
        EditText nomeProduto = (EditText) findViewById(R.id.nomeProduto);
        Spinner tipoProduto = (Spinner) findViewById((R.id.tipoProduto));
        EditText descricaoProduto = (EditText) findViewById(R.id.descricaoProduto);
        EditText precoProduto = (EditText) findViewById(R.id.valorProduto);

        String nome = nomeProduto.getText().toString();
        String tipo = tipoProduto.getSelectedItem().toString();
        String descricao = descricaoProduto.getText().toString();
        Double preco = Double.parseDouble(precoProduto.getText().toString());

        Produto produto = new Produto(nome, tipo, descricao, preco);
        ProdutoDAO daoProduto = ProdutoDAO.newInstance(this);
        id = daoProduto.inserir(produto);

        if (id != -1) {
            mensagem("Sucesso", "Produto " + nome + " inserido com sucesso!");
            nomeProduto.setText("");
            descricaoProduto.setText("");
            precoProduto.setText("");
        }
    }

    private void mensagem(String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        alerta = builder.create();
        alerta.show();
    }
}
