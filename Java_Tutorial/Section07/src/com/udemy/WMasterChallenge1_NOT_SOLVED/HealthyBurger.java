package com.udemy.WMasterChallenge1_NOT_SOLVED;

public class HealthyBurger extends Hamburger {

//    @Override
//    private int additionMaxCount = 6;

    public HealthyBurger(String name, String meat, double basePrice) {
        super(name, "brown rye", meat, basePrice);
    }


    @Override
    public void addAddition(String addition, double additionQuantity, double additionPrice) {
        super.addAddition(addition, additionQuantity, additionPrice);
        int additionMaxCount = 6;
    }
}
