package com.udemy.section05.excercises_12_28;

public class Ex25_LargestPrime_UNSOLVED {

    public static void main(String[] args) {

        int lagerst = getLargestPrime(220);
        System.out.println(lagerst);
    }


    /*
    1. Check if i is factor;
    2. check which of factors is prime number;
    3. Check witch of prime numbers is max.

     */

    public static int getLargestPrime(int number) {
        if (number <= 1) {
            System.out.println("Invalid Number");
            return -1;
        }

        int might_be_prime = number;

        int factor = 0;

        for (int i = 2; i < might_be_prime; i++) {
            //is it a factor?

            if ((might_be_prime % i) == 0) {

                factor = i;
                System.out.println("Factor: " + factor);

                //oops! not prime prime factor - so / by this factor to get the next highest might_be_prime factor

                //might_be_prime = might_be_prime / i;

                int reverse = 0;
                System.out.println("Reverse: " + might_be_prime / factor);
                //i = i - 1;  //we don't wont to increment, because i might divide the number more than once
            }
        }
        //int highest_prime = might_be_prime;
        //return highest_prime;
        return -1;
    }




        /*
        int count = 0;
        int maxPrime = 0;

        if (number > 10) {

            for (int i = number; i > 1; i--) {
                if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                    maxPrime = i;
                    count++;
                    System.out.println(maxPrime + " is primal number. Count: " + count);

//                    if (count == 1) {
//                        maxPrime = i;
//                        break;
//                    }

                    if (maxPrime / i == 0) {
                        System.out.println(i + " is largest PRIMAL number. Count: " + count);
                    }
                }
            }


        } else if (number <= 10) {
            switch (number) {
                case 7:
                    maxPrime =7;
                    break;
                case 5:
                    maxPrime = 5;
                    break;
                case 3:
                    maxPrime = 3;
                    break;
                case 2:
                    maxPrime = 2;
                    break;
                default:
                    return -1;
            }
        }

        return maxPrime;
    }
*/
}
