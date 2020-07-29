package section_09_class_design;

/**
 * @author goran on 14/07/2017.
 */

class Dog {
    private String name;
    private String breed;
    private double weight;

    public Dog(String name) {
//        this.name = name;
//        breed = "husky";
//        weight = 30.0;

//        Dog(name, "husky"); // does not compile
//        new Dog(name, "husky"); // compiles but does not do what we want
//        System.out.println("constructor 1");
        this(name, "husky");
        System.out.println("constructor 1");
    }

    public Dog(String name, String breed) {
//        this.name = name;
//        this.breed = breed;
//        weight = 30.0;
        this(name, breed, 30.0);
        System.out.println("constructor 2");
    }

    public Dog(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        System.out.println("constructor 3");
    }

    public void print() {
        System.out.println(name + " " + breed + " " + weight);
    }
}

public class OverloadingConstructors {

    public static void main(String[] args) {
        section_09_class_design.class_constructors.Dog dog1 = new section_09_class_design.class_constructors.Dog("Jimmy");
        dog1.print();

        section_09_class_design.class_constructors.Dog dog2 = new section_09_class_design.class_constructors.Dog("Anthony", "shepard");
        dog2.print();

        section_09_class_design.class_constructors.Dog dog3 = new section_09_class_design.class_constructors.Dog("Rex", "german shepard", 40);
        dog3.print();
    }
}
