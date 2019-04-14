package com.udemy.lecture17;

public class Main {

    public static void main(String[] args) {
	// write your code here

                byte myByteValue = 127;

                short myShortValue = 3000;

                int myIntValue = 32000;

                long myLongValue = 2_125_652_112L;

                long totalLong = myLongValue + 10 * (myByteValue + myShortValue + myIntValue);

                short totalShort = (short) (myLongValue + 10 * (myByteValue + myShortValue + myIntValue));

                System.out.println("totalLong: " + totalLong);  //2126003382

                System.out.println("totalShort: " + totalShort); //15542 what ???


            }
}
