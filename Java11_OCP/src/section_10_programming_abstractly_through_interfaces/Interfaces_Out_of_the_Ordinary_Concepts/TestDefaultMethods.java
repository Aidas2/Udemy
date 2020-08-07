/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 10: Programming Abstractly Through Interfaces
Topic: Create and implement interfaces
*/

// Teachable interface with abstract method teach
// and default method teachTheseLessons
interface Teachable {

    // default method
    default void teachTheseLessons() {
        System.out.println("Everyone should learn art and music");
    }

    void teach();
}

// Trainable interface with abstract method train
// and default method teachTheseLessons
interface Trainable {

    // default method
    default void teachTheseLessons() {
        System.out.println("Train them to do this");
    }

    void train();
}

// Our class implements one of these interfaces for now
public class TestDefaultMethods implements Teachable, Trainable {

    // we implement teach and call the default method
    public void teach() {
        teachTheseLessons();
    }

    // we implement train for later use
    public void train() {
        System.out.println("Everyone can be trained to get up early");

    }

    // default method override
    public void teachTheseLessons() {
        System.out.println("Everyone should learn math and science");
    }

    // main method calls teach and train() methods
    public static void main(String[] args) {
        TestDefaultMethods t = new TestDefaultMethods();
        t.teach();
        t.train();
    }
}