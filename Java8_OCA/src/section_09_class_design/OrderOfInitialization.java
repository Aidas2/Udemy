package section_09_class_design;

/**
 * @author goran on 14/07/2017.
 */

class Example {
    private String name = "dog";

    {
        System.out.println(name);
    }

    private static int COUNT = 0;

    static {
        System.out.println(COUNT);
    }

    {
        COUNT += 10;
        System.out.println(COUNT);
    }

    public Example() {
        System.out.println("constructor");
    }
}

class Demo {

    static {
        add(2);
    }

    static void add(int number) {
        System.out.print(number + " ");
    }

    Demo() {
        add(5);
    }

    static {
        add(4);
    }

    {
        add(6);
    }

    static {
        new Demo();
    }

    {
        add(8);
    }
}

public class OrderOfInitialization {

    public static void main(String[] args) {
        new Example();
        new Demo();
    }
}
