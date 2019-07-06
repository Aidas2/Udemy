package com.udemy.section05.excercises_12_28;

import java.util.Scanner;

public class Ex27_InputCalculator {

    public static void main(String[] args) {

        inputThenPrintSumAndAverage();

    }



    public static void inputThenPrintSumAndAverage () {

        Scanner scanner = new Scanner(System.in);




        int sum = 0;
        int count = 0;
        long avg = 0;

        while (true) {
            System.out.println("Enter number: ");
            boolean isAnInt = scanner.hasNextInt();

            if (isAnInt) {

                int number = scanner.nextInt();
                sum += number;
                count++;
                avg = Math.round((double) sum / count);


            } else {
                //System.out.println("Invalid number");
                break;
            }


            scanner.nextLine();
        }


        System.out.println("SUM = " + sum + " AVG = " + avg);
        scanner.close();
    }
}
