package com.example.diegoherzer.pizzaria.model;

import java.util.ArrayList;

public class Venda {
    private int id;
    private ArrayList<ItemVenda> itens;

    public Venda() {

    }

    public Venda(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public Venda(int id, ArrayList<ItemVenda> itens) {
        this.id = id;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }
}
