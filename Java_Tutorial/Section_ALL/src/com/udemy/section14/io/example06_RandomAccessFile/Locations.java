package com.udemy.section14.io.example06_RandomAccessFile;

import java.io.*;
import java.util.*;

/**
 ATTENTION: to SUCCESSFULLY run main(), code below in static{} at first must be "old" (from previous example).
 Only later comment "old" code an uncomment (or write) "new" code.
 If do not doing so this example will NOT work (due serialization, because copied file location.dat contains package name with "example05" (must be "example06")
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
/*      // "old" writer (from previous example)
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/aidas/Documents/Udemy/Java_Tutorial/Section_ALL/src/com/udemy/section14/io/example04_ByteStreams/txt/locations.dat")))) {
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
/*        // "new" writer (works only with "old" reader)
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFile\\txt\\locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
*/
        // "newest" writer. rwd is a good practise (when using multi thread)
        try (RandomAccessFile rao = new RandomAccessFile("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFile\\txt\\locations_rand.dat", "rwd")) {
            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationsStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationsStart);

            long indexStart = rao.getFilePointer(); //offset

            int startPointer = locationsStart;
            rao.seek(startPointer);

            for( Location location : locations.values()) {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                        //direction, locationId, direction, locationId
                        //N,1,U,2
                    }
                }
                rao.writeUTF((builder.toString()));

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer)); //(start, length)
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart); //seeking offset
            for(Integer locationID : index.keySet()){
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }

        }

    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long.  It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700



    static {

/*      // "old" reader (from previous example)
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFile\\txt\\locations.dat")))) {
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
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFile\\txt\\locations.dat")))) {
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
