package com.udemy.Ex34;

public class Main {

    public static void main(String[] args) {

        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);

        one.add(1, 1);
        System.out.println("one.real = " + one.getReal());
        System.out.println("one.imaginary = " + one.getImaginary());
        System.out.println();

        one.subtract(number);
        System.out.println("one.real = " + one.getReal());
        System.out.println("one.imaginary = " + one.getImaginary());
        System.out.println();

        number.subtract(one);
        System.out.println("one.real = " + number.getReal());
        System.out.println("one.imaginary = " + number.getImaginary());

    }
}
