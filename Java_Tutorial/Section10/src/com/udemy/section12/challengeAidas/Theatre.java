package com.udemy.section12.challengeAidas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Theatre {
    private  String theatreName;
    private  int numberOfRows;
    private  int seatPerRow;
    private Collection<Seat> seats = new LinkedHashSet<>();

    public Theatre(String theatreName, int numberOfRows, int seatPerRow) {
        this.theatreName = theatreName;
        this.numberOfRows = numberOfRows;
        this.seatPerRow = seatPerRow;

        int lastRow = 'A' + (numberOfRows - 1); // (65 + (8 - 1) = 72) = H;
        //int lastRow = 65 + (numberOfRows - 1); // firstRow 'A' = 65;
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNumber = 1; seatNumber <= seatPerRow; seatNumber++) {
                Seat seat = new Seat(row + String.format("%02d", seatNumber));
                seats.add(seat);
            }
        }

    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat (String seatNumber) {
        Seat requestedSeat = null;
        for(Seat s: seats) {
            if(s.getSeatNumber().equals(seatNumber)) {
                requestedSeat = s;
                break;
            }
        }

        if(requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        //return true;
        return requestedSeat.reserve();
    }

    public void getSeats() {
        System.out.println("There are " + seats.size() + " seats in " + theatreName + " theatre: ");
        for(Seat s: seats) {
            System.out.println(s.getSeatNumber());
        }
    }


}

