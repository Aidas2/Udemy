package com.udemy.section12.collections.lecture141_MapsAllAidas;

import java.util.Comparator;

public class Seat implements Comparable<Seat> {
    private final String seatNumber;
    private double price;
    private boolean reserved = false;


    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    } // Lesson 135

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    } //Lesson 138

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
        @Override //comparator for Lesson 136:
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

    //comparator for Lesson 138
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;

            } else if ((seat1.getPrice() > seat2.getPrice())) {
                return 1;
            } else {
                return 0;
            }
        }
    };




    public boolean reserve() {
        if (!this.reserved) {
            this.reserved = true;
            System.out.println("Class Seat. Seat " + seatNumber + " has been reserved");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel() {
        if (this.reserved) {
            this.reserved = false;
            System.out.println("Class Seat. Seat " + seatNumber + " reservation has been canceled");
            return true;
        } else {
            return false;
        }
    }


}
