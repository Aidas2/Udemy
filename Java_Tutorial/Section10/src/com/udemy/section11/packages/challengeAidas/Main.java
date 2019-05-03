package com.udemy.section11.packages.challengeAidas;

import com.udemy.section11.packages.Series;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        System.out.print("Sum: ");
        for(int i=1; i <=11; i++) {
            System.out.print(Series.nSum(i) + ", ");
        }

        System.out.println();
        Series.nSum2(10);

        System.out.println();
        System.out.print("Factorial: ");
        for(int i=0; i <=10; i++) {
            System.out.print(Series.factorial(i) + ", ");
        }

        System.out.println();
        System.out.print("Fibonacci: ");
        for(int i=0; i <=10; i++) {
            System.out.print(Series.fibonacci(i) + ", ");
        }
    }

}
