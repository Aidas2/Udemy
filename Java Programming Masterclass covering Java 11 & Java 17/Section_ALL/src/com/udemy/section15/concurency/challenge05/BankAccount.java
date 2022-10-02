package com.udemy.section15.concurency.challenge05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//Challenge_05. Make threadsafe (by using tryLock (with timing) instead lock)
public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;                        //step_01

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();      //step_02
    }


    public void deposit(double amount) {

        //version with synchronized (challenge_03)
//        synchronized (this) {
//            balance += amount;
//            System.out.println("Deposited " + amount +  " Eur.");
//        }

        //version with lock() (challenge_04)
//        lock.lock();                        //step_03.1
//        try {
//            balance += amount;
//            System.out.println("Deposited " + amount + " Eur.");
//        } finally {
//            lock.unlock();
//        }

        //version with tryLock() (challenge_05)
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    System.out.println("Deposited " + amount + " Eur.");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }
    }

    public void withdraw(double amount) {

        //version with synchronized (challenge_03)
//        synchronized (this) {
//            balance -= amount;
//            System.out.println("Withdrew " + amount + " Eur.");
//        }

        //version with lock() (challenge_04)
//        lock.lock();                        //step_03.2
//        try {
//            balance -= amount;
//            System.out.println("Withdrew " + amount + " Eur.");
//        } finally {
//            lock.unlock();
//        }

        //version with tryLock() (challenge_05)
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    System.out.println("Withdrew " + amount + " Eur.");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            // do something here
        }
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
