package section_03_working_with_java_primitive_data_types_and_string_apis.Narrowing_and_Widening;
/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Declare and Initialize Variables
Sub-Topic: Truncate
*/

public class TruncateNumber {
    public static void main(String[] args) {

        float myFloat = 123.456f;
        Float myFloatWrapper = new Float(myFloat);
        int myNumber = (int) myFloat;

        // Casting with loss of precision..
        System.out.println("myNumber = " + myNumber);

        // We can get the same result using Float.intValue();
        System.out.println("Float.intValue() = " + myFloatWrapper.intValue());

    }

}