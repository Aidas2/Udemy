package com.udemy.section05.excercises_12_28;

public class Ex22_PerfectNumber {

    public static void main(String[] args) {

        boolean perfect = isPerfectNumber(28);
        System.out.println(perfect);

    }


    public static boolean isPerfectNumber (int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        if (sum == number) {
            return true;
        } else return false;
    }

}
