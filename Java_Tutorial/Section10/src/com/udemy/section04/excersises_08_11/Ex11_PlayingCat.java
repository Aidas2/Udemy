package com.udemy.section04.excersises_08_11;

public class Ex11_PlayingCat {

    public static boolean isCatPlaying (boolean summer, int temperature) {
        if (summer == false && temperature >= 25 && temperature <= 35 ) {
            return true;
        } else if (summer == true && temperature >= 25 && temperature <= 45 ) {
            return true;
        } else return false;
    }

}
