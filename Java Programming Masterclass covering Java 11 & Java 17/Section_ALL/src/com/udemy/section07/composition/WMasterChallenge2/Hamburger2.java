package com.udemy.section07.composition.WMasterChallenge2;

public class Hamburger2 {

    private String name;
    private String breadRollType;
    private String meat;
    private double price;

    private String additionName1;
    private double additionPrice1;

    private String additionName2;
    private double additionPrice2;

    private String additionName3;
    private double additionPrice3;

    private String additionName4;
    private double additionPrice4;

    public double additionTotalPrice;

    public Hamburger2(String name, String breadRollType, String meat, double basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = basePrice;
    }

    public void addAddition1 (String additionName, double additionPrice) {
        this.additionName1 = additionName;
        this.additionPrice1 = additionPrice;
        this.additionTotalPrice += this.additionPrice1;
        System.out.println("Added " + this.additionName1 + " for extra " + this.additionPrice1);
    }

    public void addAddition2 (String additionName, double additionPrice) {
        this.additionName2 = additionName;
        this.additionPrice2 = additionPrice;
        this.additionTotalPrice += this.additionPrice2;
        System.out.println("Added " + this.additionName2 + " for extra " + this.additionPrice2);
    }

    public void addAddition3 (String additionName, double additionPrice) {
        this.additionName3 = additionName;
        this.additionPrice3 = additionPrice;
        this.additionTotalPrice += this.additionPrice3;
        System.out.println("Added " + this.additionName3 + " for extra " + this.additionPrice3);
    }

    public void addAddition4 (String additionName, double additionPrice) {
        this.additionName4 = additionName;
        this.additionPrice4 = additionPrice;
        this.additionTotalPrice += this.additionPrice4;
        System.out.println("Added " + this.additionName4 + " for extra " + this.additionPrice4);
    }

    public void countAdditions() {
        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with " + this.meat + " price is " + this.price);
        double totalPrice = this.price + this.additionTotalPrice;
        System.out.println("Total " + this.name + " hamburger price is: " + totalPrice);
    }

}
