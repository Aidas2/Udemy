package com.udemy.section06.excercises_29_36.Ex33;

public class Floor {

    private double width;
    private double length;

    // version_01. validating in setters and later this setters is used in constructor
    /*
    public Floor(double width, double length) {
        setWidth(width);
        setLength(length);
    }

    public double getArea () {
        return this.width * this.length;
    }



    public void setWidth(double width) {
        if (width < 0) {
            this.width =0;
        } else {
            this.width = width;
        }
    }

    public void setLength(double length) {
        if (length < 0) {
            this.length =0;
        } else {
            this.length = length;
        }
    }
    */

    // version_02. Only one method (as requires)
    public Floor(double width, double length) {
        if (width < 0) {
            this.width =0;
        } else {
            this.width = width;
        }
        if (length < 0) {
            this.length =0;
        } else {
            this.length = length;
        }
    }

    public double getArea () {
        return this.width * this.length;
    }

}
