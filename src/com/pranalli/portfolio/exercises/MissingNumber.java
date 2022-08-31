package com.pranalli.portfolio.exercises;

import java.util.Arrays;

public class MissingNumber {
    public static int findMissing(int[] arr) {
        Arrays.sort(arr);

        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                check = arr[i] & 1; // Get first bit of int
            }
            else {
                check = check ^ 1;  // Flip the bit on each iteration
            }

            int currBit = arr[i] & 1;
            if (currBit != check) {
                return arr[i] - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15 };
        System.out.println(findMissing(arr));
    }
}
