package com.udemy.section07.composition.compositionChallenge;

public class Main {

    public static void main(String[] args) {

        Table table = new Table(4, 90, "wood");

        Monitor monitor = new Monitor("China", 27);
        Tv tv = new Tv(monitor, "LG758", "LG");

        Glass glass = new Glass(15, 25, "sand", "blue");
        Window window = new Window(glass, 3, 2);

        Room room = new Room(table, tv, window);

        room.getTable().increaseDecrease();
        room.getTv().entertineMe();
        room.getWindow().getFreshAir();

        //window.getFreshAir();

    }

}
