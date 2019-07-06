package com.udemy.section14.io.example04_ByteStreams;

//import sun.tools.tree.InstanceOfExpression;


import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
//======================================================================================================================
        // === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING
        // =============================================================================================================
        //version "try WITH resources" =================================================================================
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example03_BufferedWriter/txt/locations.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example03_BufferedWriter/txt/directions.txt"))) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
    }

    //======================================================================================================================
    // === READING === READING === READING === READING === READING === READING === READING === READING === READING ===
    //version "try WITH resources" =====================================================================================
    static {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example03_BufferedWriter/txt/locations_big.txt")))) {
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
        try (BufferedReader dirFile = new BufferedReader(new FileReader("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example03_BufferedWriter/txt/directions_big.txt"))) {
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

    }

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
