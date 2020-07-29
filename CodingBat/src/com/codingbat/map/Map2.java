package com.codingbat.map;

import java.util.HashMap;
import java.util.Map;

public class Map2 {
    public static void main(String[] args) {

//        wordAppend(["a", "b", "b", "b", "a", "c", "a", "a", "a", "b", "a"])

    }

    //==================================================================================================================
//    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array,
//    always with the value 0. For example the string "hello" makes the pair "hello":0. We'll do more complicated
//    counting later, but for this problem the value is simply 0.
//    word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
//    word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
//    word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < strings.length; i++) {
//            map.put(strings[i], 0);
//        }
        for (String s:strings) {
            map.put(s, 0);
        }
        return map;
    }
    //==================================================================================================================
//    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array,
//    and the value is that string's length.
//    wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
//    wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
//    wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, str.length());
        }
        return map;
    }
    //==================================================================================================================
//    Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its
//    first character as a key with its last character as the value.
//    pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//    pairs(["man", "moon", "main"]) → {"m": "n"}
//    pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            map.put(str.substring(0,1), str.substring(str.length()-1));
        }
        return map;
    }
    //==================================================================================================================
//    The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each
//    different string, with the value the number of times that string appears in the array.
//            wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
//    wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
//    wordCount(["c", "c", "c", "c"]) → {"c": 4}
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str)+1);
            }
        }
        return map;
    }
    //==================================================================================================================
//    Given an array of non-empty strings, return a Map<String, String> with a key for every different first character
//        seen, with the value of all the strings starting with that character appended together in the order they
//    appear in the array.
//            firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
//    firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
//    firstChar([]) → {}
    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            String first = str.substring(0,1);
            if(!map.containsKey(first)) {
                map.put(first, str);
            } else {
                map.put(first, map.get(first)+str);
            }
        }
        return map;
    }

    //==================================================================================================================
//    Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th,
//    etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.
//    wordAppend(["a", "b", "a"]) → "a"
//    wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
//    wordAppend(["a", "", "a"]) → "a"

    public static String wordAppend(String[] strings) {
//        Map<String, String> map = new HashMap<>();
//        String result = "";
//        int count = 1;            // not working as expected;
//        for (String str : strings) {
//            if(!map.containsKey(str)) {
//                map.put(str, str);
//            } else {
//                count++;
//                map.put(str, str);
//                if (count % 2 == 0) {
//                    result += str;
//                }
//            }
//        }
//        return result;
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        for (String str : strings) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str)+1);
                if (map.get(str) % 2 == 0) {
                    result += str;
                }
            }
        }
        return result;
    }
    //==================================================================================================================



}
