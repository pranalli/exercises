package com.pranalli.portfolio.exercises.euler;

import static com.pranalli.portfolio.utils.MathUtils.isFactor;
import static com.pranalli.portfolio.utils.MathUtils.isPrime;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    public static final long TARGET = 600851475143L;
//    public static final long TARGET = 11111111199L;

    public static long largestPrimeFactor(long target) {
        System.out.println("Looking...");
        long start = (target / 2) ;
        System.out.println(start + " :: Start");
        while (start > 1) {
            if (isFactor(target, start)) {
                System.out.println(start + " is a factor of " + TARGET);

                int sqrt = (int) Math.floor(Math.sqrt(start));
                if (isPrime(start, sqrt)) {
                    return start;
                }
            }

            start -= 2;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(TARGET));
    }
}
