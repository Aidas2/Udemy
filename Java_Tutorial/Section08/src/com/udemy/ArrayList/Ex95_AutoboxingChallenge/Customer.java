package com.udemy.ArrayList.Ex95_AutoboxingChallenge;

import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

public class Customer {
    private String customerName;
    //double initialAmount; // not necessary, it's enough to specify in constructor
    private ArrayList<Double> transactions;

    public Customer(String customerName, double initialAmount ) {
        this.customerName = customerName;
        //this.initialAmount = initialAmount;
        this.transactions = new ArrayList<Double>();
        //this.transactions.add(initialAmount);
        addTransaction(initialAmount);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction (double doubleAmount) {
        this.transactions.add(doubleAmount);
    }


    ///////////////////////////////////
//
//    public void printTransactions() {
//        System.out.println("Customer " + this.customerName + " has made " + transactions.size() + " transactions:");
//        for (int i = 0; i < transactions.size(); i ++) {
//            System.out.println((i +1) + ". Transaction amount " + transactions.get(i).doubleValue());
//        }
//        System.out.println();
//    }
}
