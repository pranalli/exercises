package com.pranalli.portfolio.exercises.euler;

/**
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {
    public static int smallestDivisibleBy(int maxDivisor) {
        int currNum = maxDivisor * 2;
        int i = maxDivisor;
        while (i > 1) {
            if (isOdd(currNum) || currNum % i != 0) {
                currNum += maxDivisor;
                i = maxDivisor;
            }

            --i;
        }

        return currNum;
    }

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisibleBy(20));
    }
}
