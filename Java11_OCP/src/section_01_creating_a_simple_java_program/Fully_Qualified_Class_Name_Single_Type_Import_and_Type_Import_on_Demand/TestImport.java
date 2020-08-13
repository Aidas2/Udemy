package section_01_creating_a_simple_java_program.Fully_Qualified_Class_Name_Single_Type_Import_and_Type_Import_on_Demand;
/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 2: Testing import statements
*/

// type-import-on-demand declaration
import section_01_creating_a_simple_java_program.Packages_and_Imports.garden.vegetable.*;
import section_01_creating_a_simple_java_program.Packages_and_Imports.nursery.vegetable.*;

public class TestImport {
    public static void main(String[] args) {

        // String class in the java.lang package, simple class name ok
        // no import statement required
        String s = "We are testing import statements";
        System.out.println(s);

        // We use simple name because we specified location in the import
        // statement
        VineVegetable.main(args);
        section_01_creating_a_simple_java_program.Packages_and_Imports.nursery.vegetable.VineVegetable.main(args);
    }
}

class VineVegetable {
    public static void main(String[] args) {
        System.out.println("I am a local VineVegetable");
    }
}