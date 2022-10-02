package com.udemy.section07.composition.compositionChallenge;

public class Tv {

    private Monitor monitor;
    private String name;
    private String manufacturer;

    public Tv(Monitor monitor, String name, String manufacturer) {
        this.monitor = monitor;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public void entertineMe () {
        System.out.println("Show me funny video");
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
