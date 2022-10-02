package com.udemy.section18.debuggerJunit.challengeAidas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

//challenge#10 - multiple test condition (using Parametrized)

@RunWith(Parameterized.class)
public class UtilitiesTest3Parametrized {

    private Utilities util;
    private String input;
    private String output;

    public UtilitiesTest3Parametrized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @org.junit.Before   //to perform before each test (no need to repeatedly create instances}
    public void setup() {
        util = new Utilities();
        System.out.println("Running a test... ");


    }

//    @Test
//    public void everyNthChar() throws Exception{
//
//        //version_01:
//        char[] initial = new char[]{'h','e','l','l','o'};
//        char[] afterMethod = util.everyNthChar(initial, 2);
//        char[] input = new char[]{'e', 'l'};
//        assertArrayEquals(input, afterMethod);
//
//        //version_02:
//        char[] afterMethod2 = util.everyNthChar(new char[]{'h','e','l','l','o'}, 2);
//        assertArrayEquals(new char[]{'e', 'l'}, afterMethod2);
//
//        //another case:
//        char[] initial3 = new char[]{'h','e','l','l','o'};
//        char[] afterMethod3 = util.everyNthChar(new char[]{'h','e','l','l','o'}, 100);
//        assertArrayEquals(initial3, afterMethod3);
//
//    }

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
    public void removePairs() throws Exception {

        String result = util.removePairs(input);
        assertEquals(output, result);
    }

//    @Test
//    public void converter() throws Exception {
//
//        int output = util.converter(10, 5);
//        assertEquals(300, output);
//    }
//
//    @Test (input = ArithmeticException.class)
//    public void converter2() throws Exception{
//
//        util.converter(10, 0);
//        fail("Should have thrown an  ArithmeticException (divide by 0)");
//    }
//
//    @Test
//    public void nullIfOddLength() throws  Exception {
//
////        assertEquals("Hello!", util.nullIfOddLength("Hello!"));
////        assertNull("Yes, its a null", util.nullIfOddLength("Hello"));
//        assertNull(util.nullIfOddLength("odd"));
//        assertNotNull(util.nullIfOddLength("even"));
//
//    }

}