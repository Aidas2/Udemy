package standartTest_01;

//In the following code what will be the output if 0 (integer value zero) is passed to loopTest()?
public class Q25Loops {
    public static void main(String[] args) {
        loopTest(0);

    }

    public static void loopTest(int x) {
        loop:
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                System.out.println("i= " + i);
                if (x == 0) {
                    continue loop;
                }
                System.out.println("j= " + j);
            }
        }
    }
}

