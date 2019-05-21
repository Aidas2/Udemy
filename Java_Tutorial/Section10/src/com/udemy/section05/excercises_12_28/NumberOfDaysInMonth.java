package com.udemy.section05.excercises_12_28;

public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public static int getDaysInMonth(int month, int year) {

        if (month < 1 || month > 12 || year < 1 || year > 9999) {
            return -1;
        }

        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 2:
                days = (isLeapYear(year)) ? 29 : 28;
//                if (isLeapYear(year) == true) {
//                    days = 29;
//                } else {
//                    days = 28;
//                }
            break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;

            default:
                System.out.println("Invalid value of month");
                break;
        }

        return days;

    }
}
