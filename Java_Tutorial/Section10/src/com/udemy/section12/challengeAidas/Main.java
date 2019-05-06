package com.udemy.section12.challengeAidas;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Adelide", 8, 20);
        //theatre.getSeats();

        if(theatre.reserveSeat("H11")) {
            System.out.println("Please pay for reservation");
        } else {
            System.out.println("This seat is already reserved");
        }

        if(theatre.reserveSeat("H11")) {
            System.out.println("Please pay for reservation");
        } else {
            System.out.println("This seat is already reserved");
        }

        notString("not bitch");
        notString("bitch");

    }

//    public static String notString(String str) {
//        if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
//            return str;
//        } else {
//            return "not " + str;
//        }
//    }

    public static String notString(String str) {
        if(str.length() >=3 && str.substring(0, 4).equals("not ")) {
            System.out.println(str.length());
            System.out.println(str.substring(0, 5));
            System.out.println(str);
            return str;
        } else {
            System.out.println("really not " + str + " ?");
            return str;
        }

    }
}
