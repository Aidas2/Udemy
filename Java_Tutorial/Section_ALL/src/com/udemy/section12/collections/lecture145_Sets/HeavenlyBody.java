package com.udemy.section12.collections.lecture145_Sets;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalperiod;
    private final Set<HeavenlyBody> satelites;

    public HeavenlyBody(String name, double orbitalperiod) {
        this.name = name;
        this.orbitalperiod = orbitalperiod;
        this.satelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalperiod() {
        return orbitalperiod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satelites.add(moon);
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites); //returning not original, but copy
    }

    //Lecture 146 (equals() and hashCode()):
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    //Lecture 147 (equals() and hashCode()):
    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }
}


