package section_09_class_design.class_inheritance_2.main;

import section_09_class_design.class_inheritance_2.Dog;
import section_09_class_design.class_inheritance_2.Husky;

/**
 * @author goran on 14/07/2017.
 */
public class Main {

    public static void main(String[] args) {

        Husky husky = new Husky(5);
        husky.printDetails();

        Dog dog = new Dog(3);
        dog.setName("Rex");
        dog.printDetails();
    }
}
