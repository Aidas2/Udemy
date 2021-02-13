package com.coderbyte;

import java.util.ArrayList;
import java.util.HashMap;

public class FindIntersection {

    public static String FindIntersection(String[] strArr) {
//        ArrayList[] lists = strArr.map(str => str.split(", "));
        String[] firstList = strArr[0].split(", ");
        String[] secondList = strArr[1].split(", ");

        HashMap matchMap = new HashMap();
        ArrayList resultArray = new ArrayList();

//        for (String number : firstList) {
//            matchMap.put(number);
//        }
//        firstList


        return strArr[0];
    }

    public static void main (String[] args) {
        // keep this function call here
//        Scanner s = new Scanner(System.in);
//        System.out.print(FindIntersection(s.nextLine()));
    }
}
