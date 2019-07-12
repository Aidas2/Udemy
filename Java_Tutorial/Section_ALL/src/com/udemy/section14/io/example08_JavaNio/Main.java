package com.udemy.section14.io.example08_JavaNio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        // version_01
        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example08_JavaNio\\data\\data.txt");
//            FileChannel channel = file.getChannel();
            Path dataPath = FileSystems.getDefault().getPath("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example08_JavaNio\\data\\data.txt");

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
        try (FileOutputStream binFile = new FileOutputStream("C:\\Users\\AidasP\\Projects\\Udemy\\Java_Tutorial\\Section_ALL\\src\\com\\udemy\\section14\\io\\example08_JavaNio\\data\\data.dat");
             FileChannel binChannel = binFile.getChannel()) {

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



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
