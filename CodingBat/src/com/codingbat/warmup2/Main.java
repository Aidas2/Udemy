package com.codingbat.warmup2;

public class Main {

    public static void main(String[] args) {
        stringTimes("Hi", 3);
        frontTimes("Chocolate", 3);
        countXX("abcxx");
        doubleX("axxbb");
    }

//    Given a string and a non-negative int n, return a larger string that is n copies of the original string.
//    stringTimes("Hi", 2) → "HiHi"
//    stringTimes("Hi", 3) → "HiHiHi"
//    stringTimes("Hi", 1) → "Hi"
    public static String stringTimes(String str, int n) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            newStr += str;
        }
        System.out.println(newStr + "\n");
        return newStr;
    }

//    Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars,
//    or whatever is there if the string is less than length 3. Return n copies of the front;
//    frontTimes("Chocolate", 2) → "ChoCho"
//    frontTimes("Chocolate", 3) → "ChoChoCho"
//    frontTimes("Abc", 3) → "AbcAbcAbc
    public static String frontTimes(String str, int n) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            if (str.length() <= 3) {
                newStr += str;
                //return newStr;
            } else {
                newStr += str.substring(0, 3);
                //return newStr;
            }
        }
        System.out.println(newStr + "\n");
        return newStr;
    }

//    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
//    countXX("abcxx") → 1
//    countXX("xxx") → 2
//    countXX("xxxx") → 3
    public static int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            String xx = str.substring(i, i + 2);
            System.out.print(xx + " ");
            if (xx.equals("xx")) {
                count++;
            }
        }
        return count;
    }

//    Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
//    doubleX("axxbb") → true
//    doubleX("axaxax") → false
//    doubleX("xxxxx") → true
    public static boolean doubleX(String str) {
        boolean xFounded = true;
        while (xFounded) {
            for (int i = 0; i < str.length() - 1; i++) {
                if(str.charAt(i) == 'x' && str.charAt(i+1) == 'x') {
                    xFounded = false;
                    //System.out.println("\n" + "\n" + countOfRight);
                    //System.out.println(str.charAt(i) + " : " + str.charAt(i+1));
                    return true;
                }
            }
        }
        return false;
    }
}
