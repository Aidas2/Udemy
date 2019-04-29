package AbstractClass.ChallengeAidasUNSOLVED;

import java.util.ArrayList;
import java.util.List;

public class CompareTo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        //String stringData = "5 7 3 9 8 2 1 0 4 6";
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] data = stringData.split(" ");
        for (String s : data) {
            list.add(s);
        }

//        System.out.println("List: " + list);
        printArrayList(list);


//        printArray(data);
//        int comparison = data[0].compareTo(data[1]);
//        System.out.println(comparison);

        int comparison2 = list.get(0).compareTo(list.get(5));

        System.out.println(list.get(0) + " compare to " + list.get(5) + " is equal = " + comparison2);

    }

    public static void printArray (String[] array) {
        for (String s: array) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }

    public static void printArrayList (List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }

    //public static void compare

}
