package com.udemy.section04.excercises_01_07;

public class Ex7_TeenNumberChecker {

    public static boolean hasTeen (int one, int two, int three) {
        if ((one >= 13 && one <= 19) || (two >= 13 && two <= 19) || (three >= 13 && three <= 19)) {
            return true;
        } else return false;
    }

    public static boolean isTeen (int number) {
        if (number >= 13 && number <= 19) {
            return true;
        } else return false;
    }
}
