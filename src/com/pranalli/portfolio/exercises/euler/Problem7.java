package com.pranalli.portfolio.exercises.euler;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem7 {
    public static final int TARGET = 10001;

    public static long nthPrime(int n) {
        long currPrime = 0;
        long currNum = 2;
        while (n > 0) {
            if (isPrime(currNum)) {
                currPrime = currNum;
                --n;
            }

            ++currNum;
        }

        return currPrime;
    }

    public static boolean isFactor(long target, long divisor) {
        return target % divisor == 0;
    }

    public static boolean isPrime(long target) {
//        if (target > 10) {
//            target = (long) Math.sqrt((double) target);
//        }

        long divisor = target / 2;
        while (divisor > 1) {
            if (isFactor(target, divisor)) {
                return false;
            }

            --divisor;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(nthPrime(TARGET));
    }
}

