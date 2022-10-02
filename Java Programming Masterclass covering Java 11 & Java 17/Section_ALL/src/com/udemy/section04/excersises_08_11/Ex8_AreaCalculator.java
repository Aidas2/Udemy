package com.udemy.section04.excersises_08_11;

public class Ex8_AreaCalculator {

    public static double area (double radius) {

        if (radius < 0) {
            return -1.0d;
        }

        double area = 3.14159 * radius * radius;
        return area;
    }

    public static double area (double x, double y) {

        if (x < 0 || y < 0) {
            return -1.0d;
        }

        double area = x * y;
        return area;
    }
}
