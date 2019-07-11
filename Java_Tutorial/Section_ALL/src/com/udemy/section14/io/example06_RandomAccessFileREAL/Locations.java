package com.udemy.section14.io.example06_RandomAccessFileREAL;

import java.io.*;
import java.util.*;

/**
 * ATTENTION: this example NOT working (due serialization, because copied file location.dat contains package name with "example05").
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
/*
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFileREAL\\txt\\locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
 */
        try (RandomAccessFile rao = new RandomAccessFile("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFileREAL\\txt\\locations_rand.dat", "rwd")) {
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

    static {

        try {
            ra = new RandomAccessFile("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFileREAL\\txt\\locations.dat", "rwd");
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

//        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example06_RandomAccessFileREAL\\txt\\locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location: " + location.getLocationID() + " : " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() + " exits");
//
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        } catch (InvalidClassException e) {
//            System.out.println("InvalidClassExeption " + e.getMessage());
//        } catch (IOException io) {
//            System.out.println("IO Exeption " + io.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.out.println("ClassNotFoundException" + e.getMessage());
//        }
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
