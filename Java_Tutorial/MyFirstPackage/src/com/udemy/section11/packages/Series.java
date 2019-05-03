package com.udemy.section11.packages;

public class Series {

    // Create a suitably named package containing a class called Series
    // with the following static methods:
    // nSum(int n) returns the sum of all numbers from 0 to n. The first 10 numbers are:
    // 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55.
    //
    // factorial(int n) returns the product of all numbers from 1 to n
    //      i.e. 1 * 2 * 3 * 4 ... * (n - 1) * n.
    // The first 10 factorials are:
    // 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800.
    //
    // fibonacci(n) returns the nth Fibonacci number. These are defined as:
    // f(0) = 0
    // f(1) = 1
    // f(n) = f(n-1) + f(n-2)
    // (so f(2) is also 1. The first 10 fibonacci numbers are:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.
    //
    // When you have tested your functions, delete the Main class and
    // produce a jar file.
    //
    // Create a new project and add your Series library, then test the
    // three methods in the main() method of your new project.


    public static long nSum (int n) {
        long sum = 0;
        int[] numbers = new int[] {0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55};

        if (n >= 1 && n <= numbers.length) {
            for (int i = 0; i <= n-1; i++) {
                sum += numbers[i];
            }
        }

        else {
            System.out.println("Number mus be from 1 to 11");
            //return -1;
        }
        //System.out.println(("Sum of first " + n + " numbers is " + sum));
        return sum;
    }

    public static void nSum2 (int n) {
        long sum = 0;
        System.out.print("Sum2: ");
        for (int i = 0; i <= n; i++) {
            sum += i;
            System.out.print(sum + ", ");
        }
    }

    public static long factorial (int n) {
        long result = 1;

        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }
        return result;
    }

    public static long fibonacci (int n) {
        long nthFibonacci;
        if (n == 0) {
            nthFibonacci = 0;
            //System.out.println(n + " number of fibonacci is " + nthFibonacci);
            return nthFibonacci;
        } else if (n == 1) {
            nthFibonacci = 1;
            //System.out.println(n + " number of fibonacci is " + nthFibonacci);
            return nthFibonacci;
        } else {
            nthFibonacci = fibonacci(n - 1) + fibonacci(n - 2);
            //System.out.println(n + " number of fibonacci is " + nthFibonacci);
            return nthFibonacci;
        }
    }
}
