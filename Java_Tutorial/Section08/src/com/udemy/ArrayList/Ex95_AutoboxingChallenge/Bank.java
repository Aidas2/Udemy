package com.udemy.ArrayList.Ex95_AutoboxingChallenge;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public String getBankName() {
        return bankName;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

//    public static Bank createBank(String bankName) {
//        return new Bank(bankName);
//    }

    public void addNewBranch (String branchName) {
        if(findBranch(branchName) == null) {
            Branch branch = new Branch(branchName);
            this.branches.add(branch);
        }
    }

    public void addNewCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.addNewCustomer(customerName, initialAmount);
        }
    }

    public void addCustomerTransaction (String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.addCustomerTransaction(customerName, amount);
        }
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i ++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getBranchName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }


    public void listCustomers (String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName() + ": ");

            ArrayList<Customer> customersBelongingToBranch = branch.getCustomers();
            for (Customer cust: customersBelongingToBranch) {
                System.out.println("Customer: " + cust.getCustomerName());
                if(showTransactions) {
                    System.out.println("Transactions: ");
                    ArrayList<Double> transactionsBelongindToCustomer = cust.getTransactions();
                    for (Double dbl: transactionsBelongindToCustomer) {
                        System.out.println("Amount " + dbl.doubleValue());
                    }
                }
            }

        }
    }

////////////////////////////////////////////////////////////////////////

//    public void printBranches(){
//        System.out.println("Bank " + this.bankName + " has got " + branches.size() + " branches:");
//        for(int i = 0; i < branches.size(); i++) {
//            System.out.println((i+1) + ". Branch " + branches.get(i).getBranchName());
//        }
//        System.out.println();
//    }
//
//    public static Branch branch1 = new Branch("Pilaite");
//    public static Branch branch2 = new Branch("Antakalnis");
//    public static Branch branch3 = new Branch("Zverynas");
//



}
