package section_09_class_design.virtual_methods;

/**
 * @author goran on 15/07/2017.
 */
public class Snake extends Reptile {

    @Override
    protected boolean hasLegs() {
        return false;
    }

    @Override
    public double getWeight() {
        return 10;
    }
}
