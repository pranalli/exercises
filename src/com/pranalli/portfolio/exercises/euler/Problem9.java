package com.pranalli.portfolio.exercises.euler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
    public static final int TARGET = 1000;

    public static int pyTriplet(int target) {
        for (int a = 0; a <= target; a++) {
            for (int b = a + 1; b <= target; b++) {
                for (int c = b + 1; c <= target; c++) {
                    boolean isPythag = (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2));
                    int sum = a + b + c;
                    if (isPythag && sum == target) {
                        System.out.println("A: " + a + " : A^2: " + Math.pow((double) a, 2));
                        System.out.println("B: " + b + " : B^2: " + Math.pow((double) b, 2));
                        System.out.println("C: " + c + " : C^2: " + Math.pow((double) c, 2));
                        return a * b * c;
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(pyTriplet(TARGET));
    }
}

