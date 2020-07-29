package section_08_methods.staticMethodsAndFields;

/**
 * @author goran on 12/07/2017.
 */
public class Launcher {

    public static void main(String[] args) {
        StaticMethodsAndFields.main(args);
        System.out.println(StaticMethodsAndFields.myNumber);

        AnotherMain.main(args);
    }
}
