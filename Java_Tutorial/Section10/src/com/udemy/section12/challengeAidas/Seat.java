package com.udemy.section12.challengeAidas;

public class Seat {
    private final String seatNumber;
    public boolean reserved = false;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

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
