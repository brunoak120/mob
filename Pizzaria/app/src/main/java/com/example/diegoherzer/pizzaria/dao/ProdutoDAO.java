package com.example.diegoherzer.pizzaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.diegoherzer.pizzaria.model.Produto;

import java.util.ArrayList;

public class ProdutoDAO {
    private static SQLiteDatabase mDatabase;
    DBHelper mHelper;
    private static final String DB_TAG = "database";
    private Context mContext;

    private static ProdutoDAO daoInstance;

    public static ProdutoDAO newInstance(Context context) {
        if (daoInstance == null) {
            daoInstance = new ProdutoDAO(context.getApplicationContext());
        }

        return daoInstance;
    }

    private ProdutoDAO(Context context) {
        this.mContext = context;
        mHelper = DBHelper.newInstance(context);
        mDatabase = mHelper.getWritableDatabase();
    }

    public static final String[] PROJECTION_PRODUTO = {
            DataContract.ProdutoContract.PRODUTO_COLUNA_ID,
            DataContract.ProdutoContract.PRODUTO_COLUNA_NOME,
            DataContract.ProdutoContract.PRODUTO_COLUNA_TIPO,
            DataContract.ProdutoContract.PRODUTO_COLUNA_DESCRICAO,
            DataContract.ProdutoContract.PRODUTO_COLUNA_PRECO
    };

    public int inserir(Produto produto) {

        ContentValues values = new ContentValues();
        int returnedId = -1;

        values.put(DataContract.ProdutoContract.PRODUTO_COLUNA_NOME, produto.getNome());
        values.put(DataContract.ProdutoContract.PRODUTO_COLUNA_TIPO, produto.getTipo());
        values.put(DataContract.ProdutoContract.PRODUTO_COLUNA_DESCRICAO, produto.getDescricao());
        values.put(DataContract.ProdutoContract.PRODUTO_COLUNA_PRECO, produto.getPreco());

        returnedId = (int) mDatabase.insert(DataContract.ProdutoContract.NOME_TABELA_PRODUTO, null, values);
        produto.setId(returnedId);
        return returnedId;
    }

    public ArrayList<Produto> listarProdutos() {

        ArrayList<Produto> produtos = new ArrayList<>();

        Cursor cursor = mDatabase.query(DataContract.ProdutoContract.NOME_TABELA_PRODUTO, PROJECTION_PRODUTO, null, null, null, null, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Produto produto = ProdutoDAO.produtoFromCursor(cursor);
                    produtos.add(produto);
                } while (cursor.moveToNext());
            }

            return produtos;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }

    public ArrayList<String> listarNomesProdutos() {

        ArrayList<String> produtos = new ArrayList<>();

        Cursor cursor = mDatabase.query(DataContract.ProdutoContract.NOME_TABELA_PRODUTO, PROJECTION_PRODUTO, null, null, null, null, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Produto produto = ProdutoDAO.produtoFromCursor(cursor);
                    produtos.add(produto.getNome());
                } while (cursor.moveToNext());
            }

            return produtos;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }

    private static Produto produtoFromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(DataContract.ProdutoContract.PRODUTO_COLUNA_ID));
        String nome = cursor.getString(cursor.getColumnIndex(DataContract.ProdutoContract.PRODUTO_COLUNA_NOME));
        String tipo = cursor.getString(cursor.getColumnIndex(DataContract.ProdutoContract.PRODUTO_COLUNA_TIPO));
        String descricao = cursor.getString(cursor.getColumnIndex(DataContract.ProdutoContract.PRODUTO_COLUNA_DESCRICAO));
        Double preco = cursor.getDouble(cursor.getColumnIndex(DataContract.ProdutoContract.PRODUTO_COLUNA_PRECO));

        return new Produto(id, nome, tipo, descricao, preco);
    }
}
