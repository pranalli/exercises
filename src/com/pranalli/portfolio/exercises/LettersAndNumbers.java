package com.pranalli.portfolio.exercises;

import java.util.*;

public class LettersAndNumbers {
    public static char[] evenLettersAndNumbers(char[] arr) {
        int maxSize = arr.length - (arr.length % 2);
        int start = 0;
        int end = maxSize - 1;
        return evenLettersAndNumbers(arr, maxSize, start, end);
    }

    public static char[] evenLettersAndNumbers(char[] arr, int maxSize, int start, int end) {
        int count = 0;
        int winnerWinner = maxSize / 2;
        for (int i = start; i <= end; i++) {
            if (Character.isDigit(arr[i]))
                count++;

            if (count > winnerWinner) {
                break;
            }
        }

        if (count == winnerWinner)
            return Arrays.copyOfRange(arr, start, end + 1);

        if (end < arr.length - 1) {
            return evenLettersAndNumbers(arr, maxSize, start + 1, end + 1);
        }
        else if (maxSize > 2) {
            int newMaxSize = maxSize - 2;
            return evenLettersAndNumbers(arr, newMaxSize, 0, newMaxSize - 1);
        }

        return null;
    }

    public static void main(String[] args) {
        char[] arr = new char[] { '1', 'a', 'q', 'c', 'b', '7', '5', 'j', '6' };
        System.out.println(Arrays.toString(evenLettersAndNumbers(arr)));
    }
}
