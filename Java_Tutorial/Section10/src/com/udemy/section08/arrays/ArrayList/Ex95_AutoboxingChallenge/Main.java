package com.udemy.section08.arrays.ArrayList.Ex95_AutoboxingChallenge;


// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

public class Main {



    public static void main(String[] args) {
        Bank bank = new Bank("SEB");

        bank.addNewBranch("Pilaite");

        bank.addNewCustomer("Pilaite", "Aidas", 12.36);
        bank.addNewCustomer("Pilaite", "Julius", 15.69);
        bank.addNewCustomer("Pilaite", "Tomas", 220.12);

        bank.addNewBranch("Antakalnis");
        bank.addNewCustomer("Antakalnis", "Saule", 150.54);

        bank.addCustomerTransaction("Pilaite", "Aidas", 50.05);
        bank.addCustomerTransaction("Pilaite", "Aidas", 140.07);
        bank.addCustomerTransaction("Pilaite", "Julius", 1.89);

        bank.listCustomers("Pilaite", true);
        bank.listCustomers("Antakalnis", true);




    }
}
