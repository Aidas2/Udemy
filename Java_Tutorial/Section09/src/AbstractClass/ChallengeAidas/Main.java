package AbstractClass.ChallengeAidas;

import AbstractClass.ChallengeTimPart3.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        //String stringData = "5 7 3 9 8 2 1 0 4 6";
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        String[] data = stringData.split(" ");
        for (String s : data) {
            list.add(s);
        }

        //printArray


        int comparison = data[0].compareTo(data[1]);
        System.out.println(comparison);

    }






    public void printArray (String[] array) {
        for (String s: array) {
            System.out.println(s);
        }
    }


}
