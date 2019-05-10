package com.udemy.section12.collections.lecture144_CHALLENGEAidas;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        //this.exits = new HashMap<String, Integer>(); //not immutable :(
        //this.exits = exits; // almost immutable ...
        //this.exits = new HashMap<>(exits); //immutable :) ! But crash if null is passed ir Main, so we need that check:
        if(exits != null) {
            this.exits = new HashMap<>(exits);  //map with data
        } else {
            this.exits = new HashMap<>();       //map without data (empty map)
        }
        this.exits.put("Q", 0);
    }

//    public void addExit (String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //return exits;             // returns original map
        return new HashMap<>(exits); //reason of creating new map (e.a. just copy of original map, that nobody can access/modify original map)
    }
}
