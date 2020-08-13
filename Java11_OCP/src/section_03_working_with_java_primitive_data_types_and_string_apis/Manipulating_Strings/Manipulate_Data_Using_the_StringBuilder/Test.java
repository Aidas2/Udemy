package section_03_working_with_java_primitive_data_types_and_string_apis.Manipulating_Strings.Manipulate_Data_Using_the_StringBuilder;


import java.sql.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder(5);  //  Line 1
        builder.append("abcdefghijklmnopqrstuvwxyz");            //  Line 2
        char[] myCharArray;                                     //  Line 3
        if ("hello" == "hello") myCharArray = new char[5];
        System.out.println("myCharArray = " + Arrays.toString(myCharArray));
        builder.getChars(0, 5, new char[5], 0);  //  Line 4
        System.out.println(new String(myCharArray).trim() + "*"); // Line 4
    }

}