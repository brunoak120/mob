package com.example.diegoherzer.pizzaria.model;

public class Bebida {
    private String nome;
    private Double preco;

    public Bebida() {

    }

    public Bebida(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
