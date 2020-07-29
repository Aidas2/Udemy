package section_02_basics.academy.learnprogramming;

import static java.lang.Math.PI;
import static java.lang.Math.min;
import static java.lang.System.out;
import static section_02_basics.academy.learnprogramming.Config.*;

/**
 * @author goran on 24/06/2017.
 */
public class StaticImportsExample {

    public static void main(String[] args) {
        int min = min(5,7);
        out.println("min= " + min);
        out.println(PI);

        printConfig();

        out.println("name= " + NAME);
        out.println("columnCount= " + MAX_COLUMN_COUNT);
    }
}
