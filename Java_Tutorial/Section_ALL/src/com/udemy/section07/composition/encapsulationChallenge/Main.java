package com.udemy.section07.composition.encapsulationChallenge;

public class Main {

    public static void main(String[] args) {

        Printer printer1 = new Printer(100, 10, false);
        Printer printer2 = new Printer (100, 10, true);

        System.out.println("Initial page count: " + printer1.getNumbersOfPagePrinted());
        System.out.println("Initial page count: " + printer2.getNumbersOfPagePrinted());

        System.out.println("Printer1 if filled up to " + printer1.fillUpTheToner(15) + " percent");
        System.out.println("Printer1 printed " + printer1.printPage(61) + " single pages.");

        System.out.println("Printer2 if filled up to " + printer2.fillUpTheToner(15) + " percent");
        System.out.println("Printer2 printed " + printer2.printPage(61) + " duplex pages.");

        System.out.println("Printer2 printed " + printer2.printPage(100) + " duplex pages.");


    }
}
