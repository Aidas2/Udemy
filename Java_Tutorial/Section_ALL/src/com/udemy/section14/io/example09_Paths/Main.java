package com.udemy.section14.io.example09_Paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/WorkingDirectoryFile.txt");
        printFile(path);
        //Path filePath = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/files/SubdirectoryFile.txt");
        //Path filePath = FileSystems.getDefault().getPath("com", "udemy", "section14", "io", "example09_Paths", "files", "SubdirectoryFile.txt");
        Path filePath = Paths.get(".","com/udemy/section14/io/example09_Paths/files", "SubdirectoryFile.txt");

        printFile(filePath);

        //filePath = Paths.get("C:\\Users\\AidasP\\Projects\\Udemy_etc\\Java_Tutorial\\OutThereFile.txt"); //for Windows
        //filePath = Paths.get("C:\\Users\\AidasP\\Projects\\Udemy_etc","\\Java_Tutorial\\", "OutThereFile.txt");
        filePath = Paths.get("/home/aidas/Documents/Udemy_etc/Java_Tutorial/OutThereFile.txt"); //for Linux
        printFile(filePath);

        filePath = Paths.get("."); //for src/WorkingDirectoryFile2.txt
        printFile(filePath.toAbsolutePath());   //throws java.nio.file.AccessDeniedException (because "you need admin access for file system in most cases")
        System.out.println("======================");

    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path))  {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
