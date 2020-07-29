package section_09_class_design.abstract_methods;

/**
 * @author goran on 14/07/2017.
 */
public class Cat extends Animal {

    public Cat(int age) {
        super(age);
    }

    @Override
    public int getWeight() {
        return 5;
    }

    @Override
    public void printName() {

    }
}
