package com.coderbyte;

import java.util.Scanner;

public class SimpleSum {


        public static int SimpleAdding(int num) {

            int sum = 0;
            for(int i = num; i >=1; i--) {
                System.out.println("i = " + i);
                sum += i;
                System.out.println("sum = " + sum);
            }
            // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */

            return sum;

        }

        public static void main (String[] args) {
            // keep this function call here
            Scanner s = new Scanner(System.in);
            System.out.print(SimpleAdding(s.nextInt()));
        }

    }

