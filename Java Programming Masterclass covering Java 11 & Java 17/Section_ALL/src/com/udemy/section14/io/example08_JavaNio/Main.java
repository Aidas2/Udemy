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

//============== WRITING and READING =================================================
//============== ABSOLUTE AND RELATIVE READS =================================================
//        ATTENTION: To make relative path work, go to EditConfigurations and set Working Directory to C:\Users\AidasP\Projects\Udemy\Java_Tutorial\Section_ALL\src

public class Main {
    public static void main(String[] args) {
/*        // version_01
        try {
//            FileInputStream file = new FileInputStream("com/udemy/section14/io/example08_JavaNio/data/data.txt");
//            FileChannel channel = file.getChannel();
            Path dataPath = FileSystems.getDefault().getPath("com/udemy/section14/io/example08_JavaNio/data/data.txt");

            Files.write(dataPath, "\nLine 5".getBytes("UTF8"), StandardOpenOption.APPEND);

//            List<String> lines = Files.readAllLines(dataPath, StandardCharsets.US_ASCII);
            List<String> lines = Files.readAllLines(dataPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        //version_02
        try (FileOutputStream binFile = new FileOutputStream("com/udemy/section14/io/example08_JavaNio/data/data1.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // WRITING ==============================================================

            byte[] outputBytes = "Hello World!".getBytes();

            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);




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

            // READING WITH IO =====================================================

//            RandomAccessFile ra = new RandomAccessFile("com/udemy/section14/io/example08_JavaNio/data/data1.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1 + " : " + int2);

            // READING WITH NIO =====================================================

            RandomAccessFile ra = new RandomAccessFile("com/udemy/section14/io/example08_JavaNio/data/data1.dat", "rwd");
            FileChannel channel = ra.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            //System.out.println("outputBytes = " + new String(outputBytes));
            if(buffer.hasArray()){
                System.out.println("byte buffer = " + new String(buffer.array()));
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
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));

            channel.close();
            ra.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
