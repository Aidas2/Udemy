package com.udemy.section14.io.example05_ObjectIOStreamREAL;

import java.io.*;
import java.util.*;

/**
 ATTENTION: to SUCCESSFULLY run main(), code below in static{} at first must be "old" (from previous JTransforms).
 Only later comment "old" code an uncomment (or write) "new" code.

 If you forgot that or made mistake, you should'n start all from zero, just comment new reader, uncomment old (watch for package names !!!), after run return comments back :)

 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
/*      // "old" writer (from previous JTransforms)
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/aidas/Documents/Udemy_etc/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example04_ByteStreams/txt/locations.dat")))) {
            for (com.udemy.section14.io.example04_ByteStreams.Location location : locations.values()) {
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
*/
        // "new" writer (works only with "old" reader)
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example05_ObjectIOStreamREAL\\txt\\locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    static {

/*      // "old" reader (from previous JTransforms)
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example05_ObjectIOStreamREAL\\txt\\locations.dat")))) {
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
*/
        // "new" reader
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example05_ObjectIOStreamREAL\\txt\\locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location: " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassExeption " + e.getMessage());
        } catch (IOException io) {
            System.out.println("IO Exeption " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException" + e.getMessage());
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
