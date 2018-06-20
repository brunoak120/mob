package com.example.diegoherzer.pizzaria.model;

import java.util.ArrayList;

public class ItemVenda {
    private Pizza pizza;
    private Bebida bebida;

    public ItemVenda() {

    }

    public ItemVenda (Pizza pizzas, Bebida bebidas) {
        this.pizza = pizzas;
        this.bebida = bebidas;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}
