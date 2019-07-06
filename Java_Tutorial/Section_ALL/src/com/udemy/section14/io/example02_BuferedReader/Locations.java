package com.udemy.section14.io.example02_BuferedReader;

//import sun.tools.tree.InstanceOfExpression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
//======================================================================================================================
        // === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING
        // =============================================================================================================
        //version "try WITH resources" =================================================================================
        try (FileWriter locFile = new FileWriter("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/locations.txt");
             FileWriter dirFile = new FileWriter("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/directions.txt")) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }

        //version "try WITHOUT resources" ==============================================================================
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        } finally {
//            System.out.println("in finally block");
//            if (locFile != null) {
//                System.out.println("Attempting to close locfile");
//                locFile.close();
//            }
//        }
    }

    //======================================================================================================================
    // === READING === READING === READING === READING === READING === READING === READING === READING === READING ===
    //version "try WITH resources" =====================================================================================
    static {
        try (Scanner scanner = new Scanner(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/locations_big.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<String, Integer>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //version WITHOUT scanner
        try (BufferedReader dirFile = new BufferedReader(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/directions_big.txt"))) {
            String input;
            while ((input = dirFile.readLine()) != null) {

                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        //version WITH scanner
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/directions_big.txt")))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextInt()) {

                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }
/*
    //version "try WITHOUT resources" ==============================================================================
    static {

        Scanner scanner = null;
        try {
//            scanner = new Scanner(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/locations.txt"));
            scanner = new Scanner(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/locations_big.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<String, Integer>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //Now read the exits
        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/directions.txt")));
            scanner = new Scanner(new BufferedReader(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example02_BuferedReader/txt/directions_big.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextInt()) {

                //version then reading word by word (splitting with delimiters)"
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);

                //version then reading line by line (or, splitting into lines):
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);


                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));

    }
 */

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
