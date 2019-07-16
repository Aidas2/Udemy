package com.udemy.section14.io.example08_JavaNio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;

//============== PIPES. THREADS =================================================
public class Main6_Pipes {
    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            // ===== WRITING =========================================
            // ===== THREAD_SINK <<<=== CHANNEL === THREAD_SOURCE ===

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The current time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // ===== READING =========================================
            // ===== THREAD_SINK === CHANNEL <<<=== THREAD_SOURCE ===
            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };

            // ==== CREARING THREADS ===
            new Thread(writer).start();
            new Thread(reader).start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
