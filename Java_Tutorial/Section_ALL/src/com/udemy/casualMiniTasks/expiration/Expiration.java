package com.udemy.casualMiniTasks.expiration;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Expiration {
    private static final long EXPIRATION_MINUTES = 10;

    public static void main(String[] args) {




        System.out.println(LocalDate.now());

        System.out.println(LocalDate.now().minusDays(EXPIRATION_MINUTES));
        System.out.println(LocalDate.now().plusDays(EXPIRATION_MINUTES));
    }

}
