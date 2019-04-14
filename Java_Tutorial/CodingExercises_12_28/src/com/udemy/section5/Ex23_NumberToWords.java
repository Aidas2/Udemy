package com.udemy.section5;

public class Ex23_NumberToWords {

    public static void main(String[] args) {

        numberToWords(-123);

    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int reversedNumber = reverse(number);

        int digitCountOriginal = getDigitCount(number);
        int digitCountReversed = getDigitCount(reversedNumber);
        int numberOFZeroes = digitCountOriginal - digitCountReversed;

        //System.out.println(digitCountOriginal + " - " + digitCountReversed + " = " + numberOFZeroes);

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;
            reversedNumber /= 10;

            switch (lastDigit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("Invalid Value");
                    break;
            }
        }

        if (number == 0) {
            System.out.println("Zero");
        } else if (numberOFZeroes > 0) {
            for (int i = 1; i <= numberOFZeroes; i++) {
                System.out.println("Zero");
            }
        }

    }

    public static int reverse (int number) {

        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed *= 10;
            reversed += lastDigit;
            number = number / 10;
        }

        //System.out.println("Reversed number: " + reversed);
        return reversed;

    }

    public static int getDigitCount (int number) {
        if(number < 0) {
            //System.out.println("Negative number");
            return -1;
        }

        int count = 0;

        if (number == 0) {
            count++;
        }

        while (number > 0) {
            count++;
            number /=10;
        }

        //System.out.println("Count of digits is: " + count);
        return count;
    }
}
