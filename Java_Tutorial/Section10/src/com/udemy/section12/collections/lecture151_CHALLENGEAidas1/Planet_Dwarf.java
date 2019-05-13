package com.udemy.section12.collections.lecture151_CHALLENGEAidas1;

public class Planet_Dwarf extends HeavenlyBody{

    public Planet_Dwarf(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.DWARF_PLANET);
    }

//    @Override //does dwarf planet doesn't have moons ?
//    public boolean addSatellite(HeavenlyBody moon) {
//        if(moon.getKey().getBodyType() == BodyType.MOON) {
//            return super.addSatellite(moon);
//        } else {
//            System.out.println("you can add only bodyType --> moon");
//            return false;
//        }
//    }

}
