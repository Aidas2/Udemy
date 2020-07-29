package section_12_lambda_expressions.using_lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goran on 24/07/2017.
 */
class Animal {
    private String type;
    private boolean canJump;
    private boolean canSwim;

    public Animal(String type, boolean canJump, boolean canSwim) {
        this.type = type;
        this.canJump = canJump;
        this.canSwim = canSwim;
    }

    public boolean canJump() {
        return canJump;
    }

    public boolean canSwim() {
        return canSwim;
    }

    public String getType() {
        return type;
    }
}

interface CheckAnimal {
    boolean check(Animal animal);
}

class CheckCanJump implements CheckAnimal {

    @Override
    public boolean check(Animal animal) {
        return animal.canJump();
    }
}

interface AnotherCheck {
    boolean check(Animal first, Animal second);
}

public class LambdaExpressions {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("dog", true, true));


        print(animals, new CheckCanJump());

        print(animals, animal -> animal.canSwim());
        print(animals, animal -> !animal.canSwim());

        print(animals, (Animal animal) -> {
            return animal.canJump();
        });

        print(animals, (Animal animal) -> {
//            Animal animal = new Animal("cat", true, false);
            System.out.println("checking animal= " + animal.getType());
            return animal.canJump();
        });

        Animal fish = animals.get(0);
        Animal rabbit = animals.get(1);
        Animal dog = animals.get(2);

        print(fish, rabbit, (f, s) -> f.canJump() && s.canSwim());
        print(fish, dog, ((first, second) -> first.canSwim() && second.canSwim()));
    }

    private static void print(Animal first, Animal second, AnotherCheck check) {
        System.out.println(check.check(first, second));
    }

    private static void print(List<Animal> animals, CheckAnimal filter) {
        for (Animal animal : animals) {
            if (filter.check(animal)) {
                System.out.println(animal.getType());
            }
        }

        System.out.println();
    }
}
