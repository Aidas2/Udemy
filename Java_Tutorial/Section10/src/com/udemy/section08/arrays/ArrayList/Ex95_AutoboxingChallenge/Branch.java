package com.udemy.section08.arrays.ArrayList.Ex95_AutoboxingChallenge;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // there is no need fo two separate methods (create, add), it's enough one method:
    public void addNewCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialAmount);
            this.customers.add(customer);
        }
    }
//    public Customer createCustomer (String customerName, double initialAmount) {
//        return new Customer(customerName, initialAmount);
//    }
//    public void addNewCustomer (Customer customer) {
//        this.customers.add(customer);
//    }

    public void addCustomerTransaction (String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
        }
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i ++) {
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getCustomerName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }


    //////////////////////////////
//
//
//    public void printCustomers() {
//        System.out.println("Branch " + this.branchName + " has got " + customers.size() + " customers: ");
//        for (int i = 0; i < customers.size(); i++) {
//            System.out.println((i + 1) + ". Customer " + customers.get(i).getCustomerName());
//        }
//        System.out.println();
//    }

}
