package com.udemy.section12.collections.lecture142_CHALLENGEAidas;

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

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));


        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
//        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
//        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
//        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
//        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
//        locations.get(5).addExit("Q", 0);

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
                //System.out.println("directions " + direction + ", loc " + loc);
            } else {
                System.out.println("You cannot go in that direction");
            }

            //loc = scanner.nextInt();
//            if(!locations.containsKey(loc)) {
//                System.out.println("You cannot go in that direction ");
//            }

        }





    }
}
