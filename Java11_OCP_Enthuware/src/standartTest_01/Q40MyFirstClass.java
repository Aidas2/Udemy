package standartTest_01;

//Given the following code -

public class Q40MyFirstClass{
    public static void main(String[] args){
        Printer.print(args[1]);
    }
}
class Printer{
    public static void print(String s){
        System.out.println(s);
    }
}

//    Which of the following commands will compile and then print "hello"?
//javac Q40MyFirstClass.java java Q40MyFirstClass hello1 hello2
//java Q40MyFirstClass.java hello1 hello2
