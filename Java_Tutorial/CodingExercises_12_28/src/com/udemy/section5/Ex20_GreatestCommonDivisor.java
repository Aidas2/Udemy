package com.udemy.section5;

public class Ex20_GreatestCommonDivisor {

    public static void main(String[] args) {

        int greatest1 = getGreatestCommonDivisor(25, 15);
        int greatest2 = getGreatestCommonDivisor(81, 153);
        System.out.println("Greatest: " + greatest1 + " " + greatest2);
    }


    public static int getGreatestCommonDivisor (int a, int b) {
        if (a < 10 || b < 10 ) {
            return -1;
        }

        int max = 1;

        for (int i = 1; i <= a; i++) {

            if (a % i == 0 && b % i == 0 ) {
                max = i;
                System.out.println("max: " + max);
            }

        }

        return max;
    }
}
