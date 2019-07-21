package com.udemy.section18.debuggerJunit.example02;

//import static org.junit.jupiter.api.Assertions.*;

import static junit.framework.TestCase.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;


    @org.junit.BeforeClass //to perform only once (mus be followed by annotation After, see below)
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.Before   //to perform before each test (no need to repeatedly create instances}
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test... ");
    }

//=================================================
    @org.junit.Test
    public void deposit() throws Exception {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        //assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        /*double balance =*/ account.withdraw(600.00, false);
        //assertEquals(400.00, balance, 0); not necessary
        fail("Should have thrown an IllegalArgumentException");

    }

    //old version (before JUnit4):
    @org.junit.Test
    public void withdraw_notBranchOldStyle() throws Exception {
        try {
            account.withdraw(600.00, false);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00,BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isCheking_true() {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        //assertEquals(true, account.isChecking());
        //assertTrue(account.isChecking());
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

//===========================================
    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }


    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

}