package section_09_class_design.super_vs_super;

/**
 * @author goran on 14/07/2017.
 */
public class Husky extends Dog {

    public Husky(int age) {
//        this();
        super(age);
        System.out.println("Husky");
    }

    @Override
    public void eat() {
//        super.eat();
        System.out.println("Husky eating");

        super.eat();
    }
}
