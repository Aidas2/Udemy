package com.udemy.section12.collections.lecture148_Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainSet {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i = 1; i<= 100; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements"); //196

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements"); //4

        for(int i : intersection) {
            System.out.println(i + " is square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i)); //64 this is square of 8.0 and the cube of 4.0
        }

        System.out.println("========================================================================");

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for(String s : words) {
            System.out.println(s);
        }

        System.out.println("========================================================================");

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] arrayNatureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(arrayNatureWords));
        String[] arrayDivineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(arrayDivineWords));

        System.out.println("Asymmetric difference");
        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        System.out.println("========================================================================");

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        System.out.println("========================================================================");

        if(nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of nature");
        }

        if(divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine");
        }




    }

    private static void printSet (Set<String> set) {
        System.out.print("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
