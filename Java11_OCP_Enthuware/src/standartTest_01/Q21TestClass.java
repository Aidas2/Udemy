package standartTest_01;

//What will be the result of attempting to compile the following program?

public class Q21TestClass{
    long l1;
    public void Q21TestClass(long pLong) { l1 = pLong ; }  //(1)
    public static void main(String args[]){
        Q21TestClass a, b ;
        a = new Q21TestClass();  //(2)
//        b = new TestClass(5);  //(3)
    }
}