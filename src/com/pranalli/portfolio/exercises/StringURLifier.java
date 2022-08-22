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
        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == MARK) {
                trueLength += 2;
                for (int j = (trueLength - 1); j > i; j--) {
                    arr[j] = arr[j - 2];
                }

                arr[i] = '%';
                arr[++i] = '2';
                arr[++i] = '0';
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
