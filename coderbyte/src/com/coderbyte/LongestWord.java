package com.coderbyte;

import java.util.*;
import java.io.*;

class LongestWord {

    public static String LongestWord(String sen) {

        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */
        String[] words = sen.split("[^A-Za-z0-9]");
//        for (int i = 0; i < words.length; i++) {
//            words[i] = words[i].replaceAll("[^\\w]", "");
//        }

        String max = words[0];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > max.length()) {
                max = words[i];
            }
        }
        return max;
    }

    public static void main (String[]args){
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }

}



