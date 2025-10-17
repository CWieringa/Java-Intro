import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * lab6.java
 * fall 2025
 * 
 * Clay Wieringa
 * 
 * convert String to double using Java Collection Stack and Queue
 */

public class lab6 {
    public static void main(String[] args) {

        // test cases - add x3 additional cases here
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);

        // *** add three additional test cases here

        test("987.654", 987.65);
        test("$ 39 ", 39.0);
        test(" -$2,000,000.00", -2000000.00);

    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        boolean decimalFound = false; // *** may or may not use this approach
        boolean negative = false; // *** may or may not use this approach

        // *** add code here ***

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);

                if (!decimalFound) {
                    s.push(digit);
                } else {
                    q.add(digit);
                }

            } else if (c == '.') {
                decimalFound = true;
            }
        }

        double multiply = 1.0;
        while (!s.isEmpty()) {
            int digit = s.pop();

            answer += digit * multiply;
            multiply *= 10;
        }

        double divider = 10.0;
        while (!q.isEmpty()) {
            int digit = q.remove();

            answer += digit / divider;
            divider *= 10;
        }

        if (negative)
            answer = -answer;

        return answer;

    }// toDouble

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (actual == expected)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
