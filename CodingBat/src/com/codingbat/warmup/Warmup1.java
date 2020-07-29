package com.codingbat.warmup;

public class Warmup1 {

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

    //==================================================================================================================
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

    //==================================================================================================================
//    We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
//    We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
//    monkeyTrouble(true, true) → true
//    monkeyTrouble(false, false) → true
//    monkeyTrouble(true, false) → false
    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
            return true;
        } else {
            return false;
        }
    }

    //==================================================================================================================
//    Given a string, return a new string where the first and last chars have been exchanged.
//    frontBack("code") → "eodc"
//    frontBack("a") → "a"
//    frontBack("ab") → "ba"
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

    //==================================================================================================================
//    Given a string, take the last char and return a new string with the last char added at the front and back,
//    so "cat" yields "tcatt". The original string will be length 1 or more.
//    backAround("cat") → "tcatt"
//    backAround("Hello") → "oHelloo"
//    backAround("a") → "aaa"
    public static String backAround(String str) {
        String last = str.substring(str.length() - 1);
        str = last + str + last;
        System.out.println(str);
        return str;
    }

    //==================================================================================================================
//    Given a string, take the first 2 chars and return the string with the 2 chars added at both the front and back,
//    so "kitten" yields"kikittenki". If the string length is less than 2, use whatever chars are there.
//    front22("kitten") → "kikittenki"
//    front22("Ha") → "HaHaHa"
//    front22("abc") → "ababcab"
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

    //==================================================================================================================
//    Given a string, return true if the string starts with "hi" and false otherwise.
//    startHi("hi there") → true
//    startHi("hi") → true
//    startHi("hello hi") → false
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

    //==================================================================================================================
//    Given a string, if the string "del" appears starting at index 1, return a string where that "del" has been deleted.
//    Otherwise, return the string unchanged.
//    delDel("adelbc") → "abc"
//    delDel("adelHello") → "aHello"
//    delDel("adedbc") → "adedbc"
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

    //==================================================================================================================
//    Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of
//    the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
//    everyNth("Miracle", 2) → "Mrce"
//    everyNth("abcdefg", 2) → "aceg"
//    everyNth("abcdefg", 3) → "adg"
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
