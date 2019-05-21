package com.udemy.section08.arrays.Array;

import java.util.Arrays;

/*
-Write a method called reverse() with an int array as a parameter.

-The method should not return any value. In other words, the method is allowed to modify the array parameter.

-In main() test the reverse() method and print the array both reversed and non-reversed.

-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.

-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.

Tip:
	-Create a new console project with the name eReverseArrayChallengef
 */

public class Ex86_ReverseArrayChallenge {
    public static void main(String[] args) {

        int[] myArray = new int[] {1,2,3,4,5,6,7};
        System.out.println("Array before reverse: " + Arrays.toString(myArray));
        reverse(myArray);
        System.out.println("Array after reverse: " + Arrays.toString(myArray));
    }


    public static void reverse(int[] array) {

        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
            //System.out.println("index i="+i + ": " + Arrays.toString(array));
        }
    }
}