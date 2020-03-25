package standartTest_01;


//Given the following program, which statements are true?

// Filename: TestClass.java
public class Q22TestClass{
    public static void main(String args[]){
        A22[] a, a1;
        B22[] b;
        a = new A22[10]; a1  = a;
        b =  new B22[20];
        a = b;  // 1
        b = (B22[]) a;  // 2
        b = (B22[]) a1; // 3
    }
}
class A22 { }
class B22 extends A22 { }
