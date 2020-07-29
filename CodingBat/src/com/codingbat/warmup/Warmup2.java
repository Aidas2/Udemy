package com.codingbat.warmup;

public class Warmup2 {

    public static void main(String[] args) {
//        stringTimes("Hi", 3);
//        frontTimes("Chocolate", 3);
//        countXX("abcxx");
//        doubleX("axxbb");
//        doubleX_2("axxbb");
//        stringBits("Heeololeo");
//        stringSplosion("Code");
//        last2("xxxx");
//        arrayCount9(new int[]{1, 9, 9, 3, 9});
//        arrayFront9(new int[]{1, 2, 9, 3, 4});
//        array123(new int[]{1, 1, 2, 1, 2, 3});
        stringMatch("aabbcccdd", "abbbxxxd");
//        stringMatch_2("aabbcccdd", "abbbxxxd");
//        stringX("x");
//        stringX_2("xx");
//        altPairs("CodingHorror");
//        altPairs("Chocolate");
//        altPairs_2("CodingHorror");
//        altPairs_2("Chocolate");
//        stringYak("yakpak");
//        array667(new int[]{6, 6, 2, 6});
//        noTriples(new int[]{1, 1, 1, 2, 2, 2, 1});
        has271(new int[]{1, 2, 7, 1});

        absolute(2, 7);
        absolute(2, -7);
        absolute(-2, 7);
        absolute(-2, -7);

    }

    //==================================================================================================================
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

    //==================================================================================================================
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

    //==================================================================================================================
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

    //==================================================================================================================
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
    public static boolean doubleX_2(String str) {
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
    //==================================================================================================================
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
    //==================================================================================================================
//    Given a non-empty string like "Code" return a string like "CCoCodCode".
//    stringSplosion("Code") → "CCoCodCode"
//    stringSplosion("abc") → "aababc"
//    stringSplosion("ab") → "aab"

    public static String stringSplosion(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String add = str.substring(0, str.length() - i);
            result = add + result;
            System.out.println("add = " + add);
            System.out.println("Result = " + result);

        }
        return result;
    }
    //==================================================================================================================
//    Given a string, return the count of the number of times that a substring length 2 appears in the string and also
//    as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
//    last2("hixxhi") → 1
//    last2("xaxxaxaxx") → 1
//    last2("axxxaaxx") → 2

    public static int last2(String str) {
        //reverse iteration (i--) is to complicated, try to avoid !
        int count = 0;
        if (str.length() <= 2) {
            //System.out.println(str.length());
            count = 0;
        } else {
            String lastTwo = str.substring(str.length() - 2);
            //String justTwo = str.substring(str.length()-4, str.length()-2);
            //System.out.println("lastTwo = " + lastTwo);
            //System.out.println("justTwo = " + justTwo);
            //System.out.println(str.length());

            for (int i = str.length() + 1; i > 3; i--) {
                //System.out.println("i = " + i);
                if (str.substring(i - 4, i - 2).equals(lastTwo)) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
        return count;
    }
    //==================================================================================================================
//    Given an array of ints, return the number of 9's in the array.
//    arrayCount9([1, 2, 9]) → 1
//    arrayCount9([1, 9, 9]) → 2
//    arrayCount9([1, 9, 9, 3, 9]) → 3

    public static int arrayCount9(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9) {
                count++;
            }
        }
        System.out.println("count = " + count);
        return count;
    }
    //==================================================================================================================
//    Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
//    arrayFront9([1, 2, 9, 3, 4]) → true
//    arrayFront9([1, 2, 3, 4, 9]) → false
//    arrayFront9([1, 2, 3, 4, 5]) → false

    public static boolean arrayFront9(int[] nums) {
        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 9) {
                    return true;
                }
            }
        } else if (nums.length > 3) {

            for (int i = 0; i < 3; i++) {
                if (nums[i] == 9) {
                    return true;
                }
            }
        }
        return false;
    }
    //==================================================================================================================
