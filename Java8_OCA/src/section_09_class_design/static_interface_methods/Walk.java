package section_09_class_design.static_interface_methods;

/**
 * @author goran on 18/07/2017.
 */
public interface Walk {

    default int getSpeed() {
        return 5;
    }
}
