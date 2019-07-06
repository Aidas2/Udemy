package com.udemy.section06.excercises_29_36.Ex31;

public class Ex31_Wall {

    public static void main(String[] args) {

        com.udemy.section06.excercises_29_36.Ex30.Account bobsAccount = new com.udemy.section06.excercises_29_36.Ex30.Account();
        Ex31_Wall wall01 = new Ex31_Wall();
        Ex31_Wall wall02 = new Ex31_Wall(-1.25, -1.25);

        System.out.println("area= " + wall02.getArea());
        //wall02.setHeight(-1.5);
        System.out.println("width= " + wall02.getWidth());
        System.out.println("height= " + wall02.getHeight());
        System.out.println("area= " + wall02.getArea());

    }


    private double width;
    private double height;

    //constructors
    public Ex31_Wall() {
    }

    public Ex31_Wall(double width, double height) {
        if (width < 0 ) {
            this.width = 0;
        } else {
            this.width = width;
        }

        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    //methods

    public double getArea() {
        return this.width * this.height;
    }

    //getters and setters
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
    }


}
