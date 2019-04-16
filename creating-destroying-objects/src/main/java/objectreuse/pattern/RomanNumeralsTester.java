package objectreuse.pattern;

import objectreuse.pattern.RomanNumerals;
import objectreuse.pattern.RomanNumerals_improved;

public class RomanNumeralsTester {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        RomanNumerals.isRomanNumeral("MMMMDXLVI");
        long endTime = System.nanoTime();

        System.out.println("Execution time in milliseconds : " +
                (double)(endTime - startTime) / 1000000);

        startTime = System.nanoTime();
        RomanNumerals_improved.isRomanNumeral("MMMMDXLVI");
        endTime = System.nanoTime();

        System.out.println("Execution time after improvement in milliseconds : " +
                (double)(endTime - startTime) / 1000000);
    }
}
