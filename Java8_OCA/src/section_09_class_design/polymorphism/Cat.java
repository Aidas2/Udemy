package section_09_class_design.polymorphism;

/**
 * @author goran on 14/07/2017.
 */
public class Cat extends Animal implements Run {

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

//    @Override
//    public int getSpeed() {
//        return 15;
//    }
}
