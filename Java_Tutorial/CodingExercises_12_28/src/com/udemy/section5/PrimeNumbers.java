package com.udemy.section5;

public class PrimeNumbers {

    public static void main(String[] args) {

        int count = 0;
        for(int i = 1; i <= 50; i++) {

            if (isPrime(i)) {
                System.out.println("Number " + i + " is prime number");
                count ++;
                if (count == 10) {
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime (int n) {
        if(n==1) {
            return false;
        }
        // n/2 - for eliminating event numbers (?); n % i == 0 means that number divides evenly (not prime) ?
        for (int i = 2; i <= n/2; i++) {
            System.out.println("Looping " + i);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



}
