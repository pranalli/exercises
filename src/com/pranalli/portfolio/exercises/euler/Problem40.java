package com.pranalli.portfolio.exercises.euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 *
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem40 {
    static final int MAX = 1000000;

    public static String champernowne() {
        int x = 1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < MAX) {
            sb.append(x);
            x++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] values = new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000 };
        String champ = champernowne();
//        System.out.println(champ);
//        System.out.println(champ.charAt(14));
        long sum = 1;
        for (int i : values) {
            int v = Character.getNumericValue(champ.charAt(i - 1));
            sum *= v;
            System.out.println(v);
        }
        System.out.println(sum);
    }
}

