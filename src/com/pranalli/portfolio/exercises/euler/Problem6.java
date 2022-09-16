package com.pranalli.portfolio.exercises.euler;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * The square of the sum of the first ten natural numbers is,
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 */
public class Problem6 {

    public static int sumOfSquares(int num) {
        if (num == 1) {
            return 1;
        }

        int squareNum = num * num;
        return squareNum + sumOfSquares(--num);
    }

    public static int squareOfSum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        return sum * sum;
    }

    public static void main(String[] args) {
        int num = 100;
        int num1 = sumOfSquares(num);
        int num2 = squareOfSum(num);
        System.out.println("Sum of Squares: " + num1);
        System.out.println("Square of Sum: " + num2);
        System.out.println(Math.abs(sumOfSquares(num) - squareOfSum(num)));
    }
}
