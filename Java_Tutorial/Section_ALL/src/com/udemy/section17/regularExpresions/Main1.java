package com.udemy.section17.regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY")); // ^ - looks only in beginning

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));   // whole string should math
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END")); // $ - looks only in ending
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here")); //replaces not pattern, but any char from pattern
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X")); // replaces any char from aei followed by any char from Fj

        System.out.println("=========================================================================================");

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));   //  [^] - replaces all except ej
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));  // [] - replaces any char from pattern
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X")); // [a-z] it's a range
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X")); //(?i) ignoring case sensitivity
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X")); //replaces any digit
        System.out.println(newAlphanumeric.replaceAll("\\D", "X")); //replaces all non digit

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", ""));    //replaces s (space)
        System.out.println(hasWhitespace.replaceAll("\t", "X"));    //replaces t (tab)
        System.out.println(hasWhitespace.replaceAll("\\S", ""));    //replaces non s (spaces)
        System.out.println(newAlphanumeric.replaceAll("\\w", "X")); //replaces non w (white space)
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));   //replaces boundaries

        System.out.println("=========================================================================================");

        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY")); // eee --> e{3} (how many times occurs)
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));   // e+ means one or more e
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));   // e* means no matter (e may be absent, or may by any quantity)
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));   // interval (how many times occurs)
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));       //any number of h, i may be not or any number

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

//        String h2Pattern = "<h2>";  //will return false (because math whole string)
        String h2Pattern = ".*<h2>.*";  //will return true (. means any char, * means any quantity)
        Pattern pattern = Pattern.compile(h2Pattern);
//        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());     // returns true, because ".*<h2>.*"

    }
}
