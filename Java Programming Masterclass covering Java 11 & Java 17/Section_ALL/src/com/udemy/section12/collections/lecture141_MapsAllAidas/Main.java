package com.udemy.section12.collections.lecture141_MapsAllAidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Adelide", 8, 20);

        //Lecture 135, 136:

        //theatre.getSeats();

//        if (theatre.reserveSeat("D21")) {
//            System.out.println("Please pay for reservation");
//        } else {
//            System.out.println("This seat is already reserved");
//        }
//
//        if (theatre.reserveSeat("D21")) {
//            System.out.println("Please pay for reservation");
//        } else {
//            System.out.println("This seat is already reserved");
//        }

        /*
        //Lecture 137:
        List<Seat> seatCopy = new ArrayList<>(theatre.seats); // shallow copy (contains reference to same object)
        printList(seatCopy);

        seatCopy.get(1).reserve(); //get(1) is "A02"
        if (theatre.reserveSeat("A02")) {
            System.out.println(" Please pay for A02");
        } else {
            System.out.println("This seat is already reserved");
        }

        //collections.reverse(seatCopy);
        collections.shuffle(seatCopy);
        System.out.println("printing seatCopy");
        printList(seatCopy);
        System.out.println("printing theatre.seat");
        printList(theatre.seats);

        Seat minSeat = collections.min(seatCopy);
        Seat maxSeat = collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber() + "\n" + "Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy );

//        List<Seat> newList = new ArrayList<>(theatre.seats.size());
//        collections.copy(newList, theatre.seats);
*/


        //Lecture 138:

        if (theatre.reserveSeat("D20")) {
            System.out.println("Please pay for reservation");
        } else {
            System.out.println("This seat is already reserved");
        }

        if (theatre.reserveSeat("D21")) {
            System.out.println("Please pay for reservation");
        } else {
            System.out.println("This seat is already reserved");
        }
        if (theatre.reserveSeat("D21")) {
            System.out.println("Please pay for reservation");
        } else {
            System.out.println("This seat is already reserved");
        }

        List<Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);


        List<Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(new Seat("B00", 13.00));
        priceSeats.add(new Seat("A00", 13.00));
        Collections.sort(priceSeats, Seat.PRICE_ORDER);
        printList(priceSeats);






    }

    public static void printList(List<Seat> list) {
        for (Seat s : list) {
            //System.out.print(" " + s.getSeatNumber()); //Lecture 137?
            System.out.print(" " + s.getSeatNumber() + " $" + s.getPrice()); //Lecture 138
        }
        System.out.println();
        System.out.println("=========================================");
    }


    public static void sortList(List<? extends Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }

    }
}
