package com.udemy.section06.excercises_29_36.Ex30;

public class Main {

    public static void main(String[] args) {

//        version_01 with empty constructor:   =============================================
//        com.udemy.Ex30.Account bobsAccount = new com.udemy.Ex30.Account();
//        bobsAccount.setNumber(12345);
//        bobsAccount.setBalance(0.00);
//        bobsAccount.setCustomerName("Bob Brown");
//        bobsAccount.setCustomerEmail("myEmail@bob.com");
//        bobsAccount.setCustomerPhoneNumber("(007) 123 - 4567");

//        version with non-empty constructor:   ========================================
//        com.udemy.Ex30.Account bobsAccount = new com.udemy.Ex30.Account(12345, 0.00, "Bob Rrown", "myEmail@bob.com", "(007) 123 - 4567");
//
//        System.out.println(bobsAccount.getNumber());
//        System.out.println(bobsAccount.getBalance());
//
//        bobsAccount.withdrawFunds(100.0);
//        bobsAccount.depositFunds(50.0);
//        bobsAccount.withdrawFunds(100.0);
//        bobsAccount.depositFunds(51.0);
//        bobsAccount.withdrawFunds(100.0);



        //version_02 with empty constructor calling another constructor:   ============================
        Account bobsAccount = new Account();

        System.out.println(bobsAccount.getNumber());
        System.out.println(bobsAccount.getBalance());

        bobsAccount.withdrawFunds(100.0);
        bobsAccount.depositFunds(50.0);
        bobsAccount.withdrawFunds(100.0);
        bobsAccount.depositFunds(51.0);
        bobsAccount.withdrawFunds(100.0);


        //version_03. with constructor with default parameters + calling another constructor:   ============================
        Account timsAccount = new Account("Tim", "tim@email.com", "+370-12345");
        System.out.println("number (from default) " + timsAccount.getNumber() + " name (from another constructor) " + timsAccount.getCustomerName());
        System.out.println("Current balace is " + timsAccount.getBalance());
        timsAccount.withdrawFunds(100.55);


        //==============================================================================================================

        VipPerson vipPerson = new VipPerson();
        System.out.println();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(vipPerson.getName());
        System.out.println(vipPerson.getCreditLimit());
        System.out.println(vipPerson.getEmailAdress());

        VipPerson person2 = new VipPerson("Bob", 25000.00);
        System.out.println("=========================");
        System.out.println(person2.getName());
        System.out.println(person2.getCreditLimit());
        System.out.println(person2.getEmailAdress());

        VipPerson person3 = new VipPerson("Tim", 100.00, "tim@email.com");
        System.out.println("=========================");
        System.out.println(person3.getName());
        System.out.println(person3.getCreditLimit());
        System.out.println(person3.getEmailAdress());
    }

}
