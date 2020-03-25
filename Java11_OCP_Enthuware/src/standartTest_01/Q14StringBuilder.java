package standartTest_01;

public class Q14StringBuilder {
    public static void main(String[] args) {

//        Given:
        StringBuilder sb = new StringBuilder("asdf");
//        Which of the following code fragments will print true?

        String str1 = sb.toString();
        String str2 = sb.toString();
        System.out.println(str1 == str2);

        String str3 = sb.toString();
        String str4 = str3;
        System.out.println(str3 == str4);

        String str5 = sb.toString();
//        System.out.println(str5 == sb);

        System.out.println(sb == new StringBuilder(sb));


//        ===== Explanation =====
        System.out.println("\n==========");
        sb.append("pridejau");
        String str6 = sb.toString();
        System.out.println(str1 + " " + str2 + " " + str6);
    }
}


//The following are the complete contents of TestClass.java file. Which packages are automatically imported?
class Q15TestClass{
    public static void main(String[] args){
        System.out.println("hello");
    }
}
