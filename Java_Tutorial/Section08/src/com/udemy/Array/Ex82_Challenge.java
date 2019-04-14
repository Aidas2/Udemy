package com.udemy.array;

import java.util.Scanner;

import static java.util.Arrays.sort;

/*
 Create a program using arrays that sorts a list of integers in descending order.
 Descending order is highest value to lowest.
 In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
 ultimately have an array with 106,81,26, 15, 5 in it.
 Set up the program so that the numbers to sort are read in from the keyboard.
 Implement the following methods - getIntegers, printArray, and sortIntegers
 getIntegers returns an array of entered integers from keyboard
 printArray prints out the contents of the array
 and sortIntegers should sort the array and return a new array containing the sorted numbers
 you will have to figure out how to copy the array elements from the passed array into a new
 array and sort them and return the new sorted array.
*/

public class Ex82_Challenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers =  getIntegers(5);
        int[] sortedArray = sortArray(myIntegers);
        printArray(sortedArray);
    }

    public static int[] getIntegers (int number) {
        System.out.println("Enter " + number + " integer values");
        int[] values = new int[number];

        for(int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", contents " + array[i]);
        }
        System.out.println("============");
    }

    private static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int temporal;

        while (flag) {
            flag = false;
            for(int i = 0; i < sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temporal = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temporal;
                    flag = true;
                }
            }
        }
        //sort(array);
        return sortedArray;
    }

}
