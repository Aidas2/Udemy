package com.udemy.section14.io.example04_ByteStreams;

//import sun.tools.tree.InstanceOfExpression;

import java.io.*;
import java.util.*;

/**
 ATTENTION: to SUCCESSFULLY run main(), code below in static{} at first must be "old" (from previous example).
 Only later comment "old" code an uncomment (or write) "new" code.

 If you forgot that or made mistake, you should'n start all from zero, just comment new reader, uncomment old (watch for package names !!!), after run return comments back :)

 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
//======================================================================================================================
        // === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING === WRITING
        // =============================================================================================================
/*      // "old" writer
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
 */
        //"new" writer; works only with "old" reader (as in example 03, line 53)
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example04_ByteStreams/txt/locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    //======================================================================================================================
    // === READING === READING === READING === READING === READING === READING === READING === READING === READING ===
    //version "try WITH resources" =====================================================================================
    static {
/*      // "old" reader (from previous example)
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
*/
        // "new" reader
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example04_ByteStreams/txt/locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));

                } catch (EOFException e) {
                    eof = true;
                }

            }
        } catch (IOException io) {
            System.out.println("IO Exception");
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
