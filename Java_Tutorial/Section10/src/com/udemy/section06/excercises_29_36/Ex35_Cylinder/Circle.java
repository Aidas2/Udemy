package com.udemy.section06.excercises_29_36.Ex35_Cylinder;

public class Circle {

    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            this.radius = 0;
        } else {
            this.radius = radius;
        }

        //setRadius(radius);
    }

    public double getArea () {
        return getRadius() * getRadius() * Math.PI;
    }


    public double getRadius() {
        return radius;
    }

//    public void setRadius(double radius) {
//        if (radius < 0) {
//            this.radius = 0;
//        } else {
//            this.radius = radius;
//        }
//    }
}
