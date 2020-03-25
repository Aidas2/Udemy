package standartTest_01;


//Given:

//package loops;
public class Q17JustLooping {
    private int j;

    void showJ() {
        while (j <= 5) {
            for (int j = 1; j <= 5; ) {
                System.out.print(j + " ");

                j++;
            }
            System.out.println();
            j++;
        }
    }

    public static void main(String[] args) {
        new Q17JustLooping().showJ();
    }
}
//    What is the result?
