package section_03_working_with_java_primitive_data_types_and_string_apis.Manipulating_Strings;

public class Test {

    public static void main(String... args) {  //  Line 1

        String hello="hello";

        for (var arg: args) {  // Line 2
            StringBuilder sb = new StringBuilder(arg); // Line 3
            System.out.print(arg.equals(sb) +" ");  // Line 4           false
            System.out.print( (hello.equals(arg)) +" ");  // Line 5     true
            System.out.print( (hello==arg) +" "); // Line 6             false
            System.out.println( (hello==arg.intern())); // Line 7       true
        }
        System.out.println("====");
        for (var arg: args) {  // Line 2
            String sb = new String(arg); // Line 3
            System.out.print(arg.equals(sb) +" ");  // Line 4           true
            System.out.print( (hello.equals(arg)) +" ");  // Line 5     true
            System.out.print( (hello==arg) +" "); // Line 6             false
            System.out.println( (hello==arg.intern())); // Line 7       true
        }
    }
}