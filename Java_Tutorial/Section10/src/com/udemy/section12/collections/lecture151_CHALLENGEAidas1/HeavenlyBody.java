package com.udemy.section12.collections.lecture151_CHALLENGEAidas1;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
//    private final String name;
    private final Key key;
    private final double orbitalPeriod;
//    private final BodyType bodyType;
    private final Set<HeavenlyBody> satellites;

    public enum BodyType {
        STAR, PLANET, DWARF_PLANET, MOON, COMET,  ASTEROID
    }
//version original:
//    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
//        this.name = name;
//        this.orbitalPeriod = orbitalPeriod;
//        this.bodyType = bodyType;
//        this.satellites = new HashSet<>();
//    }
// version with Key:
    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }
//    public String getName() {
//        return name;
//    } //not necessary after introduction of Key class

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public BodyType getBodyType() {
//        return bodyType;
//    } //not necessary after introduction of Key class


    public Key getKey() {
        return key;
    } //necessary after introduction of Key class

    public boolean addSatellite(HeavenlyBody moon) {
            return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites); //returning not original, but copy
    }

    //Lecture 146 (equals() and hashCode()):
    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
//version original:
//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("this.getClass() is " + this.getClass());
//        if((obj == null) || (obj.getClass() != this.getClass())) {
//            return false;
//        }
//version 2:
//        if(obj instanceof HeavenlyBody) {
//            HeavenlyBody theObject = (HeavenlyBody) obj;
//            if(this.name.equals(theObject.getName())) {
//                return this.bodyType == theObject.getBodyType();
//            }
//        }
//version 3 (with Key):
        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
//version original:
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);
//version 2:
        return  false;
    }

    //Lecture 147 (equals() and hashCode()):
    @Override
    public final int hashCode() {
        //return this.name.hashCode() + 57; //version original
        //return this.name.hashCode() + 57 + this.bodyType.hashCode(); //version 2
        return this.key.hashCode(); //version 3 (with Key)
    }

    public static Key makeKey(String name, BodyType bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        //return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod; //before Key
        return this.key.getName() + ": " + this.key.getBodyType() + ", " + this.orbitalPeriod + " (from HB class)"; //after Key

    }
//===============================================================================
    public static final class Key {
        private String name;
        private BodyType bodyType;

    private Key(String name, BodyType bodyType) {
        this.name = name;
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Key key = (Key) obj;
        if(this.name.equals((key.getName()))) {
            return (this.bodyType == key.getBodyType());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + " (from Key class)";
    }
}

}


