package com.udemy.section14.io.example09_Paths;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main_Paths {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/WorkingDirectoryFile.txt"); // directly to file
        printFile(path);

        //Path filePath = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/files/SubdirectoryFile.txt"); // first folder and only then file
        //Path filePath = FileSystems.getDefault().getPath("com", "udemy", "section14", "io", "example09_Paths", "files", "SubdirectoryFile.txt"); // same path but 'splited'
        Path filePath = Paths.get(".","com/udemy/section14/io/example09_Paths/files", "SubdirectoryFile.txt"); //same path, but 'splited' into dot-folder-file (dot means current directory)
        printFile(filePath);

        //filePath = Paths.get("C:\\Users\\AidasP\\Projects\\Udemy_etc\\Java_Tutorial\\OutThereFile.txt"); //for Windows, version_01
        //filePath = Paths.get("/home/aidas/Documents/Udemy_etc/Java_Tutorial/OutThereFile.txt"); //for Linux, version_01
        filePath = Paths.get("C:\\Users\\AidasP\\Projects\\Udemy_etc","\\Java_Tutorial\\", "OutThereFile.txt"); //for Windows, version_02 ('splited' into rootNode-folder-file
        printFile(filePath);

        filePath = Paths.get("."); //for src/WorkingDirectoryFile2.txt  //(dot means current directory)
        System.out.println(filePath.toAbsolutePath());   // if throws java.nio.file.AccessDeniedException it means "you need admin access for file system in most cases"

        //(dot means current directory, two dots means previous (parent) directory)
        Path path2 = FileSystems.getDefault().getPath(".","com/udemy/section14/io/example09_Paths/files", "..", "files", "SubdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

        //============================================================================================================================================================================================
        //creating path to file that doesn't exist:
        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("C:\\Users\\AidasP\\Projects\\Udemy_etc", "abcdef", "whatever.txt");
        System.out.println(path4.toAbsolutePath());

        //checking if file exist:
        filePath = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/files");
        System.out.println("Exists = " + Files.exists(filePath));

        System.out.println("Exists = " + Files.exists(path4));

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
