package com.udemy.section14.io.example01;

import com.udemy.section14.io.example03_BufferedWriter.Location;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simplest {
    public static void main(String[] args) throws IOException {
        //readWholeFile();
        writeWholeFile();
    }

    public static String fileNameToRead = "com/udemy/section14/io/example01/textfile001.txt";
    public static String fileNameToWrite = "com/udemy/section14/io/example01/textfile002.txt";

    public static String readWholeFile() {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileNameToRead)))) {
            String allLines = "";
            while (scanner.hasNextLine()) {
                String oneWholeLine = scanner.nextLine();
                allLines = allLines + oneWholeLine +"\n";
                System.out.println("This is oneWholeLine: " + oneWholeLine);
            }
            System.out.println("\n" + "This is allLines:" + "\n" + allLines);
            return allLines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void writeWholeFile() throws IOException {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileNameToWrite))) {
            String stringToWrite = readWholeFile();
            br.write(stringToWrite);
        }
    }




    //    ArrayList<String> words = new ArrayList<String>();;
//    public static void readWholeFile() {
//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
//            while (scanner.hasNextLine()) {
//                String delimiterChars = "[-.,:()\t ]+";
//                String[] wordsSeparated = veryLongString.split(delimeterChars);
//                String word = scanner.nextLine();
//                System.out.println(word);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



}
