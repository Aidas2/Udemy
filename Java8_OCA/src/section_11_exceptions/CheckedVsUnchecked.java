package section_11_exceptions;

/**
 * @author goran on 21/07/2017.
 */
public class CheckedVsUnchecked {

    public static void main(String[] args) throws Exception {
        myMethod();
//        anotherMethod();
    }

    public static void myMethod() throws Exception {
        throw new Exception("Failed to load");
    }

    public static void anotherMethod() throws RuntimeException {
        throw new RuntimeException("Wrong parameter");
    }
}
