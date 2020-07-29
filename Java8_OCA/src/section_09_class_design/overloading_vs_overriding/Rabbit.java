package section_09_class_design.overloading_vs_overriding;

/**
 * @author goran on 15/07/2017.
 */
public class Rabbit extends Animal {

    public Rabbit() {
//        super; // does not compile
//        super().setAge(3);

        super();
//        super.setAge(3);
//        this.setAge(3);
//        setAge(3);
    }

    public Rabbit(int age) {
//        this(age); recursive call

//        this();
//        super();
//        this();
//        setAge(3);
        super(3);
    }
}
