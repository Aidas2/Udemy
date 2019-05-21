package com.udemy.section04.excercises_01_07;

public class Main {

    public static void main(String[] args) {

        System.out.println("============================================================");
        long miles = Ex1_SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + miles);

        Ex1_SpeedConverter.printConversion(10.5);


        System.out.println("============================================================");
        Ex2_MegaBytesConverter.printMegaBytesAndKiloBytes(5000);


        System.out.println("============================================================");
        boolean doINeedToWakeUp = Ex3_BarkingDog.shouldWakeUp(true, 4);
        System.out.println("Do I need wakeup:" + doINeedToWakeUp);


        System.out.println("============================================================");
        boolean leapOrNot = Ex4_LeapYear.isLeapYear(2000);
        System.out.println("Leap or not: " + leapOrNot);


        System.out.println("============================================================");
        Ex5_DecimalComparator_v02.areEqualByThreeDecimalPlaces(3.1756, 4.175);


        System.out.println("============================================================");
        boolean equalOrNot = Ex6_EqualSumChecker.hasEqualSum(1, 1, 1);
        System.out.println("Equal or not: " + equalOrNot);


        System.out.println("============================================================");
        boolean teenOrNot = Ex7_TeenNumberChecker.hasTeen(1, 15, 1);
        boolean teenOrNot2 = Ex7_TeenNumberChecker.isTeen(55);
        System.out.println("Teen or not: " + teenOrNot + ". Number is teen ?: " + teenOrNot2);

    }
}
