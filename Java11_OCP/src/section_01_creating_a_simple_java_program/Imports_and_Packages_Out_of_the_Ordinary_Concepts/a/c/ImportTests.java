/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Import statements
*/

package section_01_creating_a_simple_java_program.Imports_and_Packages_Out_of_the_Ordinary_Concepts.a.c;

import java.lang.*;  // This is redundant but OK, always included

import section_01_creating_a_simple_java_program.Imports_and_Packages_Out_of_the_Ordinary_Concepts.a.c.ImportTests; // This is redundant but OK, code will compile

import section_01_creating_a_simple_java_program.Imports_and_Packages_Out_of_the_Ordinary_Concepts.a.b.PackageTests; // This includes classes defined in a but not a.b

public class ImportTests {
    public static void main(String[] args) {
        System.out.println("Import Tests");
        PackageTests.main(args);
    }
}