package com.udemy.section5;

public class Ex16_FirstLastDigitSum {

    public static void main(String[] args) {

        int finalSum = sumFirstAndLastDigit(252);
        System.out.println(finalSum);
    }

    public static int sumFirstAndLastDigit (int number) {
        if (number < 0 ) {
            return -1;
        }

        int sum = 0;
        int lastDigit = number % 10;

        while (number >= 10) {

            number /= 10;
        }

        System.out.println(lastDigit + " " + number);
        sum = lastDigit + number;

        return sum;
    }

}
