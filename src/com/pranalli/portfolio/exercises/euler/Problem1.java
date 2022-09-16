package com.pranalli.portfolio.exercises.euler;

/**
 *
 */
public class Problem1 {
    public static int sum(int num) {
        int sum = 0;
        if (num == 0) {
            return 0;
        }

        if (isMultipleOfThreeOrFive(num)) {
            System.out.println(num);
            sum += num;
        }

        return sum + sum(--num);
    }

    public static boolean isMultipleOfThreeOrFive(int num) {
        return (num % 3 == 0) || (num % 5 == 0);
    }

    public static void main(String[] args) {
        int num = 999;
        System.out.println(sum(num));
    }
}
