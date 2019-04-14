package com.udemy.compositionChallenge;

public class Room {

    private Table table;
    private Tv tv;
    private Window window;


    public Room(Table table, Tv tv, Window window) {
        this.table = table;
        this.tv = tv;
        this.window = window;
    }

    public Table getTable() {
        return table;
    }

    public Tv getTv() {
        return tv;
    }

    public Window getWindow() {
        return window;
    }

}
