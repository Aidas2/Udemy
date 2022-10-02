package com.udemy.section14.io.example08_JavaNio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
//============== CHAINED PUT METHODS =================================================
public class Main3 {
    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("com/udemy/section14/io/example08_JavaNio/data/data3.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // WRITING ==============================================================

            ByteBuffer buffer = ByteBuffer.allocate(100);

            // version WITHOUT chained put method
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            buffer.putInt(245);
//            buffer.putInt(-98765);
//            byte[] outpuBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outpuBytes2);
//            buffer.putInt(1000);
//            buffer.flip();

            // version WITH chained put method
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outpuBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outpuBytes2).putInt(1000);
            buffer.flip();



            binChannel.write(buffer);

            // READING =============================================================

            RandomAccessFile ra = new RandomAccessFile("com/udemy/section14/io/example08_JavaNio/data/data3.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outpuBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
