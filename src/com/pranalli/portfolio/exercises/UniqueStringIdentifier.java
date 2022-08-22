package com.pranalli.portfolio.exercises;

import java.util.Set;
import java.util.HashSet;

/**
 * <h1>Unique String Identifier - Exercise</h1>
 * <p>
 * The problem is defined as simply identifying whether a given string
 * consists of all unique characters.  Various implementation experiments
 * are included.
 * </p>
 */
class UniqueStringIdentifier {

    /**
     * This method takes a string input and returns whether all characters
     * are unique.  It utilizes a HashSet which makes for efficient and clean
     * code at the expense of a small amount of additional memory.
     *
     * @param s String
     * @return Whether the given string consists of all unique characters.
     */
    public static boolean isUniqueStringWithHashSet(String s) {
        Set<Character> dict = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (dict.contains(currChar)) {
                return false;
            }

            dict.add(currChar);
        }

        return true;
    }

    /**
     * This implementation solves the problem without utilizing any additional data structures.
     */
    public static boolean isUniqueStringWithOutDataStructures(String s) {
        int lastIndex = s.length() - 1;

        for (int leftIndex = 0; leftIndex <= lastIndex; leftIndex++) {
            char leftChar = s.charAt(leftIndex);

            int rightIndex = lastIndex;
            while (rightIndex > leftIndex) {
                char rightChar = s.charAt(rightIndex);
                if (leftChar == rightChar) {
                    return false;
                }

                rightIndex--;
            }
        }

        return true;
    }

    /**
     * A secondary implementation that also does not use additional data structures, but
     * attempts to shorten runtime by comparing the middle index to the left and right
     * indexes simultaneously.  It does not seem to be a particularly good solution overall,
     * but was an interesting exercise nonetheless.
     */
    public static boolean isUniqueStringWithOutDataStructures2(String s) {
        for (int i = 0; i < s.length(); i++) {
            int leftIndex = 0;
            int rightIndex = s.length() - 1;
            int middleIndex = (rightIndex - i) / 2;
            char middleChar = s.charAt(middleIndex);

            while (leftIndex < middleIndex || rightIndex > middleIndex) {
                if (leftIndex < middleIndex && s.charAt(leftIndex) == middleChar) {
                    return false;
                }

                if (rightIndex > middleIndex && s.charAt(rightIndex) == middleChar) {
                    return false;
                }

                leftIndex++;
                rightIndex--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "abcdefghijklmnopqrstuvwxyza";
        int iterations = 1000;
        int m1Total = 0;
        for (int i = 1; i < iterations; i++) {
            long start1 = System.nanoTime();
            isUniqueStringWithOutDataStructures(s2);
            m1Total += System.nanoTime() - start1;
        }

        float avgTime = ((float) m1Total / iterations) / 1000;
        System.out.println("Method ran on average: " + avgTime + " milliseconds");
//		System.out.println(isUniqueStringWithOutDataStructures(s1));
//		System.out.println(isUniqueStringWithOutDataStructures2(s1));

//		System.out.println(isUniqueStringWithHashSet(s2));
//		System.out.println(isUniqueStringWithOutDataStructures(s2));
//		System.out.println(isUniqueStringWithOutDataStructures2(s2));
    }
}
