/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 10: Programming Abstractly Through Interfaces
Topic: Create and implement interfaces
*/

// Create an interface with a default method and one
// abstract method
interface Extendable {
    default void defaultMethod() {
        System.out.println("Extendable: Default method called.");
    }

    void extend();
}

// an interface can extend another interface
interface SubExtendable extends Extendable {

    void append();
}

public class ExtendInterfaceExample implements SubExtendable {
    public static void main(String[] args) {
        ExtendInterfaceExample su = new ExtendInterfaceExample();
        su.extend();

    }

    public void extend() {

        // You can call the interface's default method
        // from the concrete method you create.
        defaultMethod();
        append();
    }

    public void append() {
        System.out.println("Appending functionality ");
    }
}