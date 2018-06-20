package com.example.diegoherzer.pizzaria.dao;

import android.provider.BaseColumns;

public class DataContract {
    public class ProdutoContract implements BaseColumns {
        public static final String NOME_TABELA_PRODUTO = "produto";

        public static final String PRODUTO_COLUNA_ID = "_id";

        public static final String PRODUTO_COLUNA_NOME = "produto_nome";

        public static final String PRODUTO_COLUNA_TIPO = "produto_tipo";

        public static final String PRODUTO_COLUNA_DESCRICAO = "produto_descricao";

        public static final String PRODUTO_COLUNA_PRECO = "produto_preco";
    }

    public class VendaContract implements BaseColumns {
        public static final String NOME_TABELA_VENDA = "venda";

        public static final String VENDA_COLUNA_ID = "_id";

        public static final String VENDA_COLUNA_NOME = "venda_nome";

        public static final String VENDA_COLUNA_PRECO = "venda_preco";
    }

    public class ItemVendaContract implements BaseColumns {
        public static final String NOME_TABELA_ITEM_VENDA = "item_venda";

        public static final String ITEM_VENDA_COLUNA_ID = "_id";

        public static final String ITEM_VENDA_COLUNA_VENDA_CHAVE = "item_venda_venda_chave";

        public static final String ITEM_VENDA_COLUNA_PRODUTO_CHAVE = "item_venda_produto_chave";
    }
}
