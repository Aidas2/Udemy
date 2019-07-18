package com.udemy.section15.concurency.example01;

import static com.udemy.section15.concurency.example01.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        //creating Thread, version_01:
        Thread anotherThead = new AnotherThread();
        anotherThead.setName("== Another Thread ==");
        anotherThead.start();

        //creating Thread, version_02:
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread.");
            }
        }.start();

        //creating Thread, version_03.1:
//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.start();

        //creating Thread, version_03.2:
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                //super.run();
                System.out.println(ANSI_RED + "Hello from the anonymous class implementation of run()");
            }
        });
        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

    }
}
