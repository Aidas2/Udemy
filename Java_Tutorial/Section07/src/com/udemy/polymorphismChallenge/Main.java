package com.udemy.polymorphismChallenge;


class Car {
    private String name;
    private int cylinders;
    private int wheels;
    private boolean engine;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean isEngine() {
        return engine;
    }


    public String startEngine() {
        return "Car --> No starting sound here";
    }

    public String accelerate() {
        return "Car --> Not very fast accelerating";
    }

    public String brake() {
        return "Car --> No braking at all";
    }

}

class Ford extends Car {
    public Ford(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Ford started engine";
    }

    @Override
    public String accelerate() {
        return "Ford accelerated";
    }

    @Override
    public String brake() {
        return "Ford stopped";
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi started engine";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi accelerated";
    }

    @Override
    public String brake() {
        return "Mitsubishi stopped";
    }
}


class Holden extends Car {
    public Holden(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Holden started engine";
    }

    @Override
    public String accelerate() {
        return "Holden accelerated";
    }

    @Override
    public String brake() {
        return "Holden stopped";
    }
}



public class Main {

    public static void main(String[] args) {

        Car car = new Car("NoName", 5);
        System.out.println("Name: " + car.getName() + ", cylinders: " + car.getCylinders() + ", wheels: " + car.getWheels()+ ", engine: "  + car.isEngine());
        System.out.println(car.startEngine() + "\n" + car.accelerate() + "\n" + car.brake());

        Ford ford = new Ford("FOCUS", 4);
        System.out.println("Name: " + ford.getName() + ", cylinders: " + ford.getCylinders() + ", wheels: " + ford.getWheels()+ ", engine: "  + ford.isEngine());
        System.out.println(ford.startEngine() + "\n" + ford.accelerate() + "\n" + ford.brake());

        Mitsubishi mitsubishi = new Mitsubishi("OUTLANDER", 8);
        System.out.println("Name: " + mitsubishi.getName() + ", cylinders: " + mitsubishi.getCylinders() + ", wheels: " + mitsubishi.getWheels()+ ", engine: "  + mitsubishi.isEngine());
        System.out.println(mitsubishi.startEngine() + "\n" + mitsubishi.accelerate() + "\n" + mitsubishi.brake());

        Holden holden = new Holden("BUMPER", 7);
        System.out.println("Name: " + holden.getName() + ", cylinders: " + holden.getCylinders() + ", wheels: " + holden.getWheels()+ ", engine: "  + holden.isEngine());
        System.out.println(holden.startEngine() + "\n" + holden.accelerate() + "\n" + holden.brake());
    }
}
