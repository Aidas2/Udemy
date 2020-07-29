package section_09_class_design.static_interface_methods;

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

    @Override
    public int getWeight() {
        return 30;
    }

    @Override
    public int getTailLength() {
        return 20;
    }

    @Override
    public void run(int speed) {
        System.out.println("Husky running at speed= " + speed);
    }

    @Override
    protected void printName() {
        System.out.println("Husky name= " + getName());
    }
}
