package com.udemy.section19.databases.example02;

import java.sql.*;

public class Main1 {

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
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                    "(name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('Joe', 4829484, 'joe@anywhere.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('Jane', 45632, 'jane@somethere.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('Fido', 45632, 'dog@email.com')");

//            statement.execute("UPDATE contacts SET phone= 5566789 WHERE name = 'Jane'");
//            statement.execute("DELETE FROM contacts WHERE name = 'Joe'");

            //version#1 query with execute()
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
//            while (results.next()) {
//                System.out.println(results.getString("name") + " " +
//                                    results.getInt("phone") + " " +
//                                    results.getString("email"));
//            }
//            results.close();

            //version#2 query with executeQuery()
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }
            results.close();


            statement.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
