package com.example.diegoherzer.pizzaria.model;

import java.util.ArrayList;

public class Venda {
    private ArrayList<Pizza> pizzas;
    private ArrayList<Bebida> bebidas;

    public Venda() {

    }

    public Venda (ArrayList<Pizza> pizzas, ArrayList<Bebida> bebidas) {
        this.pizzas = pizzas;
        this.bebidas = bebidas;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }
}
