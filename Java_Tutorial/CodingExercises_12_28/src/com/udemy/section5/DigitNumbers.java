package com.udemy.section5;

public class DigitNumbers {

    public static void main(String[] args) {

        System.out.println("Sum of digits is :" + sumDigits(955));

    }


    private static int sumDigits (int number) {
        if (number < 10) {
            return -1;
        }

        int sum = 0;

        while (number >=1) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number = number / 10;
        }

        return sum;

    }
}
