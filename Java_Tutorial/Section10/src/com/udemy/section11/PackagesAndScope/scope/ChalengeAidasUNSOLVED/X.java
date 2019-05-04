package com.udemy.section11.PackagesAndScope.scope.ChalengeAidasUNSOLVED;

import java.util.Scanner;


//version 1:
/*
public class X {
    Scanner s = new Scanner(System.in);
    private int x;

    public void x (int x) {
        System.out.println("Enter the number: ");
        x = this.s.nextInt();
        this.s.nextLine();
        for ( this.x = 1; this.x <= 12; this.x++) {
            System.out.println(x + " x " + this.x + " = " + x*this.x);
        }
    }
}
*/

//version 2:
public class X {
    private int x;
    //static final int CONSTANTA = x.nextInt();

    public void x (Scanner x) {
        System.out.println("Enter number2: ");
//        x.nextInt();
//        x.nextLine();
        for(this.x = 2; this.x <= 12; this.x++) {
            System.out.println(this.x + " times " + x.nextInt() + x.nextLine() + " equals " + this.x * x.nextInt());
        }
    }



}