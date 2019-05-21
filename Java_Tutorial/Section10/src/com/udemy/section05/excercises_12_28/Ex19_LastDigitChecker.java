package com.udemy.section05.excercises_12_28;

public class Ex19_LastDigitChecker {

    public static void main(String[] args) {

        boolean hasOrNot1 = hasSameLastDigit(41, 22, 71);
        boolean hasOrNot2 = hasSameLastDigit(23, 32, 42);
        boolean hasOrNot3 = hasSameLastDigit(9, 99, 999);
        System.out.println(hasOrNot1 + " " + hasOrNot2 + " " + hasOrNot3);

    }


    public static boolean hasSameLastDigit (int a, int b, int c) {
        if (isValid(a) && isValid(b) && isValid(c)) {

            int last_a = a % 10;
            int last_b = b % 10;
            int last_c = c % 10;

            if (last_a == last_b || last_a == last_c || last_b == last_c) {
                return true;
            } else return false;

        } else return false;
    }

    public static boolean isValid (int number) {
        if (number >= 10 && number <= 1000) {
            return true;
        }
        else return false;
    }

}
