package com.udemy.compositionChallenge;

public class Window {

    private Glass glass;
    private int height;
    private int width;

    public Window(Glass glass, int height, int width) {
        this.glass = glass;
        this.height = height;
        this.width = width;
    }

    public void getFreshAir() {
        System.out.println("Open window to let some fresh air");
    }


    public Glass getGlass() {
        return glass;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
