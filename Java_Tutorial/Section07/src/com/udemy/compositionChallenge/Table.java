package com.udemy.compositionChallenge;

public class Table {

    private int legs;
    private int width;
    private String material;

    public Table(int legs, int width, String material) {
        this.legs = legs;
        this.width = width;
        this.material = material;
    }

    public void increaseDecrease() {
        System.out.println("Let's make table bigger or smaller ");
    }

    public int getLegs() {
        return legs;
    }

    public int getWidth() {
        return width;
    }

    public String getMaterial() {
        return material;
    }
}
