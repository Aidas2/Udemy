package com.udemy.section07.composition.compositionChallenge;

public class Monitor {

    private String manufacturer;
    private int size;

    public Monitor(String manufacturer, int size) {
        this.manufacturer = manufacturer;
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }
}
