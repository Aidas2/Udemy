package standartTest_01;

//        Given:
public class Q2StringFromChar {

    public static void main(String[] args) {
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd'};

        String newStr = "";
        for (char ch : myCharArr) {
            newStr = newStr + ch;
        }
        boolean b1 = newStr == myStr;
        boolean b2 = newStr.equals(myStr);

        System.out.println(b1 + " " + b2);

    }
}

//    What will it print when compiled and run?
//In every iteration of the loop, a new String object is created by appending the character to the existing String object.
// This new String object is assigned back to newStr. At the end of the loop, myStr is "good",
// which is why newStr.equals(myStr) prints true. Since, newStr points to a different String object than the one pointed
// to by myStr, newStr == myStr evaluates to false.
//
// Had newStr been defined as String newStr = null;, // the program would have printed false for newStr == myStr because
// both the references are pointing to two different objects, and false for newStr.equals(myStr) because newStr would
// then contain "nullgood".