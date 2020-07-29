package section_09_class_design.overloading_vs_overriding;

/**
 * @author goran on 15/07/2017.
 */
public class Bird {

    public void fly() {
        System.out.println("Bird is flying");
    }

    public void eat(int amount) {
        System.out.println("Bird is eating " + amount + " units of food");
    }
}
