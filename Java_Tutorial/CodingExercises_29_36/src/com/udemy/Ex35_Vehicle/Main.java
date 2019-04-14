package com.udemy.Ex35_Vehicle;

public class Main {

    public static void main(String[] args) {

      Ford ford = new Ford(36, "grey", "Focus");
      ford.steer(45);
      ford.accelerate(30);
      System.out.println();
      ford.accelerate(20);
      System.out.println();
      ford.accelerate(-42);

      System.out.println("==============");

      //no good
      Peugeot peugeot = new Peugeot(24, "black", "Lion");
      peugeot.steer(60);
      peugeot.accelerate(2);
    }
}
