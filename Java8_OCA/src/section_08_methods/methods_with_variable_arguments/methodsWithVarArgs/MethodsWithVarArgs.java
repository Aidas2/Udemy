package section_08_methods.methods_with_variable_arguments.methodsWithVarArgs;

import java.util.Arrays;

/**
 * @author goran on 12/07/2017.
 */
public class MethodsWithVarArgs {

    public void jump1(int... numbers) {
    }

    public void jump2(int start, int... numbers) {
    }

    public void jump5(int[] start, int[] numbers) {
    }

//    public void jump3(int... numbers, int start) {}

//    public void jump4(int... start, int... numbers) {}

    public static void main(String[] args) {
        jump(1);
        jump(2, 3);
        jump(4, 5, 6, 7);
        jump(1, new int[]{4, 5, 6}); // redundant array creation
//        jump(1, null);  // null pointer exception

        run();
        run(11, 22, 33, 44, 55, 66, 77, 88, 99);
    }

    public static void jump(int start, int... numbers) {
        System.out.println("start= " + start + " numbers.length= " + numbers.length);
    }

    public static void run(int... numbers) {
        for (int number : numbers) {
            System.out.println("number= " + number);
        }

        System.out.println(Arrays.toString(numbers));
    }
}
