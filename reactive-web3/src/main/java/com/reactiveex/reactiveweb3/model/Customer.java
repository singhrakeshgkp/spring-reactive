package com.reactiveex.reactiveweb3.model;

public class Customer {
    public Customer(){

    }
    public Customer(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
