package standartTest_01;

//    Which of the following lambda expressions can be used to implement a Function<Integer, String> ?

import java.util.function.Function;

public class Q8Function {

    public static void main(String[] args) {
//        Function<Integer, String> f1 = (a)-> 2*a;   // 2*a will generate an int but we need a String.
//        Function<Integer, String> f2 = (a, s)-> a+" "+s;    // There should be only one argument.
        Function<Integer, String> f3 = (s) ->"hello "+s+"!";    // Don't be fooled by the argument name. s will still be of type Integer.
//        Function<Integer, String> f4 = (a, s, r)-> a+" "+s; // There should be only one argument.
//        Function<Integer, String> f5 = (a)-> System.out.println("done");    //The expression in the lambda body must return a String.

        System.out.println(f3.toString());
    }
}
