package standartTest_01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Q1StrListForEach {

    public static void main(String[] args) {
//        Given:
        List<String> strList = Arrays.asList("a", "aa", "aaa");
        Function<String, Integer> f = x->x.length();
        Consumer<Integer> c = x->System.out.print("Len:"+x+" ");
        Predicate<String> p = x->"".equals(x);
//        strList.forEach(  *INSERT CODE HERE*  );
//        What can be inserted in the code above?

//        f
//        c
//        p
//        c and p
//        All of the above
//        None of the above

//        ===== Explanation =====
//    The forEach method expects a Consumer. Further, since strList is a list of Strings, strList.forEach expects a Consumer<String>.
//    Therefore, none of the given options can be passed to the forEach invocation.

        Consumer<String> c2 = x->System.out.print("Len:"+x+" " + x.length() + " ");
        strList.forEach(c2);

        System.out.println("\n==============");
        System.out.println(strList);
        System.out.println(f);
        System.out.println(c);
        System.out.println(p);
    }
}

