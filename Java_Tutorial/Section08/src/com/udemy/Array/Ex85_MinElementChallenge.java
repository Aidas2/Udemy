package com.udemy.array;

import java.util.Arrays;
import java.util.Scanner;

public class Ex85_MinElementChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        System.out.println("Array " + Arrays.toString(myIntegers));
        int minimum = getMinElement(myIntegers);
        System.out.println("Minimum element is " + minimum);
    }

    public static int[] getIntegers (int number) {
        System.out.println("Enter " + number + " integers");
        int[] values = new int[number];

        for(int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static int getMinElement (int[] array) {
        int minValue = array[0];
        for(int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
