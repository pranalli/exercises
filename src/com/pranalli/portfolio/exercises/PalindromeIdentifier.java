package com.pranalli.portfolio.exercises;

import java.util.function.Function;

/**
 * <h1>Exercise - Palindrome Identifier</h1>
 * <p>
 *     The problem is defined as identifying whether a given string is
 *     a palindrome, ignoring non-alpha characters.
 * </p>
 *
 * @author Pasquale A. Ranalli
 * <a href="mailto:pranalli@gmail.com">pranalli@gmail.com</a>
 */
public class PalindromeIdentifier {

    /**
     * This method checks whether the given string is a palindrome, ignoring
     * any and all non-alphabetic characters.
     *
     * @param s String to check
     * @return Whether the given string is a palindrome.
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;
        char leftChar;
        char rightChar;
        while (left < right) {
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);

            if (!Character.isAlphabetic(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isAlphabetic(rightChar)) {
                right--;
                continue;
            }

            if (leftChar == rightChar) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "taco cat";
        String s2 = "a man a plan a canal panama";
        String s3 = "racec%ar12 34&321";
        String s4 = "racerac";

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
        System.out.println(isPalindrome(s4));
    }
}
