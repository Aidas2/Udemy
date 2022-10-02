package com.udemy.section15.concurency.challenge06;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//Challenge_06. Make threadsafe (add variable status status and make it threadsafe too)
public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }


    public void deposit(double amount) {

        //version with synchronized (challenge_03)
//        synchronized (this) {
//            balance += amount;
//            System.out.println("Deposited " + amount +  " Eur.");
//        }

        //version with lock() (challenge_04)
//        lock.lock();
//        try {
//            balance += amount;
//            System.out.println("Deposited " + amount + " Eur.");
//        } finally {
//            lock.unlock();
//        }

        //version with tryLock() (challenge_05, 06)
        boolean status = false;              //added for challenge_06
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    System.out.println("Deposited " + amount + " Eur.");
                    status = true;  //no need to do something, it's already threadsafe (as it's a local variable of method)
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {

        //version with synchronized (challenge_03)
//        synchronized (this) {
//            balance -= amount;
//            System.out.println("Withdrew " + amount + " Eur.");
//        }

        //version with lock() (challenge_04)
//        lock.lock();
//        try {
//            balance -= amount;
//            System.out.println("Withdrew " + amount + " Eur.");
//        } finally {
//            lock.unlock();
//        }

        //version with tryLock()  (challenge_05, 06)
        boolean status = false;              //added for challenge_06
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    System.out.println("Withdrew " + amount + " Eur.");
                    status = true;  //no need to do something, it's already threadsafe (as it's a local variable of method)
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }

        System.out.println("Transaction status = " + status);

    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
