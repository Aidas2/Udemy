package com.codingbat.string1;

public class String1 {
    public static void main(String[] args) {
        helloName("Bob");
        makeAbba("Hi", "Bye");
        makeTags("i", "Hello");
        makeOutWord("<<>>", "WooHoo");
        extraEnd("Hello");
        firstTwo("abcdefg");
    }

    //==================================================================================================================
    //    Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
//    helloName("Bob") → "Hello Bob!"
//    helloName("Alice") → "Hello Alice!"
//    helloName("X") → "Hello X!"
    public static String helloName(String name) {
        String result = "Hello " + name + "!";
        System.out.println(name + " --> " + result);
        return result;
    }

    //==================================================================================================================
//    Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye"
//    returns "HiByeByeHi".
//    makeAbba("Hi", "Bye") → "HiByeByeHi"
//    makeAbba("Yo", "Alice") → "YoAliceAliceYo"
//    makeAbba("What", "Up") → "WhatUpUpWhat"
    public static String makeAbba(String a, String b) {
        String result = a + b + b + a;
        System.out.println(a + ", " + b + " --> " + result);
        return result;
    }
    //==================================================================================================================
//    The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example, the "i" tag
//    makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the HTML string with tags
//    around the word, e.g. "<i>Yay</i>".
//    makeTags("i", "Yay") → "<i>Yay</i>"
//    makeTags("i", "Hello") → "<i>Hello</i>"
//    makeTags("cite", "Yay") → "<cite>Yay</cite>
    public static String makeTags(String tag, String word) {
        String result = "<" + tag + ">" + word + "</" + tag + ">";
        System.out.println(tag + ", " + word + " --> " + result);
        return result;
    }
    //==================================================================================================================
//    Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle of
//    the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i and going
//    up to but not including index j.
//    makeOutWord("<<>>", "Yay") → "<<Yay>>"
//    makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
//    makeOutWord("[[]]", "word") → "[[word]]"
    public static String makeOutWord(String out, String word) {
        String substring1 = out.substring(0, 2);
        String substring2 = out.substring(2);
        String result = substring1 + word + substring2;
        System.out.println(out + ", " + word + " --> " + result);
        return result;
    }
    //==================================================================================================================
//    Given a string, return a new string made of 3 copies of the last 2 chars of the original string.
//    The string length will be at least 2.
//    extraEnd("Hello") → "lololo"
//    extraEnd("ab") → "ababab"
//    extraEnd("Hi") → "HiHiHi"
    public static String extraEnd(String str) {
        String end = str.substring(str.length()-2);
        String result = end + end + end;
        System.out.println(str + " --> " + result);
        return result;
    }
    //==================================================================================================================
//    Given a string, return the string made of its first two chars, so the String "Hello" yields "He".
//    If the string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
//    yields the empty string "". Note that str.length() returns the length of a string.
//    firstTwo("Hello") → "He"
//    firstTwo("abcdefg") → "ab"
//    firstTwo("ab") → "ab"
    public static String firstTwo(String str) {
        if(str.length() <= 2) {
            System.out.println(str + " --> " + str);
            return str;
        } else {
            String result = str.substring(0,2);
            System.out.println(str + " --> " + result);
            return result;
        }
    }
    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


    //==================================================================================================================


}