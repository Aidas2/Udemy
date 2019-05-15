package com.udemy.section12.collections.lecture151_CHALLENGEAidas2_UNSOLVED;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final BodyType bodyType;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

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

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if(this.name.equals(theObject.getName())) {
                return this.bodyType == theObject.getBodyType(); //true
            }
        }
        return false;
    }

    //Lecture 147 (equals() and hashCode()):
    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getBodyType() + ", " + this.orbitalPeriod + " <--HB";
    }
}


