package com.udemy.section08.arrays.ArrayList.Ex90_ArrayListChallenge;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone(/*"+37064726286"*/);

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choise:");
            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printMyContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void printMyContacts(){
        mobilePhone.printContactList();
    }

    private static void addNewContact() {
        System.out.println("Enter contact name to add: ");
        String newName = scanner.nextLine();
        System.out.println("Enter contact phone number to add: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        mobilePhone.addNewContact(newContact);
        System.out.println("New contact added: name = " + newName + ", phone number = " + newNumber);
    }

    private static void modifyContact() {
        System.out.println("Enter current contact name: ");
        String currentContactName = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactByHisName(currentContactName);

        System.out.println("Enter new contact name: ");
        String newContactName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newContactNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName, newContactNumber);

        mobilePhone.updateContact(currentContact, newContact);
    }

    private static void removeContact() {
        System.out.println("Enter contact name to remove: ");
        String contactName = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactByHisName(contactName);
        mobilePhone.removeContact(currentContact);
    }

    private static void searchForContact() {
        System.out.println("Enter contact name to search: ");
        String contactName = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactByHisName(contactName);
        if (currentContact != null) {
            System.out.println(currentContact.getName() + " exists");
        } else {
            System.out.println("Contact doesn't exist");
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a new contact to the list.");
        System.out.println("\t 3 - To update a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }
}
