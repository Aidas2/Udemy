package chap01;

public class Exercise1b {
    public static void main(String[] args) {
       arKompiliuojasi1();
       arKompiliuojasi2();
    }


    public static void arKompiliuojasi1() {
        int x = 1;
        while (x < 10) {
            x = x + 1;
            if (x > 3) {
                System.out.println("big x");
            }
        }
    }

    public static void arKompiliuojasi2() {
        int x = 5;
        while (x > 1) {
            x = x - 1;
            if (x < 3) {
                System.out.println("small x");
            }
        }
    }
}
