package com.udemy.section15.concurency.example05_deadLock;

public class Main_deadLock1 {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();

    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {

                }
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Has lock1 and lock2");
                }
                System.out.println("Thread 1: Released lock2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {

            //version_01. Obtaining locks in different order (causes deadlock)
//            synchronized (lock2) {
//                System.out.println("Thread 2: Has lock2");
//                try {
//                    Thread.sleep(100);
//                } catch(InterruptedException e) {
//
//                }
//                System.out.println("Thread 2: Waiting for lock1");
//                synchronized (lock1) {
//                    System.out.println("Thread 2: Has lock2 and lock1");
//                }
//                System.out.println("Thread 2: released lock1");
//            }
//            System.out.println("Thread 2: Released lock2. Exiting...");

            //version_02. Obtaining locks in same order (do not causes deadlock)
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {

                }
                System.out.println("Thread 2: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 2: Has lock1 and lock2");
                }
                System.out.println("Thread 2: released lock2");
            }
            System.out.println("Thread 2: Released lock1. Exiting...");
        }
    }
}







