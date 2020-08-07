/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 9: Reusing Implementations Through Inheritance
Topic: Abstract classes
*/

// Vehicle is a concrete class which extends the abstract clas Vehicle
public class Auto extends Vehicle {

    // Create a constructor that is a pass thru to Vehicle constructor
    public Auto(VehicleType type, String owner, String make) {
        super(type, owner, make);
    }

    // Implement Vehicle's drive method for an Auto
    public void drive() {
        System.out.println("Release Brake, go");
    }

    // Implement Vehicle's park method for an Auto
    public void park() {
        System.out.println("Parallel or back in?");
    }

    // Implement Vehicle's makeNoise method for an Auto
    public void makeNoise() {
        System.out.println("Vroom Vroom");
    }

    // Main method creates an instance of Auto and demonstrates calling the
    // concrete methods
    public static void main(String[] args) {
        Auto car = new Auto(VehicleType.Automobile, "Allen", "Ford");
        System.out.println(car);
        car.drive();
        car.park();
        car.makeNoise();
    }
}