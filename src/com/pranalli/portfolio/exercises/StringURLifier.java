package com.pranalli.portfolio.exercises;

/**
 * <h1>URLify String - Exercise</h1>
 * <p>
 *     This problem is identified as requiring that all non-trailing
 *     whitespace within a given string be replaced with "%20" and
 *     that there is sufficient space within the string to do so.
 * </p>
 */
public class StringURLifier {
    private static final char MARK = ' ';

    public static String urlify(char[] arr, int trueLength) {
        for (int currIndex = 0; currIndex < trueLength; currIndex++) {
            if (arr[currIndex] == MARK) {
                trueLength += 2;  // Expands by 2 because the first char replaces the space (' ' becomes '%20')
                for (int rightIndex = (trueLength - 1); rightIndex > currIndex; rightIndex--) {
                    arr[rightIndex] = arr[rightIndex - 2];
                }

                arr[currIndex] = '%';
                arr[++currIndex] = '2';
                arr[++currIndex] = '0';
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        int len = 13;
        System.out.println(urlify(s.toCharArray(), len));
    }
}
