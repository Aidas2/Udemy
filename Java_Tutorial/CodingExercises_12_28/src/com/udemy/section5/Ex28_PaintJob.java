package com.udemy.section5;

public class Ex28_PaintJob {

    public static void main(String[] args) {

        getBucketCount(-3.4, 2.1, 1.5, 2);
        System.out.println("================================================");
        getBucketCount(3.4, 2.1, 1.5, 2);
        System.out.println("================================================");
        getBucketCount(2.75, 3.25, 2.5, 1);

        System.out.println();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        getBucketCount(-3.4, 2.1, 1.5);
        System.out.println("================================================");
        getBucketCount(3.4, 2.1, 1.5);
        System.out.println("================================================");
        getBucketCount(7.25, 4.3, 2.35);

        System.out.println();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        getBucketCount(3.4, 1.5);
        System.out.println("================================================");
        getBucketCount(6.26, 2.2);
        System.out.println("================================================");
        getBucketCount(3.26, 0.75);
    }


    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBucket) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBucket < 0) {
//            System.out.println("Invalid Value");
            return -1;
        } else {
            double areaOfWall = width * height;

            double countRequiredBuckets = areaOfWall / areaPerBucket;

            int countMissingBuckets = (int) Math.ceil(countRequiredBuckets - extraBucket);


//            System.out.println("Area of wall: " + areaOfWall);
//            System.out.println("Count of required buckets: " + areaOfWall + " : " + areaPerBucket + " = " + countRequiredBuckets);
//            System.out.println("Count of missing buckets: " + countRequiredBuckets + " - " + extraBucket + " = " + countMissingBuckets);

            return countMissingBuckets;
        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {

        int countMissingBuckets2 = getBucketCount(width, height, areaPerBucket, 0);
        return countMissingBuckets2;
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0) {
//            System.out.println("Invalid Value");
            return -1;
        } else {
            double countRequiredBuckets = area / areaPerBucket;

            int countMissingBuckets3 = (int) Math.ceil(countRequiredBuckets);

//            System.out.println("Count of required buckets: " + area + " : " + areaPerBucket + " = " + countRequiredBuckets);
//            System.out.println("Count of required buckets (int): " + countMissingBuckets3);

            return countMissingBuckets3;
        }
    }
}
