package com.udemy.section05.excercises_12_28;

public class Ex18_SharedDigit {

    public static void main(String[] args) {

        boolean shared = hasSharedDigit(12, 13);
        System.out.println(shared);

    }


    public static boolean hasSharedDigit (int one, int two) {
        if((one < 10 || one > 99) || (two < 10 || two > 99)) {
            return false;
        }

        int lastDigit1 = one % 10;
        int firstDigit1 = one / 10;

        int lastDigit2 = two % 10;
        int firstDigit2 = two / 10;

        //System.out.println("pirmas: " + lastDigit1 + " " + firstDigit1 + " antras: " + lastDigit2 + " " + firstDigit2);

        if (lastDigit1 == lastDigit2 || lastDigit1 == firstDigit2 || firstDigit1 == lastDigit2 || firstDigit1 == firstDigit2) {
            return true;
        } else return false;
    }
}
