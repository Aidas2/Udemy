package com.udemy.section14.io.example09_Paths;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Main_crud {

    public static void main(String[] args) {
        try {
            //copying file:
//            Path sourceFile = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "file1.txt"); //copying file
//            Path copyFile = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            //copying directory (but without files inside):
//            sourceFile = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            //moving file:
//            Path fileToMove = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

            //renaming file (renaming ir "moving" into same directory :) ):
//            Path fileToMove = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples",  "file1.txt");
//            Files.move(fileToMove, destination);

            //deleting file:
//            Path fileToDelete = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir1", "file1copy.txt");
//            Files.deleteIfExists(fileToDelete);

            //creating file:
//            Path fileToCreate = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "file2.txt");
//            Files.createFile(fileToCreate);

            //creating directory:
//            Path dirToCreate = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

            //creating directories, version_01:
//            Path dirToCreate = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//            // shouldn't be for Windows "Dir2\\Dir3\\Dir4\\Dir5\\Dir6" ?
//            Files.createDirectories(dirToCreate);

            //creating directories, version_02:
//            Path dirToCreate = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
//            Files.createDirectories(dirToCreate);

//====================================================================================================================================================

            //getting file attributes
            Path filePath = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/Examples", "Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified: " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified: " + attrs.lastModifiedTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory: " + attrs.isDirectory());
            System.out.println("Is regular file: " + attrs.isRegularFile());

            //https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributes.html


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("IOException: " + e.getMessage());
        }


    }
}
