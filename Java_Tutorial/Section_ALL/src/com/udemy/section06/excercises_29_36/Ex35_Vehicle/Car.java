package com.udemy.section06.excercises_29_36.Ex35_Vehicle;

public class Car extends Vehicle {

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String name, String size, int weight, String fuel, int wheels, int doors, int gears, boolean isManual) {
        super(name, size, weight, fuel);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): Changed to " + this.currentGear + " gear");
    }

    public void changeVelocity(int speed, int direction) {
        System.out.println("Car.changeVelocity(): Velocity " + speed + " direcion " + direction);
        move(speed, direction);
    }
//    Why not this ?
//    @Override
//    public void move(int velocity, int direction) {
//        super.move(velocity, direction);
//    }


//    not necessary (?), because there is no unique actions (?)
//    @Override
//    public void stop() {
//        super.stop();
//    }


    public int getCurrentGear() {
        return currentGear;
    }
}
