package com.udemy.section15.concurency.example04_concurentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

//in this example locks are used in recommended way (with try/finally) ;)

import static com.udemy.section15.concurency.example04_concurentPackage.Main03_lock.EOF;

public class Main03_lock {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();

        MyProducer3 producer = new MyProducer3(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer3 consumer1 = new MyConsumer3(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer3 consumer2 = new MyConsumer3(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer3 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer3(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);

                //version with lock and try/finally:
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        //version with lock and try/finally:
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer3 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer3(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

//    public void run() {
//        while (true) {
//
//            //version with lock and try/finally:
//            bufferLock.lock();
//            try {
//                if (buffer.isEmpty()) {
//                    //bufferLock.unlock();    // if not removed throws IllegalMonitorStateException (because we do not own this)
//                    continue;
//                }
//                if (buffer.get(0).equals(EOF)) {
//                    System.out.println(color + "Exiting");
//                    //bufferLock.unlock();    // if not removed throws IllegalMonitorStateException
//                    break;
//                } else {
//                    System.out.println(color + "Removed " + buffer.remove(0));
//                }
//            } finally {
//                bufferLock.unlock();
//            }
//        }
//    }

    //version with counter and  tryLock()
    public void run() {

        int counter = 0;

        while (true) {

            //version with lock and try/finally:
            //bufferLock.lock();
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        //bufferLock.unlock();    // if not removed throws IllegalMonitorStateException (because we do not own this)
                        continue;
                    }

                    System.out.println(color + "The counter = " + counter);
                    counter = 0;

                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        //bufferLock.unlock();    // if not removed throws IllegalMonitorStateException
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}
