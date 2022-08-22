package com.pranalli.portfolio.exercises;

import com.pranalli.portfolio.algorithms.SortingUtils;

import java.util.Arrays;

/**
 * <h1>Exercise - String Permutation Identifier</h1>
 * <p>
 *     This problem is defined as identifying two strings that are permutations of one-another.
 * </p>
 *
 * @author Pasquale A. Ranalli
 * <a href="mailto:pranalli@gmail.com">pranalli@gmail.com</a>
 */
class StringPermutationIdentifier {

	/**
	 * This method returns a boolean value indicating if the two strings are permutations of one-another.
	 * Flags for case and space (white space) sensitivity can be used as desired.
	 *
	 * @param s1 String
	 * @param s2 String
	 * @param caseInsensitive Set to true to enable case-insensitivity i.e., 'I' == 'i'.
	 * @param spaceInsensitive Set to true to enable whitespace-insensitivity where leading or trailing whitespace will
	 *                         be excluded from the comparison.
	 * @return Whether the given strings are permutations of one-another, taking into account the above flags.
	 */
	public static boolean isPermutation(String s1, String s2, boolean caseInsensitive, boolean spaceInsensitive) {
	    if (caseInsensitive) {
	    	return isPermutation(s1.toLowerCase(), s2.toLowerCase(), false, spaceInsensitive);
		}

	    if (spaceInsensitive) {
	    	return isPermutation(s1.trim(), s2.trim(), false, false);
		}

		if (s1.length() != s2.length()) {
			return false;
		}

		return Arrays.equals(
			SortingUtils.insertionSort(s1.toCharArray()),
			SortingUtils.insertionSort(s2.toCharArray())
		);
	}

	// Test cases
	public static void main(String[] args) {
		String s1 = "I am Groot";
		String s2 = "Am I groot?";
		String s3 = "I am groot";
		String s4 = "I am Groot   ";
		boolean caseInsensitive = true;
		boolean spaceInsensitive = false;

		System.out.println(isPermutation(s1, s2, caseInsensitive, spaceInsensitive));
		System.out.println(isPermutation(s1, s3, caseInsensitive, spaceInsensitive));
		System.out.println(isPermutation(s1, s4, caseInsensitive, spaceInsensitive));
	}
}
