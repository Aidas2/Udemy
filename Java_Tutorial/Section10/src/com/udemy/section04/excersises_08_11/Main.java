package com.udemy.section04.excersises_08_11;

public class Main {

    public static void main(String[] args) {

        double areaOfCircle = Ex8_AreaCalculator.area(5);
        System.out.println("Area of circle; " + areaOfCircle);
        double areaOfRectangle = Ex8_AreaCalculator.area(15, 17);
        System.out.println("Area of rectangle: " + areaOfRectangle);


        System.out.println("============================================");
        Ex9_MinutesToYearsDaysCalculator.printYearsAndDays(50000);


        System.out.println("============================================");
        Ex10_IntEqualityPrinter.printEqual(3, 2, 3);


        System.out.println("============================================");
        boolean isCatPlaying = Ex11_PlayingCat.isCatPlaying(false, 35);
        System.out.println("Is cat playing ? " + isCatPlaying);

    }
}
