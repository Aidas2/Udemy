package com.udemy.section12.collections.lecture144_CHALLENGEAidas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Change the program to allow players to type full words, or phrases, then move to the
// correct location based upon their input.
// The player should be able to type commands such as "Go West", "run South", or just "East"
// and the program will move to the appropriate location if there is one.  As at present, an
// attempt to move in an invalid direction should print a message and remain in the same place.
//
// Single letter commands (N, W, S, E, Q) should still be available.

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));

        //=========================================================
        //SOLUTION. Step 1. Create map (intending that inputed word will be a map key, witch will return a letter as map value)
        Map<String, String> allowedWords = new HashMap<>();
        allowedWords.put("QUIT", "Q");
        allowedWords.put("NORTH", "N");
        allowedWords.put("SOUTH", "S");
        allowedWords.put("WEST", "W");
        allowedWords.put("EAST", "E");
        //=========================================================

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            tempExits.remove("S"); //just for immutability checking (cracking)
            if(loc == 0) {
                break;
            }

            Map<String, Integer> currentExits = locations.get(loc).getExits(); //exits just for CURRENT location
            System.out.print("Available curent exits are: ");
            for(String e : currentExits.keySet()) {
                System.out.print(e + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            //=========================================================
            //SOLUTION. Step 2. Comparing if map contains key equals to inputed word (not just comparing two strings !).
            // If contains, then getting value of that key (a letter) and assigning to direction;
            if(direction.length() > 1) {
                String [] inputedWords = direction.split(" ");
                for(String iw : inputedWords) {
                    if (allowedWords.containsKey(iw)) {
                        direction = allowedWords.get(iw);
                        break;
                    }
                }
            }

            if(currentExits.containsKey(direction)) {
                loc = currentExits.get(direction); // in map currentExit direction is key, get() gets value by this key
            } else {
                System.out.println("You cannot go in that direction");
            }

        }





    }
}
