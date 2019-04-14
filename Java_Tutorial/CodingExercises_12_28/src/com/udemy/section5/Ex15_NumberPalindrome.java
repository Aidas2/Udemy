package com.udemy.section5;

public class Ex15_NumberPalindrome {

    public static void main(String[] args) {

        System.out.println("Is number palindrome ? " + isPalindrome(-707));

    }


    public static boolean isPalindrome (int number) {

        int initialNumber = number;

        int reverse = 0;
        while (number > 0 || number < 0) {
            int lastDigit = number % 10;
            reverse *= 10;
            reverse += lastDigit;
            number = number / 10;
        }

        if (initialNumber == reverse) {
            System.out.println(initialNumber + " " + reverse);
            return true;
        }
        System.out.println(initialNumber + " " + reverse);
        return false;
    }
}