//    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
//    array123([1, 1, 2, 3, 1]) → true
//    array123([1, 1, 2, 4, 1]) → false
//    array123([1, 1, 2, 1, 2, 3]) → true

    public static boolean array123(int[] nums) {
        for (int i = 0; i < (nums.length - 2); i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }
    //==================================================================================================================
//    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
//    So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.
//    stringMatch("xxcaazz", "xxbaaz") → 3
//    stringMatch("abc", "abc") → 2
//    stringMatch("abc", "axc") → 0

    public static int stringMatch(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length() - 1; i++) {
            String a2 = a.substring(i, i + 2);
//            int positionA = a.indexOf(a2); //doesn't work ?!
            for (int j = 0; j < b.length() - 1; j++) {
                String b2 = b.substring(j, j + 2);
//                int positionB = b.indexOf(b2); //doesn't work ?!
                System.out.println(a2 + ":" + b2 + " " + (a2.equals(b2) ? "TRUE" : " ") + " " + i + ":" + j);
                if (a2.equals(b2) && (i == j)) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
        System.out.println("=============================================");
        return count;
    }

    //more simple solution
    public static int stringMatch_2(String a, String b) {
        // Figure which string is shorter.
        int len = Math.min(a.length(), b.length());
        int count = 0;

        // Look at both substrings starting at i
        for (int i = 0; i < len - 1; i++) {
            String aSub = a.substring(i, i + 2);
            String bSub = b.substring(i, i + 2);
            System.out.println(aSub + ":" + bSub + " " + (aSub.equals(bSub) ? "TRUE" : " ") + " " + i);
            if (aSub.equals(bSub)) {  // Use .equals() with strings
                System.out.println();
                count++;
            }
        }
        System.out.println("count = " + count);
        return count;
    }

    //==================================================================================================================
//    Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.
//    stringX("xxHxix") → "xHix"
//    stringX("abxxxcd") → "abcd"
//    stringX("xabxxxcdx") → "xabcdx
    public static String stringX(String str) {
        if (str.length() > 0) {

            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != 'x') {
                    result += str.charAt(i);
                }
            }

            char first = str.charAt(0);
            if (first == 'x') {
                result = first + result;
            }

            char last = str.charAt(str.length() - 1);
            if (last == 'x' && str.length() > 1) {
                result += last;
            }

            System.out.println(str + " --> " + result);
            return result;
        } else {
            return str;
        }
    }

    //more simple and clever solution (excluding first and last by "i > 0 && i < (str.length()-1)"):
    public static String stringX_2(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            // Only append the char if it is not the "x" case
            if (!(i > 0 && i < (str.length() - 1) && str.substring(i, i + 1).equals("x"))) {
                result = result + str.substring(i, i + 1); // Could use str.charAt(i) here
            }
        }
        return result;
    }

    //==================================================================================================================
    //    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
//    altPairs("kitten") → "kien"
//    altPairs("Chocolate") → "Chole"
//    altPairs("CodingHorror") → "Congrr"
    public static String altPairs(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 4) {
            result = result + str.charAt(i) + ((i == str.length() - 1) ? "" : str.charAt(i + 1));
        }
        System.out.println(str + " --> " + result);
        return result;
    }

    //another solution (with toggling end):
    public static String altPairs_2(String str) {
        String result = "";

        // Run i by 4 to hit 0, 4, 8, ...
        for (int i = 0; i < str.length(); i += 4) {
            // Append the chars between i and i+2
            int end = i + 2;
            if (end > str.length()) {
                end = str.length();
            }
            result = result + str.substring(i, end);
        }
        System.out.println(str + " --> " + result);
        return result;
    }

    //==================================================================================================================
//    Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap.
//    stringYak("yakpak") → "pak"
//    stringYak("pakyak") → "pak"
//    stringYak("yak123ya") → "123ya"
    public static String stringYak(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            //Look for i starting a "yak" -- advance i in that case
            //if (str.charAt(i) == 'y' && str.charAt(i+2) == 'k' && i+2 < str.length()) {
            if (i + 2 < str.length() && str.substring(i, i + 3).equals("yak")) {
                i = i + 2; //do nothing, just skip "yak" ! (increasing not all iteration, but only if condition is met)
            } else { // otherwise do the normal append
                result = result + str.charAt(i);
            }
        }
        System.out.println(str + " --> " + result);
        return result;
    }

    //==================================================================================================================
//    Given an array of ints, return the number of times that two 6's are next to each other in the array.
//    Also count instances where the second "6" is actually a 7.
//    array667([6, 6, 2]) → 1
//    array667([6, 6, 2, 6]) → 1
//    array667([6, 7, 2, 6]) → 1
    public static int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) {
                count++;
            }
        }
        System.out.println("count = " + count);
        return count;
    }

    //==================================================================================================================
//    Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
//    Return true if the array does not contain any triples.
//    noTriples([1, 1, 2, 2, 1]) → true
//    noTriples([1, 1, 2, 2, 2, 1]) → false
//    noTriples([1, 1, 1, 2, 2, 2, 1]) → false
    public static boolean noTriples(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                System.out.println("false !");
                return false;
            }
        }
        System.out.println("true !");
        return true;
    }

    //==================================================================================================================
//    Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed by the value plus 5,
//    followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
//    has271([1, 2, 7, 1]) → true
//    has271([1, 2, 8, 1]) → false
//    has271([2, 7, 1]) → true
    public static boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + 5) == nums[i + 1] && Math.abs((nums[i + 2]) - (nums[i] - 1)) <= 2) { //(nums[i] -1 )
                // - because you need difference not between i and i+2, but difference between difference (?)
                System.out.println("true !");
                return true;
            }
        }
        System.out.println("false !");
        return false;
    }

    public static void absolute(int one, int two) {
        System.out.println(one + " - (" + two + ") = " + Math.abs(one - two) + ";");
        System.out.println(one + " - (" + two + ") = " + (Math.abs(one) - Math.abs(two)) + ";");
        System.out.println("============================");
    }
}
