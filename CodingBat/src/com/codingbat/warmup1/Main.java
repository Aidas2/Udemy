package com.codingbat.warmup1;

public class Main {

    public static void main(String[] args) {
        // write your code here
        frontBack("obuolys");
        backAround("cat");
        front22("kitten");
        startHi("h");
        delDel("adelbc");
        everyNth("Miracle", 2);
    }

    public static String frontBack(String str) {

        if (str.length() <= 1) {
            System.out.println(str);
            return str;
        } else {
            String first = str.substring(0, 1);
            String last = str.substring(str.length() - 1);
            String between = str.substring(1, str.length() - 1);

            str = last + between + first;
            System.out.println(str);
            return str;
        }
    }

    public static String backAround(String str) {
        String last = str.substring(str.length() - 1);
        str = last + str + last;
        System.out.println(str);
        return str;
    }

    public static String front22(String str) {
        if (str.length() < 2) {
            return str + str + str;
        } else {
            String firstTwo = str.substring(0, 2);
            str = firstTwo + str + firstTwo;
            System.out.println(str);
            return str;
        }
    }

    public static boolean startHi(String str) {
        if (str.length() > 1) {
            String firstTwo = str.substring(0, 2);
            if (firstTwo.equals("hi")) {
                System.out.println("true");
                return true;
            }
        } else {
            System.out.println("false");
            return false;
        }
        return false;
    }

    public static String delDel(String str) {
        if (str.length() < 3) {
            System.out.println("originalus: " + str);
            return str;
        }
        String unwanted = str.substring(1,4);
        System.out.println("unwanted: " + unwanted);
        if (unwanted.equals("del")) {
            str = str.substring(0,1) + str.substring(4);
        }
        System.out.println("kombinuotas: " + str);
        return str;
    }

    public static String everyNth(String str, int n) {
        String newString = "";
        for (int i = 0; i < str.length(); i=i+n) {
            char oneChar = str.charAt(i);
            newString += oneChar;
        }
        System.out.println("everyNth: " + newString);
        return str;
    }



}
