package com.udemy.section05.excercises_12_28;

public class Ex21_FactorPrinter {

    public static void main(String[] args) {

        printFactors(32);


    }


    public static void printFactors (int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }

        int factor = 1;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factor = i;
                System.out.println(factor);
            }
        }
    }

}
