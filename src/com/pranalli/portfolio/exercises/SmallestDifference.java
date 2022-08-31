package com.pranalli.portfolio.exercises;

import com.pranalli.portfolio.algorithms.SortingUtils;

public class SmallestDifference {

    public static int smallestDifference(int[] arr1, int[] arr2) {
        SortingUtils.quickSort(arr1);
        SortingUtils.quickSort(arr2);

        int diff = Integer.MAX_VALUE;
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            int val1 = arr1[i1];
            int val2 = arr2[i2];
            if (val1 == val2) {
                return 0;
            }

            int newDiff = Math.abs(val1 - val2);
            if (diff > newDiff) {
                diff = newDiff;
            }

            // Since we're sorted, we can intelligently move through the arrays
            if (val1 < val2) {
                i1++;
            }
            else {
                i2++;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 15, 11, 2 };
        int[] arr2 = new int[] { 23, 127, 235, 19, 8 };

        System.out.println(smallestDifference(arr1, arr2));
    }
}
