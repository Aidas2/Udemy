package com.udemy.section06.excercises_29_36.Ex32;

public class Ex32_Point {

    private int x;
    private int y;

    public Ex32_Point() {
    }

    public Ex32_Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // no good, duplicated code, you should use overloaded method !
/*
    public double distance () {
        com.udemy.Ex32.Ex32_Point point1 = new com.udemy.Ex32.Ex32_Point(0,0);
        return Math.sqrt((this.x - point1.getX()) * (this.x - point1.getX()) + (this.y - point1.getY()) * (this.y - point1.getY()));
    }

    public double distance (int x, int y) {
        com.udemy.Ex32.Ex32_Point point2 = new com.udemy.Ex32.Ex32_Point(x, y);
        return Math.sqrt((this.x - point2.getX()) * (this.x - point2.getX()) + (this.y - point2.getY()) * (this.y - point2.getY()));
    }


    public double distance (com.udemy.Ex32.Ex32_Point point3) {
        return Math.sqrt((this.x - point3.getX()) * (this.x - point3.getX()) + (this.y - point3.getY()) * (this.y - point3.getY()));
    }
*/
    //Task 2 (without this it is impossible to write overloaded methods)
    public double distance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    //Task 1. overloaded method (uses method from Task 1, which has arguments);
    public double distance() {
        return distance(0, 0);
    }

    //Task 3. overloaded method (uses method from Task 1, which has arguments);
    public double distance (Ex32_Point point) {
        return distance(point.getX(), point.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
