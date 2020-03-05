/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Create an executable Java program
*/

public class MainTests {
    // Executable main method
    public static void main(String... args) throws  Exception {
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

// C:\Udemy_etc\Java11_OCP>jar -cf MainTest.jar -C out\production\Java11_OCP MainTests.class
// C:\Udemy_etc\Java11_OCP>java -cp MainTest.jar MainTests

// C:\Udemy_etc\Java11_OCP>jar -cfm MainTest.jar manifest.txt -C out\production\Java11_OCP MainTests.class
// C:\Udemy_etc\Java11_OCP>java -jar MainTest.jar
