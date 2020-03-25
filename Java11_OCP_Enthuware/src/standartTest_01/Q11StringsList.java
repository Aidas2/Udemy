package standartTest_01;

import java.util.ArrayList;
import java.util.Arrays;

public class Q11StringsList {
    public static void main(String[] args) {

//        What will the following code print when run?
        String[] sa = {"charlie", "bob", "andy", "dave"};
        var ls = new ArrayList<String>(Arrays.asList(sa));
        ls.sort((var a, var b) -> a.compareTo(b));
        System.out.println(sa[0] + " " + ls.get(0));

//        ===== Explanation =====
        System.out.println("\n==========");
        var ls2 = Arrays.asList(sa);
        System.out.println(ls2);
        ls2.sort((var a, var b) -> a.compareTo(b));
        System.out.println(ls2);
        System.out.println(sa[0] + " " + ls2.get(0));
//        ls2.add("ann");

        /*
        Observe the statement var ls = new ArrayList<String>(Arrays.asList(sa)); This statement creates an entirely
        new ArrayList object that contains the same elements as the list generated using Arrays.asList(sa). Therefore,
        the new ArrayList and the original String array are completely independent objects.

        If you change this line to var ls = Arrays.asList(sa); The list pointed to by ls would not be independent of
        the string array. It will be backed by the String array. Which means, if you sort the list, the String array
        would also get sorted. So, it will print andy andy. Another important point is that the list pointed to by ls
        will cannot be altered by adding or removing items because the underlying String array's length cannot be
        changed at run time. Thus, if you try to do ls.add("ann") or ls.remove(0),
        a java.lang.UnsupportedOperationException will be thrown at run time.
         */
    }
}
