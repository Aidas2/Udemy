package com.udemy.section14.io.example06_RandomAccessFile;

import java.io.*;
import java.util.*;

/**
 ATTENTION: to SUCCESSFULLY run main(), code below in static{} at first must be "old" (from previous example).
 Only later comment "old" code an uncomment (or write) "new" code.
 If do not doing so this example will NOT work (due serialization, because copied file location.dat contains package name with "example05" (must be "example06")

 If you forgot that or made mistake, you should'n start all from zero, just comment new reader, uncomment old (watch for package names !!!), after run return comments back :)

 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {

/*        // "old" writer
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFile\\txt\\locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
*/
        // "new" writer (works only with "old" reader). rwd (read write d...) is a good practise (when using multi thread)
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

/*        // "old" reader (from previous example)
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
*/
        // "new" reader
        try {
            ra = new RandomAccessFile("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFile\\txt\\locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }
        } catch (IOException e) {
            System.out.println("IOException in static initializer " + e.getMessage());
        }

    }

    public Location getLocation (int locationId) throws IOException {

        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location =  new Location(locationId, description, null);

        if(locationId != 0) {
            for(int i =0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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

    public void close() throws IOException {
        ra.close();
    }

}
