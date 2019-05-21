package com.udemy.section07.composition.WMasterChallenge2;

public class HealthyBurger2 extends Hamburger2 {

    private String additionName5;
    private double additionPrice5;

    private String additionName6;
    private double additionPrice6;

    public HealthyBurger2(String meat, double basePrice) {
        super("Sveikuoliskas", "brown rye", meat, basePrice);
    }

    public void addAddition5 (String additionName, double additionPrice) {
        this.additionName5 = additionName;
        this.additionPrice5 = additionPrice;
        super.additionTotalPrice += this.additionPrice5;
        System.out.println("Added " + this.additionName5 + " for extra " + this.additionPrice5);
    }

    public void addAddition6 (String additionName, double additionPrice) {
        this.additionName6 = additionName;
        this.additionPrice6 = additionPrice;
        super.additionTotalPrice += this.additionPrice6;
        System.out.println("Added " + this.additionName6 + " for extra " + this.additionPrice6);
    }

//    @Override
//    public void countAdditions() {
//        super.countAdditions();
//    }
}
