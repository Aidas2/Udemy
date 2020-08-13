package section_03_working_with_java_primitive_data_types_and_string_apis.Local_Variable_Type_Interference;
/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Local Variable Type Inference
Sub-Topic: Out of Ordinary
*/

public class VarLoops {
    public static void main(String[] args) {

        // use LVTI var in a regular for loop
        for (var i = 0; i < 10; i++) {
            System.out.println("i was inferred to be an int, value = " + i);
        }

        // use LVTI var in an enhanced for loop
        for (var arg : args) {
            System.out.println("arg inferred to be a String: " + arg);
        }
    }
}