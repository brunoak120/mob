package com.example.diegoherzer.pizzaria.model;

public class ItemVenda {
    private Produto produto;

    public ItemVenda() {

    }

    public ItemVenda (Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
