package com.udemy.section06.excercises_29_36.Ex35_Vehicle;

public class Ford extends Car{

    private int roadServiceMonths;
    private String color;
    private String brandSign;

    public Ford(int roadServiceMonths, String color, String brandSign) {
        super("Ford", "2WD", 2, "gasoline", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
        this.color = color;
        this.brandSign = brandSign;
    }


    public void accelerate (int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if(newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10 ){
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20 ){
            changeGear(2);
        } else if (newVelocity > 20 && newVelocity <= 30 ){
            changeGear(3);
        } else {
            changeGear(4);
        }

        if(newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }



    }
}
