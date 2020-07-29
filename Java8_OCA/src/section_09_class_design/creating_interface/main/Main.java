package section_09_class_design.creating_interface.main;

import section_09_class_design.creating_interface.Animal;
import section_09_class_design.creating_interface.Dog;
import section_09_class_design.creating_interface.Husky;

/**
 * @author goran on 14/07/2017.
 */
public class Main {

    public static void main(String[] args) {

        Husky husky = new Husky(5);
        husky.setName("Rex");
        husky.printDetails();
        husky.setAge(6);
//        husky.printName();
        husky.printDetails();
        System.out.println("weight= " + husky.getWeight());

//        Dog dog = new Dog(3);
//        dog.setName("Rex");
//        dog.printDetails();

        husky.eat();
        System.out.println("avg= " + husky.getAverageWeight());


    }
}
