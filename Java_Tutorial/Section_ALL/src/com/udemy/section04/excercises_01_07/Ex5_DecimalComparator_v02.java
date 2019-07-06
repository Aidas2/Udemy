package com.udemy.section04.excercises_01_07;

public class Ex5_DecimalComparator_v02 {

    public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber) {

        int first = (int)(firstNumber*1000);
        int second = (int)(secondNumber*1000);

        System.out.println(first + " and " + second);
        System.out.println(first == second);

        if (first == second) {
            return true;
        } else {
            return false;
        }
    }

}
