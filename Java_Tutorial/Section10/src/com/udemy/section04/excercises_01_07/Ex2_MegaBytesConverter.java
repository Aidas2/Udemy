package com.udemy.section04.excercises_01_07;

public class Ex2_MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes (int kiloBytes) {

        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaBytes = Math.round(kiloBytes / 1024);
            int remainingKiloBytes = kiloBytes % 1024;

            //System.out.println(megaBytes + " MB");
            //System.out.println(remainingKiloBytes + " KB");
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");

        }

    }
}


// 1 MB = 1024 KB