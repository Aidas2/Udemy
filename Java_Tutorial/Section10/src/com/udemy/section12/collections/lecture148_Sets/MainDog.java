package com.udemy.section12.collections.lecture148_Sets;

public class MainDog {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));   //true
        System.out.println(rover.equals(rover2));   //false

    }
}
