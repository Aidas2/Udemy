package standartTest_01;

public class Q30Double {

    //    Given the following code snippet:
    public static void main(String[] args) {
        int rate = 10;
        int t = 5;
        double amount = 1000.0;
        for (int i = 0; i < t; i++) {
            amount = amount * (1 - rate / 100);
        }
        System.out.println(amount);
//    What can XXX be?
    }

}
