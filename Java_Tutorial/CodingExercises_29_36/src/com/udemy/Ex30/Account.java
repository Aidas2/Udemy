package com.udemy.Ex30;

public class Account {

//    public static void main(String[] args) {
//
//        com.udemy.Ex30.Account bobsAccount = new com.udemy.Ex30.Account();
//
//        bobsAccount.withdrawFunds(56.0);
//        bobsAccount.depositFunds(100.0);
//
//    }

    private int number;
    private double balance;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;


    // Version_01. Empty constructor (and calling another constructor with parameters)
    public Account() {
        this(56789, 2.50, "Default name", "Default adress", "Default phone");
        System.out.println("Empty constructor called");
    }

    // Version_02. Constructor with parameters.
    public Account(int number, double balance, String customerName, String customerEmail, String customerPhoneNumber) {
        System.out.println("Account constructor with parameters called");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    // Version_03. Constructor with parameters (firs two default, three last not)
    public Account(String customerName, String customerEmail, String customerPhoneNumber) {
        this(9999, 100.55, customerName, customerEmail, customerPhoneNumber);
    }

    public void depositFunds(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. New balance is " + this.balance);
    }

    public void withdrawFunds(double withdrawalAmount) {
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("Insufficient funds. Only " + this.balance + " available. Withdrawal not proceeded");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " proceeded. Remaining balance = " + balance);
        }
    }

    //getters and setters:


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
