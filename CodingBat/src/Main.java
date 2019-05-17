public class Main {

    public static void main(String[] args) {
	// write your code here
        frontBack("0");
    }

    public static String frontBack(String str) {

        if (str.length() <= 1) {
            return str;
        } else {
            String first =  str.substring(0, 1);
            String last = str.substring(str.length()-1);
            String between = str.substring(1, str.length()-1);

            str = last + between + first;
            return str;
        }
    }


}
