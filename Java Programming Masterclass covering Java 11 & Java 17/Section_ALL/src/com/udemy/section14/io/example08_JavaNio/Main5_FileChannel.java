package com.udemy.section14.io.example08_JavaNio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//============== FILE CHANNEL =================================================
public class Main5_FileChannel {
    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("com/udemy/section14/io/example08_JavaNio/data/data5.dat");
             FileChannel binChannel = binFile.getChannel()) {

//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

            // WRITING SEQUENTIALLY ==============================================================

            // writing sequentially:

            ByteBuffer buffer = ByteBuffer.allocate(100);

            // version WITHOUT chained put method:
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outpuBytes2 = "Nice to meet you".getBytes();
            buffer.put(outpuBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outpuBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            // version WITH chained put method:
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outpuBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outpuBytes2).putInt(1000);
//            buffer.flip();

            binChannel.write(buffer);

            // READING =============================================================

            RandomAccessFile ra = new RandomAccessFile("com/udemy/section14/io/example08_JavaNio/data/data5.dat", "rwd");
            FileChannel channel = ra.getChannel();

            //reading not in reverse order =================================================

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outpuBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());

            //reading in reverse order =====================================================

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("int3 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("int2 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();

            System.out.println("int1 = " + readBuffer.getInt());

            //File Channel begins here:
            RandomAccessFile copyFile = new RandomAccessFile("com/udemy/section14/io/example08_JavaNio/data/datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
            //long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();

/*
            // writing RANDOMLY: =================================================

            //calculating positions:
            byte[] outputString = "Hello World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            //writing values to buffer:
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));
*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
