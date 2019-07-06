package com.udemy.section06.excercises_29_36.Ex29;

public class Ex29_SimpleCalculator {


    private double firstNumber;
    private double secondNumber;


    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getAdditionResult () {
        return firstNumber + secondNumber;
    }

    public double getSubtractionResult() {
        return firstNumber - secondNumber;
    }

    public double getMultiplicationResult () {
        return firstNumber * secondNumber;
    }

    public double getDivisionResult () {
        if (secondNumber == 0) {
            return 0;
        } else {
            return firstNumber / secondNumber;
        }
    }







// this should go to com.udemy.Ex30.Main class and/or psvm method:

    Ex29_SimpleCalculator calculator = new Ex29_SimpleCalculator();

    //calculator.setFirstNumber(5.0);



}
