package com.udemy.section05.excercises_12_28;

public class Ex26_DiagonalStar {

    public static void main(String[] args) {
        printSquareStar(7);
        System.out.println("=====================");
        printSquareStar2(7);

    }

    // i is for rows; j is for columns;
    //System.out.println() must be after second for but inside first for

    public static void printSquareStar (int number) {
        if (number < 5 ) {
            System.out.println("Invalid Value");
        } else {


            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (i == 0 || i == number-1 || j == 0 || j == number-1 || i == j || j == number - i - 1 ) {
                        System.out.print("*  ");
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
        }
    }


    //==================================== example from Udemy.com
    public static void printSquareStar2(int number){
        if(number<5){
            System.out.println("Invalid Value");
        } else {
            for(int i= 1; i<= number; i++){
                for(int j=1; j<= number;j++){
                    if(i==1 || j==1 || i==j || i==number || j==number || i== number-j+1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }




}



