package com.codingbat.warmup1;

public class Main {

    public static void main(String[] args) {
        sleepIn(true, false);
        monkeyTrouble(true, true);
        frontBack("obuolys");
        backAround("cat");
        front22("kitten");
        startHi("h");
        delDel("adelbc");
        everyNth("Miracle", 2);
    }

//    The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation.
//    We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
//    sleepIn(false, false) → true
//    sleepIn(true, false) → false
//    sleepIn(false, true) → true
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        } else {
            return false;
        }
    }

//    We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
//    We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
//    monkeyTrouble(true, true) → true
//    monkeyTrouble(false, false) → true
//    monkeyTrouble(true, false) → false

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
            return true;
        }  else {
            return false;
        }
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
        String unwanted = str.substring(1, 4);
        System.out.println("unwanted: " + unwanted);
        if (unwanted.equals("del")) {
            str = str.substring(0, 1) + str.substring(4);
        }
        System.out.println("kombinuotas: " + str);
        return str;
    }

    public static String everyNth(String str, int n) {
        String newString = "";
        for (int i = 0; i < str.length(); i = i + n) {
            char oneChar = str.charAt(i);
            newString += oneChar;
        }
        System.out.println("everyNth: " + newString);
        return str;
    }


}
