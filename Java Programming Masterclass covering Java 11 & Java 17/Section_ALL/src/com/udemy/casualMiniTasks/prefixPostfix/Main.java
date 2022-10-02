package com.udemy.casualMiniTasks.prefixPostfix;

public class Main {

    public static void main(String[] args) {

        int playerLives = 3;

//        playerLives--;
        System.out.println("Lives remaining = " + playerLives--);
        System.out.println("Lives is now " + playerLives);

        // playerScore is current set to 2
        System.out.println("And subtracting 1 from lives = " + --playerLives);

        // playerScore is current set to 1
        System.out.println("Lives remaining = " + playerLives++); // Output should be 1
        System.out.println("Lives is now " + playerLives); // Output should be 2
        System.out.println("And adding 1 to lives = " + ++playerLives); // Output should be 3

        // playerScore is current set to 3
        playerLives++;
        System.out.println("Lives remaining = " + playerLives); // Output should be 4
        playerLives--;
        System.out.println("Lives remaining = " + playerLives); // Output should be 3
        ++playerLives;
        System.out.println("Lives remaining = " + playerLives); // Output should be 4
        --playerLives;
        System.out.println("Lives remaining = " + playerLives); // Output should be 3
    }
}
