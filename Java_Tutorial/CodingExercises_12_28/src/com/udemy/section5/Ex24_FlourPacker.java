package com.udemy.section5;

public class Ex24_FlourPacker {

    public static void main(String[] args) {

        boolean fullPacks = canPack(2, 10, 18);
        System.out.println(fullPacks);

    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int sum = bigCount * 5 + smallCount * 1;

        int minimalCountOfBigBagsToFillPackage = goal / 5;
        int minimalCountOFSmallBagsLeftAfterMinimalBigBags = goal % 5;

        int minimalCountOFSmallBagsLeftAfterGivenBigBags = goal - bigCount * 5;

        //int minimalCountOfSmallBagsToFillPackage = goal / 1;


        System.out.println("min Big:" + minimalCountOfBigBagsToFillPackage);
        System.out.println("min Small after min Big: " + minimalCountOFSmallBagsLeftAfterMinimalBigBags);
        System.out.println("min Small after given Big: " + minimalCountOFSmallBagsLeftAfterGivenBigBags);

        if (sum >= goal) {
            if ((bigCount >= minimalCountOfBigBagsToFillPackage && smallCount >= minimalCountOFSmallBagsLeftAfterMinimalBigBags) ||
                    //(smallCount >= minimalCountOfSmallBagsToFillPackage) ||
                    (bigCount <= minimalCountOfBigBagsToFillPackage && smallCount >= minimalCountOFSmallBagsLeftAfterGivenBigBags)
            )
            {
                return true;
            } else return false;
        }
        return false;
    }

}
