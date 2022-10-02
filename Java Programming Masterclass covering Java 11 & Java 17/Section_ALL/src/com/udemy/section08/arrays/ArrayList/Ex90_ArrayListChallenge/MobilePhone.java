package com.udemy.section08.arrays.ArrayList.Ex90_ArrayListChallenge;

import java.util.ArrayList;

public class MobilePhone {
    //private String myNumber;  // not necessary
    private ArrayList<Contact> myContacts; //= new ArrayList<Contact>();

    public MobilePhone(/*String myNumber*/) {
        //this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public void addNewContact(Contact contact) {
        //check if contact already exist (by name):
        if (findContactIndexByName(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
        } else {
            myContacts.add(contact);
        }
    }

//    public ArrayList<Contact> getMyContacts() {
//        return myContacts;
//    }

    public void printContactList() {
        System.out.println("You have " + this.myContacts.size() + " contacts in your contact list");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContacts.get(i).getName() + ", " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        int index = findContactIndexByObject(oldContact);
        if (index < 0) {
            System.out.println(oldContact.getName() + " was not found");
        } else {
            this.myContacts.set(index, newContact);
            System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        }
    }

    // finds index of object 'Contact' in array.
    // In this class it is used just to check if contact exist (used in methods updateContact, removeContact)
    // Also can be used to determine which object in array to modify.
    private int findContactIndexByObject(Contact searchContact) {
        return this.myContacts.indexOf(searchContact); //return integer (>=0), showing object position in array
    }

    // finds index of object 'Contact' in array (by comparing names).
    // In this class it is used just for checking if this name already exist or not (used in method addContact)
    private int findContactIndexByName(String contactSearchName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (this.myContacts.get(i).getName().equals(contactSearchName)) {
                return i;
            }
        }
        return -1;
    }

    // finds name of object 'Contact' in array.
    // It is needed to just for checking if this name already exist or not (?)
    public String findContactNameByObject(Contact searchContact) {
        return searchContact.getName();
    }

    // finds object 'Contact' in array by entering his name.
    // It is needed in Main class to specify which object to modify, or to check if contact with that name exists
    public Contact findContactByHisName (String contactName) {
        int index = findContactIndexByName(contactName);
        if(index >=0) {
            return this.myContacts.get(index);
        } else {
            return null;
        }
    }

    public void removeContact(Contact contact) {
        int index = findContactIndexByObject(contact);
        if (index < 0) {
            System.out.println(contact.getName() + " was not found");
        } else {
            this.myContacts.remove(index);
            System.out.println("Contact " + (index + 1) + " has been removed.");
        }
    }

    ////////////////////////////////////////////////////
    //alternatively we can use those methods to check if object exist (as used in example01 with GroceryList)

    public boolean existingOrNotByObject (Contact searchContact) {
        int index = findContactIndexByObject(searchContact);
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existingOrNotByObjectName (String contactName) {
        int index = findContactIndexByName(contactName);
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
