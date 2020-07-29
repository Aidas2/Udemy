package section_09_class_design.static_interface_methods;

/**
 * @author goran on 15/07/2017.
 */
public interface Herbivore {

    default void eatPlants() {
        System.out.println("Eating plants");
    }

//    default int getRequiredPlantAmount();
//    public int getRequiredPlanAmount() {
//        return;
//    }
}
