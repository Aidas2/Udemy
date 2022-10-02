package com.udemy.section14.io.example09_Paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main_FileTree {

    public static void main(String[] args) {

        //creating our own filter, version_01:
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path)); //if file is regular, he will be passed through filter
//            }
//        };

        //creating our own filter, version_02 (with lambda expression):
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p); //if it is a regular file, he will be passed through filter

        //walking(?) through file tree, listening files
        //Path directory = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/FileTree/Dir2");
        Path directory = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/FileTree" + File.separator + "Dir2"); //path with not hardcoded separator
        //try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory)){               //nor filter, shows all directories and files
        //try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.dat")){      //filters only files with extension dat
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)){         //using our own filter
            for(Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        //getting separator for OS, two versions:
        String separator = File.separator;
        System.out.println(separator);

        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        //creating temp files:
        try {
            Path tempFile = Files.createTempFile("myapp", ".appext"); //prefix and suffix
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //getting file stores for OS:
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores) {
            System.out.println("Volume name / Drive letter: " + store);
            System.out.println("Volume name: " + store.name());
        }

        System.out.println("****************************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths) {
            System.out.println("Root directory: " + path);
        }

//====================================================================================================================================================

        //walking through file tree (lets pretend that Dir2 is root directory)
        System.out.println("=== Walking Tree for Dir2 ===");
        Path dir2Path = FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames()); //PrintNames() is an instance of class PrintNames.java
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //copying entire file tree
        System.out.println("=== Copy Dir2 to Dir4/Dir2Copy ===");
        Path copyPath =  FileSystems.getDefault().getPath("com/udemy/section14/io/example09_Paths/FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath)); //CopyFiles() is an instance of class CopyFiles.java
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//====================================================================================================================================================

        //java.io converting to java.nio

        //converting:
        System.out.println("=== java.io converting to java.nio ===");
        File file = new File("com/udemy/section14/io/example09_Paths/FileTree" + File.separator + "Dir2");
        Path convertedPath = file.toPath();
        System.out.println("ConvertedPath = " + convertedPath);

        //resolving:
        File parent = new File("com/udemy/section14/io/example09_Paths/Examples");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println("Resolved file: " + resolvedFile.toPath());

        resolvedFile = new File("com/udemy/section14/io/example09_Paths/Examples", "dir/file.txt");
        System.out.println("Resolved file: " + resolvedFile.toPath());

        Path parentPath = Paths.get("com/udemy/section14/io/example09_Paths/Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println("Resolved file: " + parentPath.resolve(childRelativePath));

        //some hack :)
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working Directory: " + workingDirectory.getAbsolutePath());

        //listening content of directory
        System.out.println("=== printing Dir2 content using list() ===");
        File dir2File = new File(workingDirectory, "com/udemy/section14/io/example09_Paths/FileTree/Dir2" );
        String[] dir2Contents = dir2File.list();
        for(int i = 0; i < dir2Contents.length; i++) {
            System.out.println("i = " + i + " : " + dir2Contents[i]);
        }

        System.out.println("=== printing Dir2 content using listFiles() ===");
        File[] dir2Files = dir2File.listFiles();
        for(int i = 0; i < dir2Files.length; i++) {
            System.out.println("i = " + i + " : " + dir2Files[i].getName());
        }


    }
}
