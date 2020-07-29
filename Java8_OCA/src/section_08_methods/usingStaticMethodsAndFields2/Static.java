package section_08_methods.usingStaticMethodsAndFields2;

/**
 * @author goran on 12/07/2017.
 */
public class Static {

    private String name = "Static";

    public static void one() {}
    public static void two() {}

    public static void three() {
        one();
        two();
//        four();
//        System.out.println(name);
    }

    public void four() {
        one();
        two();
        three();
        System.out.println(name);
    }

    public static void main(String[] args) {
        Static.one();
        one();
        two();
        three();
//        four(); // not static

        Static myInstance = new Static();
        myInstance.four();

        new Static().four();
    }
}
