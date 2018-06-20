package com.example.diegoherzer.pizzaria.model;

import java.util.ArrayList;

public class Venda {
    private ArrayList<ItemVenda> itens;

    public Venda() {

    }

    public Venda(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }
}
