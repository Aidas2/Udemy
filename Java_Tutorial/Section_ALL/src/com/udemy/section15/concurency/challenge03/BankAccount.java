package com.udemy.section15.concurency.challenge03;

public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    //Challenge_02. Making threadsafe (synchronizing threads).
    //version_01 (synchronize all method):
//    public synchronized void deposit(double amount) {
//        balance += amount;
//        System.out.println("Deposited " + amount +  " Eur.");
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//        System.out.println("Withdrew " + amount + " Eur.");
//    }
//
//    public synchronized double getBalance() { //  - over synchronized :(
//        return balance;
//    }

    //version_02 (synchronize only some action in method):
    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
            System.out.println("Deposited " + amount +  " Eur.");
        }
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " Eur.");
        }
    }

    public double getBalance() { // - over synchronized :(
        synchronized (this) {
            return balance;
        }
    }

    //challenge_03. Should those two methods below be synchronized ? NO ! It will be over synchronizing
    //(because method does only one action (reads, but not updates, not writes)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
