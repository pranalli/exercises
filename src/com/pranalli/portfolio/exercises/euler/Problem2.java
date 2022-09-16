package com.pranalli.portfolio.exercises.euler;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem2 {
    public static final int MAX = 4000000;
    public static int fibEvenSum(int num1, int num2) {
        if (num1 > MAX || num2 > MAX) {
            return 0;
        }

        int sum = 0;
        int newNum = num1 + num2;
        if (newNum % 2 == 0) {
            sum += newNum;
        }

        return sum + fibEvenSum(num2, newNum);
    }

    public static void main(String[] args) {
        System.out.println(fibEvenSum(0, 1));
    }
}
