package com.udemy.section19.databases.example02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        //version#1 (try with resources, closes automatically):
//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:src/com/udemy/section19/databases/example02/testjava.db");
//            Statement statement = conn.createStatement()) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

        //version#2 (try without resources, closes manually):
        try {
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:/Volumes/Production/Courses/Programs/JavaPrograms/TestDB/testjava.db"); // for Mac
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");  //for Windows
            //Class.forName("org.sql.JDBC");    //old way
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/com/udemy/section19/databases/example02/testjava.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

            statement.close();
            conn.close();



        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
