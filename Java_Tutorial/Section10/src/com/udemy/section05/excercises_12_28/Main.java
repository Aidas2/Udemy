package com.udemy.section05.excercises_12_28;

public class Main {

    public static void main(String[] args) {

        char charValue = 'E';

        switch (charValue) {
            case 'A':
                System.out.println("There is a letter A");
                break;
            case 'B':
                System.out.println("There is a letter B");
                break;
            case 'C':
                System.out.println("There is a letter C");
                break;
            case 'D':case 'E':
                System.out.println("There is a letter " + charValue);
                break;
            default:
                System.out.println("There is no letter A, B, C, D, E");
                break;
        }


        printDayOfTheWeek(5);
        Ex12_NumberInWord.printNumberInWord(6);

        System.out.println("==========================================");
        System.out.println("Is this year leap ? " + NumberOfDaysInMonth.isLeapYear(2000));







    }



    private static void printDayOfTheWeek (int day) {

        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
            default:
                System.out.println("Invalid day");
                break;
        }
    }

}
