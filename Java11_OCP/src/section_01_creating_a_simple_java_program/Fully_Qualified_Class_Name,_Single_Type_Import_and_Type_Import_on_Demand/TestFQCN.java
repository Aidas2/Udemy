/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Testing imports
*/

public class TestFQCN {
    public static void main(String[] args) {

        // String class in the java.lang package, simple class name ok
        String s = "We are testing ways to import classes";
        System.out.println(s);

        // Any class in any other packages must be qualified or imported
        garden.vegetable.VineVegetable.main(args);
    }
}