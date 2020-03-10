package section_03_PrimitiveData;

public class Test {
    static int i;
    public static void main(String[] args) {

        int i, j, k= 10; // Line 1
        i = Test.i+k; // Line 2
        k = i+++k;  // Line 3
        System.out.println(i);
        System.out.println(k);
//        Test.i = j+i; // Line 4
        System.out.println(i+" " +k);



        boolean input1 = true, input2 = false;  // Line 1
        boolean result1 = input1 = !input1; // Line 2
        boolean result2 = input2 = input1;  // Line 3
        boolean result3 = input1 == (result1=!input2);  // Line 4
        System.out.println(input1+" " +input2 + " " +  result2 + " " + result3);
    }

}
