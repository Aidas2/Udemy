package com.udemy.section17.regularExpresions.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        System.out.println(htmlText);

        String h2Pattern = "<h2>";  //back
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());  //returns false, because not ".*<h2>.*"

        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());

        }

        String h2GroupPattern = "(<h2>.*?</h2>)"; // ? turns into lazy quantifier
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence group: " + groupMatcher.group(1)); //first group (tag h2)
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";     //(group1)(group2)(group3)
        Pattern h2TextPatten = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatten.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurrence groups: " + h2TextMatcher.group(2)); //second group (text between tags h2)
        }

        System.out.println("=========================================================================================");

        // "abc" "a" and "b" and "c"
        // [[Hh]arry
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc]   - NOT abc (matches all except abc)
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]"; //  find all t NOT followed by v (doesn't counts last t, because include v in the match)
        String tNotVRegExp = "t(?!v)";  //  find all t NOT followed by v (counts last t, because didn't include v in the match)
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // t(?=v)   //find all t followed by v (but didn't include v in the match)

        System.out.println("=========================================================================================");
        /*
        ((123) 456-7890    sample phone number
        ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        ^           whole string should math
        $           looks only in ending (all after $ is no match)
        [\(]{1}     escape mark for parenthesis and expected quantity (quantifier)
        [0-9]{3}    allowed digits and expected quantity
         */
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$  // ? zero or more occurrences
        String visa1 = "4444444444444"; // should match (begins with4, then 12 digits, then ? (means optional))
        String visa2 = "5444444444444"; // shouldn't match (starts with 5)
        String visa3 = "4444444444444444";  // should match (begins with4, then 12 digits, then 3 digits)
        String visa4 = "4444";  // shouldn't match (ony four digit)

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));


    }
}
