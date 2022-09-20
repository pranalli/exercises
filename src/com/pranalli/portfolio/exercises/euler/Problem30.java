package com.pranalli.portfolio.exercises.euler;

import java.util.*;
import java.util.function.Function;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {

    public static void main(String[] args) {
        int powerOf = 5;
        int[] lookup = new int[10];
        for (int i = 0; i < 10; i++) {
            lookup[i] = (int) Math.pow(i, powerOf);
        }

        int max = 100000000;//(int) Math.pow(9, powerOf) * 2;
        List<Integer> results = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            String s = String.valueOf(i);
            int tmp = 0;
            for (char c : s.toCharArray()) {
                tmp += lookup[Character.getNumericValue(c)];
            }

            if (tmp == i) {
                results.add(i);
            }
        }

        System.out.println(results.stream().reduce(0, Integer::sum));
    }
}

