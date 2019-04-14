package com.udemy.WMasterChallenge1_NOT_SOLVED;

public class Hamburger {

    private String name;
    private String breadRollType;
    private String meat;
    private double basePrice;

    private String addition;
    public double additionQuantity;
    private double additionPrice;

    private int additionCount;
    private int additionMaxCount = 4;   //not four times, but four species !
    private double additionTotalPrice;

    public Hamburger(String name, String breadRollType, String meat, double basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

    public void addAddition (String addition, double additionQuantity, double additionPrice) {
        if (this.additionCount < this.additionMaxCount) {
            this.additionCount ++;
            System.out.println("You added " + this.additionCount + " addition/s:");

            double additionFinalPrice = additionQuantity * additionPrice;
            System.out.println("Addition name: " + addition + ", addition quantity: " + additionQuantity + ", addition price: " + additionPrice + ". Final price of this addition: " + additionFinalPrice);

//            double finalPrice = this.basePrice + additionFinalPrice;
//            System.out.println("Current final price: " + finalPrice);

            this.additionTotalPrice += additionFinalPrice;
            double totalPrice = this.basePrice + this.additionTotalPrice;
            System.out.println("The total price of the " + this.name + ": " + this.basePrice + " + " + this.additionTotalPrice + " = " + totalPrice);
            System.out.println();

        } else {
            System.out.println("Addition not added. You can add up to " + additionMaxCount + " addition");
           //return 0;
        }
    }

    public void checkAddition() {

    }


}
