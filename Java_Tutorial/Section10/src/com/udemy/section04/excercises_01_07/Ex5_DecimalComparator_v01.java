package com.udemy.section04.excercises_01_07;

public class Ex5_DecimalComparator_v01 {

    public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber) {

        int firstOfFirst = determineFirstDecimal(firstNumber);
        int firstOfSecond = determineFirstDecimal(secondNumber);

        int secondOFFirst = determineSecondDecimal(firstNumber);
        int secondOFSecond = determineSecondDecimal(secondNumber);

        int thirdOfFirst = determineThirdDecimal(firstNumber);
        int thirdOfSecond = determineThirdDecimal(secondNumber);


        if (firstOfFirst == firstOfSecond || secondOFFirst == secondOFSecond || thirdOfFirst == thirdOfSecond) {
            return true;
        } else if (
                (firstOfFirst == firstOfSecond) && (secondOFFirst == secondOFSecond) ||
                        (firstOfFirst == firstOfSecond) && (thirdOfFirst == thirdOfSecond) ||
                        (secondOFFirst == secondOFSecond) && (thirdOfFirst == thirdOfSecond)
        ) {
            return true;

        } else if (
                (firstOfFirst == firstOfSecond) && (secondOFFirst == secondOFSecond) ||
                        (firstOfFirst == firstOfSecond) && (secondOFFirst == secondOFSecond) && (thirdOfFirst == thirdOfSecond)
        ) {
            return true;

        } else {
            return false;
        }

    }

    public static int determineFirstDecimal(double number) {
        int firstDecimal = (int) Math.floor((number - Math.floor(number)) * 10);
        System.out.println("First decimal is: " + firstDecimal);
        return firstDecimal;
    }

    public static int determineSecondDecimal(double number) {
        int secondDecimal = (int) Math.floor((number * 10 - Math.floor(number * 10)) * 10);
        System.out.println("Second decimal is: " + secondDecimal);
        return secondDecimal;
    }

    public static int determineThirdDecimal(double number) {
        int thirdDecimal = (int) Math.floor((number * 100 - Math.floor(number * 100)) * 10);
        System.out.println("Third decimal is: " + thirdDecimal);
        return thirdDecimal;
    }


}
