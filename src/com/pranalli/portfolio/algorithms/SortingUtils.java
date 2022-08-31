package com.pranalli.portfolio.algorithms;

import java.util.Arrays;

/**
 * <h1>Sorting Utilities</h1>
 *
 * @author Pasquale Ranalli
 * <a href="mailto:pranalli@gmail.com">pranalli@gmail.com</a>
 */
public class SortingUtils {

    /**
     * Sorts the given int[] by utilizing an implementation of the common "insertion sort" algorithm.
     *
     * @param arr Array to sort.
     * @return Sorted array.
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i];
            int priorIdx = i - 1;

            while (priorIdx >= 0 && currNum < arr[priorIdx]) {
                arr[priorIdx + 1] = arr[priorIdx];
                --priorIdx;
            }

            arr[priorIdx + 1] = currNum;
        }

        return arr;
    }

    /**
     * Identical to {@link SortingUtils#insertionSort(int[])} but for a char[].
     */
    public static char[] insertionSort(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            char currNum = arr[i];
            int priorIdx = i - 1;

            while (priorIdx >= 0 && currNum < arr[priorIdx]) {
                arr[priorIdx + 1] = arr[priorIdx];
                --priorIdx;
            }

            arr[priorIdx + 1] = currNum;
        }

        return arr;
    }

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);

            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }

        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int left = start;
        while (left < pivot) {
            if (arr[left] > arr[pivot]) {
                swapIndexes(arr, left, pivot);
                swapIndexes(arr, left, --pivot);
            }
            else {
                left++;
            }
        }

        return pivot;
    }

    private static void swapIndexes(int[] arr, int i1, int i2) {
        if (i1 != i2) {
            arr[i1] = arr[i1] + arr[i2];
            arr[i2] = arr[i1] - arr[i2];
            arr[i1] = arr[i1] - arr[i2];
        }
    }

    /**
     * Sorts the given int[] by utilizing an implementation of the common "bubble sort" algorithm.
     *
     * @param arr Array to sort.
     * @return Sorted array.
     */
    public static int[] bubbleSort(int[] arr) {
        for (int currIndex = 0; currIndex < arr.length; currIndex++) {
            for (int nextIndex = currIndex + 1; nextIndex < arr.length; nextIndex++) {
                int currValue = arr[currIndex];
                int nextValue = arr[nextIndex];

                // If the current number is greater than the next, swap them.
                if (currValue > nextValue) {
                    arr[currIndex] = nextValue;
                    arr[nextIndex] = currValue;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{ 1, 0, 12, 32, 3, -54, 10000, 600, 22, 5, -100000, -67, 67, 25, -1, -1, -1 };
//        int[] insertionSorted = insertionSort(Arrays.copyOf(testArr, testArr.length));
//        int[] bubbleSorted = bubbleSort(Arrays.copyOf(testArr, testArr.length));
        int[] quickSorted = quickSort(Arrays.copyOf(testArr, testArr.length));

        System.out.println(Arrays.toString(testArr));
//        System.out.println(Arrays.toString(insertionSorted));
//        System.out.println(Arrays.toString(bubbleSorted));
        System.out.println(Arrays.toString(quickSorted));
    }
}
