package com.udemy.Ex30;

public class VipPerson {

    private String name;
    private double creditLimit;
    private String emailAdress;

    public VipPerson() {
        this("vippersonBOB", 50000.00, "defaultvip@vip.com");
    }

    public VipPerson(String name, double creditLimit) {
        this(name, creditLimit, "unknownp@email.com");
    }

    public VipPerson(String name, double creditLimit, String emailAdress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAdress() {
        return emailAdress;
    }
}
