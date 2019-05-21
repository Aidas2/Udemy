package com.udemy.section07.composition.compositionChallenge;

public class Glass {

    private int height;
    private int width;
    private String material;
    private String color;

    public Glass(int height, int width, String material, String color) {
        this.height = height;
        this.width = width;
        this.material = material;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }
}
