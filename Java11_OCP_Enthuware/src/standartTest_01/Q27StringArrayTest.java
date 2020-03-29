package standartTest_01;


//What will be the result of attempting to run the following program?

public class Q27StringArrayTest{
    public static void main(String args[]){
        String[][][] arr  = {{ { "a", "b" , "c"}, { "d", "e", null } },{ {"x"}, null },{{"y"}},{ { "z","p"}, {} }
        };
        System.out.println(arr[0][1][2]);
    }
}
