/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Create an executable Java program
*/

public class MainTests {
    // Executable main method
    public static void main(String... args) throws Exception {
        main("");
        main();
    }

    // Incorrect Signature, not an executable main
    public static void main(String arg) {
        System.out.println("main(String arg): Not an executable main method");
    }

    // Incorrect Signature, not an executable main
    public static void main() {
        System.out.println("main(): Not an executable main method");
    }
}