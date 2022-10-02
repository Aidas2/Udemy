package com.udemy.section05.excercises_12_28;

public class Ex17_EvenDigitSum {

    public static void main(String[] args) {

        int finalSum = getEvenDigitSum(123456789);
        System.out.println(finalSum);
    }

    public static int getEvenDigitSum (int number) {
        if (number < 0) {
            return -1;
        }

        int sum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            number /= 10;
            if (lastDigit % 2 == 0) {
                sum += lastDigit;
            }
        }

        return sum;
    }
}
