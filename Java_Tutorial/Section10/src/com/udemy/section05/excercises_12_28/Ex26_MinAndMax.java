package com.udemy.section05.excercises_12_28;

import java.util.Scanner;

public class Ex26_MinAndMax {

    public static void main(String[] args) {

        readAndPrint();

    }


    public static void readAndPrint() {
        Scanner scanner = new Scanner(System.in);

        int min = 0;
        int max = 0;
        boolean first = true;

        //without boolean first:
//        int min = 2147483647;
//        int max = -2147483647;

//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;


        while (true) {

            System.out.println("Enter number:");
            boolean isAnInt = scanner.hasNextInt();

            if (isAnInt) {
                int number = scanner.nextInt();

                if(first) {
                    first = false;
                    max = number;
                    min = number;
                }


                if (number > max) {
                    max = number;
                    //min = number;
                }

                if (number < min ) {
                    min = number;
                }
            } else {
                System.out.println("Invalid number");
                break;
            }

            scanner.nextLine();
        }

        System.out.println("Min: " + min + " Max:" + max);

        scanner.close();

        //return min;
        //return max;
    }

}
