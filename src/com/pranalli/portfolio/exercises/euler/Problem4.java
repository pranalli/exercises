package com.pranalli.portfolio.exercises.euler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

    public static int largestPalindromeProduct(int x, int y) {
        return largestPalindromeProduct(x, y, 0);

    }

    public static int largestPalindromeProduct(int x, int y, int minPalindrome) {
        int product = x * y;
        if (product <= minPalindrome) {
            return minPalindrome;
        }

        if (isPalindrome(product)) {
            minPalindrome = product;
        }

        if (y > 0) {
            minPalindrome = largestPalindromeProduct(x, y - 1, minPalindrome);
        }

        if (x > 0) {
            minPalindrome = largestPalindromeProduct(x - 1, x - 1);
        }

        return minPalindrome;
    }

    public static int largestPalindromeProduct(int x) {
        int minPalindrome = 0;
        while (x > 99) {
            for (int i = x; i > 99; i--) {
                int product = x * i;
                if (product > minPalindrome && isPalindrome(product)) {
                    minPalindrome = product;
                }
            }

            --x;
        }

        return minPalindrome;
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }

            ++leftIndex;
            --rightIndex;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(largestPalindromeProduct(999));
    }
}
