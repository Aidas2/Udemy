package com.udemy.section15.concurency.example04_concurentPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.udemy.section15.concurency.example04_concurentPackage.Main05_arrayBlockingQueue.EOF;

public class Main05_arrayBlockingQueue {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        //List<String> buffer = new ArrayList<String>();
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        //ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer5 producer = new MyProducer5(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer5 consumer1 = new MyConsumer5(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer5 consumer2 = new MyConsumer5(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());  //will wait while another three threads finishes (if limited up to tree threads)
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer5 implements Runnable {
    //private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    public MyProducer5(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
        //this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);

                //bufferLock.lock();
                buffer.put(num);
//                try {
//                    buffer.add(num);
//                } finally {
//                    bufferLock.unlock();
//                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        //bufferLock.lock();
        try {
            //buffer.add("EOF");
            buffer.put("EOF");
        }
//        finally {
//            bufferLock.unlock();
//        }
        catch (InterruptedException e) {

        }
    }
}

class MyConsumer5 implements Runnable {
//    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock bufferLock;

    public MyConsumer5(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
        //this.bufferLock = bufferLock;
    }

    public void run() {

        while (true) {
            synchronized (buffer) {

                //if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    //if (buffer.get(0).equals(EOF)) {
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        //System.out.println(color + "Removed " + buffer.remove(0));
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
