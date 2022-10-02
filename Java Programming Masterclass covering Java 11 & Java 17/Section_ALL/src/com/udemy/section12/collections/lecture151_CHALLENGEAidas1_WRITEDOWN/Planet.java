package com.udemy.section12.collections.lecture151_CHALLENGEAidas1_WRITEDOWN;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        //if(moon.getBodyType() == BodyType.MOON) {
        if(moon.getKey().getBodyType() == BodyType.MOON) {
            return super.addSatellite(moon);
        } else {
            System.out.println("you can add only bodyType --> moon");
            return false;
        }
    }
}
