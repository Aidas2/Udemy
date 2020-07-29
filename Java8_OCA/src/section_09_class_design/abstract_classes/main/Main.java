package section_09_class_design.abstract_classes.main;

import section_09_class_design.abstract_classes.Animal;
import section_09_class_design.abstract_classes.Dog;
import section_09_class_design.abstract_classes.Husky;

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

        husky.eat();
        System.out.println("avg= " + husky.getAverageWeight());


    }
}
