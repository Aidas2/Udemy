package com.udemy.section12.collections.lecture151_CHALLENGEAidas2UNSOLVED;

public class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getBodyType() == BodyType.MOON) {
            return super.addSatellite(moon);
        } else {
            System.out.println("Not added.");
            return false;
        }
    }

}
