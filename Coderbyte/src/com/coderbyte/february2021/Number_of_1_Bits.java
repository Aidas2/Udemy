package com.february2021;

public class Number_of_1_Bits {
    public static void main(String[] args) {
        hammingWeight_1(00000000000000000000000001001011);
        hammingWeight_2(00000000000000000000000001001011);
    }

//    public static int hammingWeight(int n) {
////        String str =Integer.toString(n);
//        int charCode = Integer.parseInt(n, 2);
//        System.out.println(str);
//        int count = 0;
//        Character c1 = new Character('1');
//        for (int i = 0; i < str.length(); i++) {
//            Character c2 = new Character(str.charAt(i));
//            if(c2.equals(c1)) {
//                count++;
//            }
//        }
//        System.out.println(count);
//        return count;
//    }

    public static int hammingWeight_1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        System.out.println("bits: " + bits);
        return bits;
    }

    public static int hammingWeight_2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        System.out.println("sum: " + sum);
        return sum;
    }
}
