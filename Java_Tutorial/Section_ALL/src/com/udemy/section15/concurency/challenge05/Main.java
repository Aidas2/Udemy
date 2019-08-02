package com.udemy.section15.concurency.challenge05;

import java.util.concurrent.locks.ReentrantLock;

//Challenge_05. Make threadsafe (by using tryLock (with timing) instead lock)
public class Main {
    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 depositing...");
                account.deposit(300.00);
                System.out.println("thread1 withdrawing...");
                account.withdraw(50.00);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 depositing...");
                account.deposit(203.75);
                System.out.println("thread2 withdrawing...");
                account.withdraw(100.00);
            }
        });

        System.out.println("Initial balance = " + account.getBalance());
        thread1.start();
        thread2.start();
        System.out.println("Final balance = " + account.getBalance());

    }
}
