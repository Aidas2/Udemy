package section_09_class_design.default_interface_methods;

/**
 * @author goran on 15/07/2017.
 */
public interface Carnivore {

    default void eatMeat() {
        System.out.println("Eating meat");
    }
}
