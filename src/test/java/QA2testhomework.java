import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class QA2testhomework {

    @Test

    public void calculatorPercentage() {
        double mortgageCalculatordouble;
        double loanAmount = 100000.00;
        int yearsMortgage = 30;
        double interestRate = 2;

        double percentegeCalculator1 = interestRate / 100;
        double percentageCalculator2 = percentegeCalculator1 * loanAmount;
        double sumToReturn = loanAmount + percentageCalculator2;

        System.out.println("Start sum " + loanAmount + " Current percentige " + percentageCalculator2
                + " Total amount to return is " + sumToReturn);

    }

    @Test
    public void characterAmount() {

        String string = "StuffWrittenHere";

        System.out.println(" Amount of characters: " + string.length());


    }

    @Test
    public void wordCount() {

        System.out.println("Simple Java Word Count Program");

        String str1 = "Word count";

        String[] wordArray = str1.trim().split("\\s+");
        int wordCount = wordArray.length;

        System.out.println("Word count is = " + wordCount);
    }

    @Test
    public void codeDistance() {
        int x1, x2, y1, y2;
        double dis;
        x1 = 1;
        y1 = 1;
        x2 = 4;
        y2 = 4;
        dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        System.out.println("distancebetween" + "(" + x1 + "," + y1 + ")," + "(" + x2 + "," + y2 + ")===>" + dis);
    }
}













