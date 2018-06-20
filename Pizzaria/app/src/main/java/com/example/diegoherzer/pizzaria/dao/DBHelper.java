package com.example.diegoherzer.pizzaria.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "app_banco";
    private static final int DB_VERSION = 1;
    private static final String SEPARADOR = ", ";
    private static final String TAG = "db_tag";
    private Context mContext;

    private static final String SQL_DROP_TABLE_PRODUTO = "DROP TABLE IF EXISTS " + DataContract.ProdutoContract.NOME_TABELA_PRODUTO;
    private static final String SQL_DROP_TABLE_VENDA = "DROP TABLE IF EXISTS " + DataContract.VendaContract.NOME_TABELA_VENDA;
    private static final String SQL_DROP_TABLE_ITEM_VENDA = "DROP TABLE IF EXISTS " + DataContract.ItemVendaContract.NOME_TABELA_ITEM_VENDA;

    private static final String SQL_CREATE_TABLE_PRODUTO = "CREATE TABLE " + DataContract.ProdutoContract.NOME_TABELA_PRODUTO + "(" +
            DataContract.ProdutoContract.PRODUTO_COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + SEPARADOR +
            DataContract.ProdutoContract.PRODUTO_COLUNA_NOME + " TEXT NOT NULL" + SEPARADOR +
            DataContract.ProdutoContract.PRODUTO_COLUNA_TIPO + " TEXT NOT NULL" + SEPARADOR +
            DataContract.ProdutoContract.PRODUTO_COLUNA_DESCRICAO + " TEXT NOT NULL " + SEPARADOR +
            DataContract.ProdutoContract.PRODUTO_COLUNA_PRECO + " DECIMAL NOT NULL );";

    private static final String SQL_CREATE_TABLE_VENDA = "CREATE TABLE " + DataContract.VendaContract.NOME_TABELA_VENDA + "(" +
            DataContract.VendaContract.VENDA_COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + SEPARADOR +
            DataContract.VendaContract.VENDA_COLUNA_NOME + " TEXT NOT NULL" + SEPARADOR +
            DataContract.VendaContract.VENDA_COLUNA_PRECO + " DECIMAL NOT NULL );";

    private static final String SQL_CREATE_TABLE_ITEM_VENDA = "CREATE TABLE " + DataContract.ItemVendaContract.NOME_TABELA_ITEM_VENDA + "(" +
            DataContract.ItemVendaContract.ITEM_VENDA_COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + SEPARADOR +
            DataContract.ItemVendaContract.ITEM_VENDA_COLUNA_VENDA_CHAVE + " INTEGER NOT NULL" + SEPARADOR +
            DataContract.ItemVendaContract.ITEM_VENDA_COLUNA_PRODUTO_CHAVE + " INTEGER NOT NULL " + SEPARADOR +

            "FOREIGN KEY (" + DataContract.ItemVendaContract.ITEM_VENDA_COLUNA_VENDA_CHAVE + ") REFERENCES " +
            DataContract.VendaContract.NOME_TABELA_VENDA + " (" + DataContract.VendaContract.VENDA_COLUNA_ID +
            ")" + SEPARADOR +

            "FOREIGN KEY (" + DataContract.ItemVendaContract.ITEM_VENDA_COLUNA_PRODUTO_CHAVE + ") REFERENCES " +
            DataContract.ProdutoContract.NOME_TABELA_PRODUTO + " (" + DataContract.ProdutoContract.PRODUTO_COLUNA_ID + "));";

    private static DBHelper instance;

    public static DBHelper newInstance(Context context) {

        if (instance == null) {
            instance = new DBHelper(context, DB_NAME, null, DB_VERSION);
        }

        return instance;
    }

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_PRODUTO);
        db.execSQL(SQL_CREATE_TABLE_VENDA);
        db.execSQL(SQL_CREATE_TABLE_ITEM_VENDA);

        Log.i(TAG, "DB Created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_PRODUTO);
        db.execSQL(SQL_DROP_TABLE_VENDA);
        db.execSQL(SQL_DROP_TABLE_ITEM_VENDA);

        Log.i(TAG, "DB Dropped!");

        onCreate(db);
    }
}
