package com.codingbat.warmup2;

public class Main {

    public static void main(String[] args) {
//        stringTimes("Hi", 3);
//        frontTimes("Chocolate", 3);
//        countXX("abcxx");
//        doubleX("axxbb");
//        doubleXX("axxbb");
//        stringBits("Heeololeo");
        stringSplosion("Code");
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
        char firstX = 'a';
        char afterX = 'b';
        boolean doubleX = true;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'x') {
                firstX = str.charAt(i);
                afterX = str.charAt(i + 1);
                System.out.println("\n" + "\n" + "cikle " + firstX + " : " + afterX);
                break;
            }
        }

        if (firstX == afterX) {
            doubleX = true;
        } else if (firstX != afterX) {
            doubleX = false;
        }
        System.out.println("uz ciklo " + firstX + " : " + afterX);

        return doubleX;
    }

    //another solution:
    public static boolean doubleXX(String str) {
        int firstXPosition = str.indexOf("x");
        if (firstXPosition == -1) return false; // no "x" at all
        if (firstXPosition + 1 >= str.length()) return false; // check i+1 in bounds?

        char firstX = str.charAt(firstXPosition);
        char afterX = str.charAt(firstXPosition + 1);
        System.out.println("firstX = " + firstX + ", afterX = " + afterX);
        return firstX == afterX;

        // Another approach -- .startsWith() simplifies the logic
        // String x = str.substring(i);
        // return x.startsWith("xx");
    }


//    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
//    stringBits("Hello") → "Hlo"
//    stringBits("Hi") → "H"
//    stringBits("Heeololeo") → "Hello"

    public static String stringBits(String str) {
        String result = "";

//        for (int i = 0; i < str.length(); i++) {
//            if (i % 2 == 0) {
//                result = result + str.charAt(i);
//                System.out.println("i = " + i + ", char = " + str.charAt(i));
//            }
//        }

        //alternative solution:
        for (int i = 0; i < str.length(); i += 2) {
            result += str.charAt(i);
            System.out.println("i = " + i + ", char = " + str.charAt(i));
        }

        System.out.println("Result: " + result);
        return result;


    }

//    Given a non-empty string like "Code" return a string like "CCoCodCode".
//    stringSplosion("Code") → "CCoCodCode"
//    stringSplosion("abc") → "aababc"
//    stringSplosion("ab") → "aab"

    public static String stringSplosion(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String add = str.substring(0, str.length()-i);
            result = add + result;
            System.out.println("add = " + add);
            System.out.println("Result = " + result);

        }
        return result;
    }

}
