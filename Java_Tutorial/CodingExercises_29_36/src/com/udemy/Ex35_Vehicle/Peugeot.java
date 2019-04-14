package com.udemy.Ex35_Vehicle;

public class Peugeot extends Car {

    private int roadServiceMonths;
    private String color;
    private String brandSign;

    public Peugeot(int roadServiceMonths, String color, String brandSign) {
        super("Peugeot307", "2WD", 3, "gas", 4, 5, 4, true);
        this.roadServiceMonths = roadServiceMonths;
        this.color = color;
        this.brandSign = brandSign;
    }


    public void accelerate(int gear) {
        changeGear(gear);
        if (getCurrentGear() == 0) {
            stop();
            changeVelocity(0, getCurrentDirection());
        } else if (getCurrentGear() == 1) {
            changeVelocity(10, getCurrentDirection());
        } else if (getCurrentGear() == 2) {
            changeVelocity(20, getCurrentDirection());
        } else if (getCurrentGear() == 3) {
            changeVelocity(30, getCurrentDirection());
        } else if (getCurrentGear() == 4) {
            changeVelocity(40, getCurrentDirection());
        } else {
            changeVelocity(50, getCurrentDirection());
        }
    }

}
