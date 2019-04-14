package com.udemy.WMasterChallenge2;

public class DeluxeHamburger2 extends Hamburger2{

    public DeluxeHamburger2(/*String name, String breadRollType, String meat, double basePrice*/) {
        super("Deluxe", "Full Grain", "Young Lamb", 15);
        super.addAddition1("Chips", 2.5);
        super.addAddition2("Drink", 2.5);
    }

    @Override
    public void addAddition1(String additionName, double additionPrice) {
        //super.addAddition1(additionName, additionPrice);
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addAddition2(String additionName, double additionPrice) {
        //super.addAddition2(additionName, additionPrice);
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addAddition3(String additionName, double additionPrice) {
        //super.addAddition3(additionName, additionPrice);
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addAddition4(String additionName, double additionPrice) {
        //super.addAddition4(additionName, additionPrice);
        System.out.println("Cannot not add additional items to a deluxe burger");
    }
}




