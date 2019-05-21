package com.udemy.section08.arrays.LinkedArrayList.Ex101_LinkedArrayChallenge;

public class Song {
    private String name;
    private double duration;

    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + this.name + '\'' +
                ", duration=" + this.duration +
                '}';
    }
}
