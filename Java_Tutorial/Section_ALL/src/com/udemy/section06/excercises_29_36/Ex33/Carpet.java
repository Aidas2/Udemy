package com.udemy.section06.excercises_29_36.Ex33;

public class Carpet {

    private double cost;

    public Carpet(double cost) {
        if(cost < 0) {
            this.cost = 0;
        } else {
            this.cost = cost;
        }
    }

    public double getCost () {
        return this.cost;
    }
}