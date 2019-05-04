package com.udemy.section11.PackagesAndScope.scope.ChalengeAidasUNSOLVED;

import java.util.Scanner;

public class Main {

    // Write a small program to read an integer from the keyboard
    // (using Scanner) and print out the times table for that number.
    // The table should run from 1 to 12.
    //
    // You are allowed to use one variable called scanner for your
    // Scanner instance. You can use as many other variables as you
    // need, but they must must all be called x. That includes any
    // class instances and loop control variables that you may decide
    // to use.
    //
    // If you use a class, the class can be called X (capital), but
    // any instances of it must be called x (lower case).
    //
    // Any methods you create must also be called x.
    //
    // Optional Extra:
    // Change your program so that ALL variables (including the scanner
    // instance) are called x.

    public static void main(String[] args) {
//version 1:
        /*
        X x = new X();
        x.x(5);
        */

//version 2: DOESN'T WORK CORRECTLY :(
        X x = new X();
        x.x(new Scanner(System.in));
    }
}
