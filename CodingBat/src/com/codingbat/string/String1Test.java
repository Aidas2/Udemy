package com.codingbat.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class String1Test {

    private String strInput;
    private String strExpected;

    public String1Test(String strInput, String strExpected) {
        this.strInput = strInput;
        this.strExpected = strExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"Bob", "Hello Bob!"},
                {"Alice", "Hello Alice!"},
                {"X", "Hello X!"}
        });

    }

    @Test
    public void helloName() throws Exception {

        String result = String1.helloName(strInput);
        assertEquals(strExpected, result);
    }

}