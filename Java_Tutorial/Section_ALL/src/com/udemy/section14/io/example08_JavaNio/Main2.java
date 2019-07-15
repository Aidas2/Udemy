package com.udemy.section14.io.example08_JavaNio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("com/udemy/section14/io/example08_JavaNio/data/data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // WRITING ==============================================================

            byte[] outputBytes = "Hello World!".getBytes();

            //ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();

            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written " + numBytes);

            intBuffer.flip(); //again ? yes !
            intBuffer.putInt(-98756);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written " + numBytes);

            // READING WITH NIO =====================================================

            RandomAccessFile ra = new RandomAccessFile("com/udemy/section14/io/example08_JavaNio/data/data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            //System.out.println("outputBytes = " + new String(outputBytes));
            if(buffer.hasArray()){
                System.out.println("byte buffer = " + new String(buffer.array()));
                //System.out.println("byte buffer = " + new String(outputBytes));
            }

            //Relative read (without passing index position):
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

            //Absolute read (with passing index position):
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));

            //Absolute read demonstrating that it doesn't changes buffers position:
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0)); //absolute read
            System.out.println(intBuffer.getInt());     //relative read


            channel.close();
            ra.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
