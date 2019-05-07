package com.udemy.section12.challengeAidas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Theatre {
    private  String theatreName;
    private  int numberOfRows;
    private  int seatPerRow;
    //public List<Seat> seats = new ArrayList<>(); //just for Lesson 137
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numberOfRows, int seatPerRow) {
        this.theatreName = theatreName;
        this.numberOfRows = numberOfRows;
        this.seatPerRow = seatPerRow;

        int lastRow = 'A' + (numberOfRows - 1); // (65 + (8 - 1) = 72) = H;
        //int lastRow = 65 + (numberOfRows - 1); // firstRow 'A' = 65;
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNumber = 1; seatNumber <= seatPerRow; seatNumber++) {

                //Lesson 138:
                double price = 12.00;
                if (row < 'D' && (seatNumber >= 4 && seatNumber <= 16)) {
                    price = 14.00;
                } else if (row > 'F' || (seatNumber >= 4 && seatNumber <= 16)){
                    price = 7.00;
                }

                //Seat seat = new Seat(row + String.format("%02d", seatNumber));
                Seat seat = new Seat(row + String.format("%02d", seatNumber), price); //Lesson 138
                seats.add(seat);
            }
        }

    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat (String seatNumber) {
        //Lesson 135:
//        Seat requestedSeat = null;
//        for(Seat s: seats) {
//            System.out.print(".");
//            if(s.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = s;
//                break;
//            }
//        }
//        if(requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
        //return true;
//        return requestedSeat.reserve();

        //Lesson 136:
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    //Lesson 135
    // for testing (because Seat class is private)
//    public void getSeats() {
//        System.out.println("There are " + seats.size() + " seats in " + theatreName + " theatre: ");
//        for(Seat s: seats) {
//            System.out.println(s.getSeatNumber());
//        }
//    }

    //Lesson 138
    public Collection<Seat> getSeats() {
        return seats;

    }

}

