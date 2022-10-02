package com.udemy.section17.regularExpresions.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {

        System.out.println(" === Challenge #1 =======================================================================");
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));


        System.out.println(" === Challenge #2 =======================================================================");
        //String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";


        //solution#1:
        String regEXp = "I want a \\w+.";   //      \\ escapes, w replaces non white spaces (A-Z, a-z, 0-9, _ ), +  one or more (quantifier)
        System.out.println(challenge1.matches(regEXp));
        System.out.println(challenge2.matches(regEXp));

        //solution#2:
        String regEXp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regEXp1));
        System.out.println(challenge2.matches(regEXp1));


        System.out.println(" === Challenge #3 =======================================================================");
        //String regEXp3 = ".*\\w+.*";  // . means any char, * means any quantity
        String regEXp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regEXp3);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());
        matcher = pattern.matcher(challenge2); // you don't have to create another instance
        System.out.println(matcher.matches());


        System.out.println(" === Challenge #4 =======================================================================");
        String challenge4 = "Replace all blanks with underscores";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));


        System.out.println(" === Challenge #5 =======================================================================");
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+")); // [abcdefg] matches any of character in brackets, + matches one or more
        System.out.println(challenge5.matches("[abcdefg]*"));   // same with a star quantifier (may be absent, or may by any quantity)
        System.out.println(challenge5.matches("[a-g]+"));     // same with a range


        System.out.println(" === Challenge #6 =======================================================================");
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));    //thee a followed by b followed by eight c followed by three d followed by e followed by three f followed by g
                                                                                // "^  $" matches entirety, not just part of the string
        challenge5 = "zaaabccccccccdddefffg";
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED")); //doesn't replaces(because complete doesn't match)
        System.out.println(challenge5.replaceAll("a{3}bc{8}d{3}ef{3}g$", "REPLACED")); //replaces (no ^ (no entirety requirement))


        System.out.println(" === Challenge #7 =======================================================================");
        String challenge7 = "abcd.135";
        String regEXp7 = "^[a-z]{4}\\.[0-9]{3}$"; // [interval]{quantity}
        System.out.println(challenge7.matches(regEXp7));
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$")); //[A-z] will match ASCII characters in the range from A to z


        System.out.println(" === Challenge #8 =======================================================================");
        String challenge8 = "abcd.135uvqz.7tzik.999";
        //Pattern pattern8 = Pattern.compile("\\.*(\\d+)");
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        int count = 0;
        while (matcher8.find()) {
            count++;
            System.out.println("Occurrence #" + count + " : " + matcher8.group(1)); //first group
        }


        System.out.println(" === Challenge #9 =======================================================================");
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        //Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)(\\t|\\n)");
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s"); // \t and \n are considered as \s (spaces)
        Matcher matcher9 = pattern9.matcher(challenge9);
        int count9 = 0;
        while (matcher9.find()) {
            count9++;
            System.out.println("Occurrence #" + count9 + " : " + matcher9.group(1)); //first group
        }

        System.out.println(" === Challenge #10 ======================================================================");
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10 = pattern10.matcher(challenge10);
        int count10 = 0;
        while (matcher10.find()) {
            count10++;
            System.out.println("Occurrence #" + count10 + " : " + matcher10.group(1)+ ", starts at " + matcher10.start(1) + " ends at " + (matcher10.end(1)-1));
        }


        System.out.println(" === Challenge #11 ======================================================================");
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}"); //  (.+?) means anything (. any, + one or more, ? lazy quantifier (if removed will grab all between firs and last curly bracers)
        Matcher matcher11 = pattern11.matcher(challenge11);
        int count11 = 0;
        while (matcher11.find()) {
            count11++;
            System.out.println("Occurrence #" + count11 + " : " + matcher11.group(1));
        }

        String challenge11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {6, 34}, {11, 12}";
        Pattern pattern11a = Pattern.compile("\\{(\\d+,\\s\\d+)\\}"); // {x, y} will be ignored
        Matcher matcher11a = pattern11a.matcher(challenge11a);
        int count11a = 0;
        System.out.println();
        while (matcher11a.find()) {
            count11a++;
            System.out.println("Occurrence #" + count11a + " : " + matcher11a.group(1));
        }


        System.out.println(" === Challenge #12 ======================================================================");
        String zipCode = "15111";
        Pattern pattern12 = Pattern.compile("^[0-9]{5}$"); // "^\\d{5}$"
        Matcher matcher12 = pattern12.matcher(zipCode);
        System.out.println(matcher12.matches());
        //more simple version:
        System.out.println(zipCode.matches("^\\d{5}$"));


        System.out.println(" === Challenge #13 ======================================================================");
        String zipCode13 = "11111-1111";
        System.out.println(zipCode13.matches("^\\d{5}-\\d{4}$"));


        System.out.println(" === Challenge #14 ======================================================================");
        String zipCode14 = "11111-1111";
        String zipCode14a = "11111";
        System.out.println(zipCode14.matches("^\\d{5}(-\\d{4})?$"));    // (-\d{4})? means group is optional (0 or 1 occurrences)
        System.out.println(zipCode14a.matches("^\\d{5}(-\\d{4})?$"));

    }
}
