package com.udemy.encapsulationChallenge;

public class Printer {

    private int tonerLevel = 8;
    private int numbersOfPagePrinted = 0;
    private boolean duplex = true;

    public Printer(int tonerLevel, int numbersOfPagePrinted, boolean duplex) {

        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }

        this.numbersOfPagePrinted = numbersOfPagePrinted;
        this.duplex = duplex;
    }


    public int fillUpTheToner (int addedAmountOfToner) {
        if (this.tonerLevel + addedAmountOfToner >= 100) {
            return this.tonerLevel = 100;
        } else {
            return this.tonerLevel += addedAmountOfToner;
        }

    }

    public int printPage (int numberOfPageToPrint) {
        if (this.duplex) {
            return this.numbersOfPagePrinted += (numberOfPageToPrint / 2 + numberOfPageToPrint % 2);
        } else {
            return this.numbersOfPagePrinted += numberOfPageToPrint;
        }
    }

    public int getNumbersOfPagePrinted() {
        return numbersOfPagePrinted;
    }
}


