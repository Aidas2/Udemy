package com.coderbyte;

import java.util.Scanner;

public class Capitalize {

    public static String LetterCapitalize(String str) {

        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */

        String[] separateWords = str.split("[^A-Za-z0-9]");
        String capitalizedString = "";
        for(int i = 0; i < separateWords.length; i++) {
            separateWords[i] = separateWords[i].substring(0,1).toUpperCase() + separateWords[i].substring(1);
            capitalizedString += separateWords[i] + " ";
        }

        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1));

        return capitalizedString;

    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCapitalize(s.nextLine()));
    }

}





