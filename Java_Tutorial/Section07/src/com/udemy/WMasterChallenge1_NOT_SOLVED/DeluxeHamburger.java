package com.udemy.WMasterChallenge1_NOT_SOLVED;

public class DeluxeHamburger extends Hamburger{

    private String drink;   //this is not new types of additions, this is just names of additions (same as lettuce, tomato, etc)
    private String chips;

    public DeluxeHamburger(String name, String breadRollType, String meat, double basePrice, String drink, String chips) {
        super(name, breadRollType, meat, basePrice);
        this.drink = drink;
        this.chips = chips;
    }

    @Override
    public void addAddition(String addition, double additionQuantity, double additionPrice) {
        super.addAddition(addition, additionQuantity, additionPrice);
    }

    public String getDrink() {
        return drink;
    }

    public String getChips() {
        return chips;
    }
}



