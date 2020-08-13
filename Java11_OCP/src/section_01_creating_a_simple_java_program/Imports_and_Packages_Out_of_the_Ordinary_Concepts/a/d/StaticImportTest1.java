/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: import static tests
*/

package section_01_creating_a_simple_java_program.Imports_and_Packages_Out_of_the_Ordinary_Concepts.a.d;

public class StaticImportTest1 {

    public static final String APP_NAME = "First";

    public static void log(String statement) {
        System.out.println("First Logging statement: " + statement);
    }

    public void printUniqueStatement() {
        System.out.println("I am First");
    }
}