package com.udemy.section15.concurency.example04_concurentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.udemy.section15.concurency.example04_concurentPackage.Main02_lock.EOF;

//in this example locks are used in not recommended way (may hold lock forever) ;)

public class Main02_lock {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();

//        MyProducer1 producer = new MyProducer1(buffer, ThreadColor.ANSI_YELLOW);
//        MyConsumer1 consumer1 = new MyConsumer1(buffer, ThreadColor.ANSI_PURPLE);
//        MyConsumer1 consumer2 = new MyConsumer1(buffer, ThreadColor.ANSI_CYAN);

        MyProducer2 producer = new MyProducer2(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer2 consumer1 = new MyConsumer2(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer2 consumer2 = new MyConsumer2(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer2 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

//    public MyProducer2(List<String> buffer, String color) {
//        this.buffer = buffer;
//        this.color = color;
//    }

    public MyProducer2(List<String> buffer, String color, ReentrantLock bufferLock) {
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

                //version with synchronized:
//                synchronized (buffer) {
//                    buffer.add(num);
//                }

                //version with lock:
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        //version with synchronized:
//        synchronized (buffer) {
//        buffer.add("EOF");
//        }

        //version with lock:
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();

    }
}

class MyConsumer2 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

//    public MyConsumer2(List<String> buffer, String color) {
//        this.buffer = buffer;
//        this.color = color;
//    }

    public MyConsumer2(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        while (true) {

            //version with synchronized:
//            synchronized (buffer) {
//                if (buffer.isEmpty()) {
//                    continue;
//                }
//                if (buffer.get(0).equals(EOF)) {
//                    System.out.println(color + "Exiting");
//                    break;
//                } else {
//                    System.out.println(color + "Removed " + buffer.remove(0));
//                }
//            }

            //version with lock:
            bufferLock.lock();
            if (buffer.isEmpty()) {
                bufferLock.unlock();    // !!!
                continue;
            }
            if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                bufferLock.unlock();    // !!!
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }
}
