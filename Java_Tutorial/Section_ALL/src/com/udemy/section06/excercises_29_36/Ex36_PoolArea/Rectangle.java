package com.udemy.section06.excercises_29_36.Ex36_PoolArea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rectangle {

    final Logger logger = LoggerFactory.getLogger(Main.class);

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
        if (length < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
        logger.info("Rectangle parameters is set");
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return this.width * this.length;
    }
}


