package standartTest_01;

public class Q24Loops {

    public static void main(String[] args) {

        //    Consider the following code:
        String[] dataList = {"x", "y", "z"};
        for(var dataElement : dataList) {
            int innerCounter = 0;
            while (innerCounter < dataList.length) {
                System.out.println(dataElement + ", " + innerCounter);
                innerCounter++;
            }
        }

    }
}
//    How many times will the output contain 2?