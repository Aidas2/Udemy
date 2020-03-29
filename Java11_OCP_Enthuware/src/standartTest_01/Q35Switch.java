package standartTest_01;


//What is the result of executing the following code when the value of i is 5:
public class Q35Switch {
    public static void main(String[] args) {
        printNumber(5);
    }

    public static void printNumber(int i) {
        switch (i) {
            default:
            case 1:
                System.out.println(1);
            case 0:
                System.out.println(0);
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
        }
    }

}


