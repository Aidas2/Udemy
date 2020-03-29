package standartTest_01;


//What will the following program print?
public class Q34Initial{
    static boolean b;
    static int[] ia = new int[1];
    static char ch;
    static boolean[] ba = new boolean[1];
    public static void main(String args[]) throws Exception{
        System.out.println(b+" "+ia.toString()+" "+ch+" "+ba.toString());
        var x = false;
        if( b ){
            x = ( ch == ia[ch]);
        }
        else x = ( ba[ch] = b );
        System.out.println(x+" "+ba[ch]);
    }
}