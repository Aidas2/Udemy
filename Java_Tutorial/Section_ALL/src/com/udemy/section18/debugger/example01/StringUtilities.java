package com.udemy.section18.debugger.example01;

public class StringUtilities {

    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar (StringBuilder sBuilder, char c) {
        sBuilder.append(c);
        charsAdded++;
    }
}
