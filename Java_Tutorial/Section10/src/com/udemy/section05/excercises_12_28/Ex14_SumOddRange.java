package com.udemy.section05.excercises_12_28;

public class Ex14_SumOddRange {

    public static void main(String[] args) {

        int sum = sumOdd(1, 100);
        System.out.println(sum);
    }

    public static boolean isOdd (int number) {
        if (number <= 0 || number %2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int sumOdd (int start, int end) {

        int sum = 0;

        if (start > 0 && end > 0 && end >= start) {
            for (int i = start; i <= end; i++) {
                if (isOdd(i)) {
                    sum += i;
                }
            }
        } else return -1;

        return sum;
    }
}
