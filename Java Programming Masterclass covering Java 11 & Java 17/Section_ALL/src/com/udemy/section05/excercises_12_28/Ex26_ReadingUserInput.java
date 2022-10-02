package com.udemy.section05.excercises_12_28;

import java.util.Scanner;

public class Ex26_ReadingUserInput {
    public static void main(String[] args) {

        int sum = sumInt();
        System.out.println("Sum of all ten numbers is: " + sum);

    }


    public static int sumInt () {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;

        while (counter < 10) {
            System.out.println("Enter number #" + (counter+1) + ":");
            boolean hasNextInt = scanner.hasNextInt();

            if(hasNextInt) {
                int number = scanner.nextInt();
                counter++;
                sum += number;
                //scanner.nextLine();
            } else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine();
        }


        scanner.close();

        return sum;
    }

}
