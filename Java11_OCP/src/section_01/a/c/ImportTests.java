/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Import statements
*/

package section_01.a.c;

import java.lang.*;  // This is redundant but OK, always included

import section_01.a.c.ImportTests; // This is redundant but OK, code will compile

//import section_01.a.*; // This includes classes defined in a but not a.b

import section_01.a.b.PackageTests;

public class ImportTests {
    public static void main(String[] args) {
        System.out.println("Import Tests");
        PackageTests.main(args);
    }
}