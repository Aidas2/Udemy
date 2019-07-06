package com.udemy.section07.composition.WMasterChallenge1_NOT_SOLVED;

public class Main {
    // The purpose of the application is to help a ficticious company called Bills Burgers to manage
    // their process of selling hamburgers.
    // Our application will help Bill to select types of burgers, some of the additional items (additions) to
    // be added to the burgers and pricing.
    // We want to create a base hamburger, but also two other types of hamburgers that are popular ones in
    // Bills store.
    // The basic hamburger should have the following items:
    // bread roll type, meat and up to 4 additional additions (things like lettuce, tomato, carrot, etc) that
    // the customer can select to be added to the burger.
    // Each one of these items gets charged an additional
    // price so you need some way to track how many items got added and to calculate the final price (base
    // burger with all the additions).
    // This burger has a base price and the additions are all seperately priced (up to 4 additions, see above).
    // Create a Hamburger class to deal with all the above.
    // The constructor should only include the roll type, meat and price, can also include name of burger or you can use setter.
    // Also create two extra varieties of Hamburgers (subclasses) to cater for
    // a) Healthy burger (on a brown rye bread roll), plus two addition items can be added.
    // The healthy burger can have 6 items (Additions) in total.
    // hint:  you probably want to process the 2 additional items in this new class (subclass of Hamburger), not the base class (Hamburger),
    // since the 2 additions are only appropriate for this new class (in other words new burger type).
    // b) Deluxe hamburger - comes with chips and drinks as additions, but no extra additions are allowed.
    // hint:  You have to find a way to automatically add these new additions at the time the deluxe burger
    // object is created, and then prevent other additions being made.
    //  All 3 classes should have a method that can be called anytime to show the base price of the hamburger
    // plus all additionals, each showing the addition name, and addition price, and a grand/final total for the
    // burger (base price + all additions)
    // For the two additional classes this may require you to be looking at the base class for pricing and then
    // adding totals to final price.

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Base Hamburger", "paprasta huoda duona", "kiauliena", 3.0);
        hamburger.addAddition("lettuce", 2, 0.10);
        hamburger.addAddition("tomato", 2, 0.10);
        hamburger.addAddition("carrot", 2, 0.10);
        hamburger.addAddition("cucumber", 2, 0.10);
        hamburger.addAddition("cheese", 2, 0.10);
        hamburger.addAddition("sugar", 2, 0.10);
        //hamburger.finalPrice(hamburger.getName(), hamburger.getBasePrice());

        System.out.println("===================");

        HealthyBurger healthyBurger = new HealthyBurger("Sveikuoliskas", "kalakutiena", 5);
        healthyBurger.addAddition("lettuce", 2, 0.10);
        healthyBurger.addAddition("tomato", 2, 0.10);
        healthyBurger.addAddition("carrot", 2, 0.10);
        healthyBurger.addAddition("cucumber", 2, 0.10);
        healthyBurger.addAddition("cheese", 2, 0.10);
        healthyBurger.addAddition("sugar", 2, 0.10);

        System.out.println("================================================");

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger("Super Duper", "batonas", "zirafa", 8, "Coca-cola", "Estrella");
        deluxeHamburger.addAddition(deluxeHamburger.getDrink(), 2, 0.10);
        deluxeHamburger.addAddition(deluxeHamburger.getChips(), 2, 0.10);
        deluxeHamburger.addAddition("carrot", 2, 0.10);
        deluxeHamburger.addAddition("cucumber", 2, 0.10);
        deluxeHamburger.addAddition("cheese", 2, 0.10);
        deluxeHamburger.addAddition("sugar", 2, 0.10);






    }


}
