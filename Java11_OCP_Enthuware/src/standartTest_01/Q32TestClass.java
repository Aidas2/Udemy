package standartTest_01;


//What will be the contents of s1 and s2 at the time of the println statement in the main method of the following program?
import java.util.*;
public class Q32TestClass{
    public static void main(String args[]){
        Stack s1 = new Stack ();
        Stack s2 = new Stack ();
        System.out.println (s1 + "    "+ s2);
        processStacks (s1, s2);
        System.out.println (s1 + "    "+ s2);
    }
    public static void processStacks(Stack x1, Stack x2){
        x1.push (new Integer ("100")); //assume that the method push adds the passed object to the stack.
        x2 = x1;
        System.out.println("x1=" + x1 + ", x2=" + x2);
    }
}
//Note:[] is used in the options below to denote each element of the Stack.