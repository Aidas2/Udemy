package com.udemy.section12.collections.lecture151_CHALLENGEAidas2_UNSOLVED;

public class Asteroid extends HeavenlyBody {
    public Asteroid(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.ASTEROID);
    }

    @Override
    public String toString() {
        return this.getName() + " this text is from override";
    }
}
