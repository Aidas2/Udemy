package com.udemy.section18.debuggerJunit.challengeAidas;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar() throws Exception{
        //fail("Test_1 failed. This test has not been implemented");
        Utilities util = new Utilities();

        //version_01:
        char[] initial = new char[]{'h','e','l','l','o'};
        char[] afterMethod = util.everyNthChar(initial, 2);
        char[] expected = new char[]{'e', 'l'};
        assertArrayEquals(expected, afterMethod);

        //version_02:
        char[] afterMethod2 = util.everyNthChar(new char[]{'h','e','l','l','o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, afterMethod2);

        //another case:
        char[] initial3 = new char[]{'h','e','l','l','o'};
        char[] afterMethod3 = util.everyNthChar(new char[]{'h','e','l','l','o'}, 100);
        assertArrayEquals(initial3, afterMethod3);

    }

    @Test
    public void removePairs() throws Exception {
        //fail("Test_2 failed. This test has not been implemented");
        Utilities util = new Utilities();
        String result1 = util.removePairs("AABCDDEFF");
        String result2 = util.removePairs("ABCCABDEEF");
        assertEquals("ABCDEF", result1);
        assertEquals("ABCABDEF", result2);
        assertNull("There is a fuc***g null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @Test
    public void converter() throws Exception {
        //fail("Test_3 failed. This test has not been implemented");
        Utilities util = new Utilities();
        int result = util.converter(10, 5);
        assertEquals(300, result);
    }

    @Test (expected = ArithmeticException.class)
    public void converter2() throws Exception{
        Utilities util = new Utilities();
        util.converter(10, 0);
        fail("Should have thrown an  ArithmeticException (divide by 0)");
    }

    @Test
    public void nullIfOddLength() throws  Exception {
        //fail("Test_4 failed. This test has not been implemented");
        Utilities util = new Utilities();
//        assertEquals("Hello!", util.nullIfOddLength("Hello!"));
//        assertNull("Yes, its a null", util.nullIfOddLength("Hello"));
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));

    }
}