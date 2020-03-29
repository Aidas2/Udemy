package standartTest_01;


//MOVE What is the result of compiling and running the following code ?

public class Q31TestClass{
    static int si = 10;
    public static void main (String args[]){
        new Q31TestClass();
    }
    public Q31TestClass(){
        System.out.println(this);
    }
    public String toString(){
        return "Q31TestClass.si = "+this.si;
    }
}
