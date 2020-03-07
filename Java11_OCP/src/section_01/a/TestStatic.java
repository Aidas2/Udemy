/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Testing Static Imports
*/

package section_01.a;

import section_01.a.d.StaticImportTest1;

import static section_01.a.d.StaticImportTest1.*;

import section_01.a.e.StaticImportTest2;

import static section_01.a.e.StaticImportTest2.APP_NAME;

public class TestStatic {

    public static void main(String[] args) {
        // APP_NAME in line below can be referenced without class name
        // because of import static statement.
        System.out.println("APP_NAME = " + APP_NAME);

        // log method in line below can be referenced without class name
        // because of import static statement.
        log("This is StaticImportTest");

        // We instantiate StaticImportTest1() and execute a method on it
        new StaticImportTest1().printUniqueStatement();

        // APP_NAME in line below qualified by class name
        System.out.println("APP_NAME = " + StaticImportTest2.APP_NAME);

        // log method in line below qualified by class name
        StaticImportTest2.log("This is StaticImportTest");

        // We instantiate StaticImportTest2() and execute a method on it
        new StaticImportTest2().printUniqueStatement();

    }
}