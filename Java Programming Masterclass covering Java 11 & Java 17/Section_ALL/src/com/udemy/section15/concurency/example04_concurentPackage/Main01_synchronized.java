package com.udemy.section15.concurency.example04_concurentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.udemy.section15.concurency.example04_concurentPackage.Main01_synchronized.EOF;

public class Main01_synchronized {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();

        MyProducer1 producer = new MyProducer1(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer1 consumer1 = new MyConsumer1(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer1 consumer2 = new MyConsumer1(buffer, ThreadColor.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer1 implements Runnable {
    private List<String> buffer;
    private String color;

    public MyProducer1(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);

                //version with synchronized:
                synchronized (buffer) {
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        //version with synchronized:
        synchronized (buffer) {
        buffer.add("EOF");
        }

    }
}

class MyConsumer1 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer1(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {

            //version with synchronized:
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }

        }
    }
}
