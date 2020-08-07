/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 9: Reusing Implementations Through Inheritance
Topic: Utilize polymorphism to cast and call methods
Sub-Topic: downcasting
*/

// Animal is our base class
class Animal {
    public void printAnimal() {
        System.out.println("I am an animal");
    }
}

// Dog is a subclass of Animal
class Dog extends Animal {
    public void printDog() {
        System.out.println("I am a dog");
    }

    public String getDogString() {
        return "dog";
    }
}

// Cat is also a subclass of Animal
class Cat extends Animal {
    public void printCat() {
        System.out.println("I am a cat");
    }
}

public class DowncastExamples {
    public static void main(String[] args) {
        DowncastExamples dex = new DowncastExamples();

        // We create instances of Dog and Cat but assign them to
        // variables of type Animal
        Animal genericDog = new Dog();
        Animal genericCat = new Cat();

        // We cast now:
        dex.testDog((Dog) genericDog);
        dex.testCat((Cat) genericCat);

        // Try the overloaded methods with
        // specifically typed variables.
        dex.testAnimal((Dog) genericDog);
        dex.testAnimal((Cat) genericCat);

        // Try the overloaded methods with
        // generically typed variables.
        dex.testAnimal(genericDog);
        dex.testAnimal(genericCat);

        // Downcasting in an expression to access a specific method on a
        // more specific type
        if (((Dog) genericDog).getDogString().equals("dog")) {
            System.out.println("Matched!");
        }

        // downcasting a method return type
        Cat c = (Cat) dex.passThrough(genericCat);
        c.printCat();
    }

    //Three Overloaded methods
    public void testAnimal(Animal animal) {
        System.out.println("Executing testAnimal with Animal type");
        animal.printAnimal();
    }

    public void testAnimal(Cat cat) {
        System.out.println("Executing testAnimal with Cat type");
        cat.printAnimal();
    }

    public void testAnimal(Dog dog) {
        System.out.println("Executing testAnimal with Dog type");
        dog.printAnimal();
    }

    // Specifically Typed method calls
    public void testDog(Dog dog) {
        dog.printDog();
    }

    public void testCat(Cat cat) {
        cat.printCat();
    }

    public Object passThrough(Object o) {
        return o;
    }
}