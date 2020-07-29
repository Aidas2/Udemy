package com.codingbat.warmup;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class Warmup2TestParameterized {

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });

    }

    @Test
    public void stringMatch() throws Exception {

    }



    @org.junit.Test
    public void noTriples() {
    }

    @org.junit.Test
    public void has271() {
    }

    @org.junit.Test
    public void absolute() {
    }
}