package com.pranalli.portfolio.exercises;

import java.util.Arrays;

/**
 * Problem is defined as designing a matrix such that when any node is set to 0,
 * the entire row and column for which it intersects is also set to 0.
 *
 * @author Pasquale Ranalli
 */
public class ZeroMatrix {
    private final int[][] matrix;
    private final int mSize;
    private final int nSize;

    public ZeroMatrix(int m, int n) {
        matrix = new int[m][n];
        mSize = m;
        nSize = n;
    }

    public void insert(int value, int mPos, int nPos) {
        if (mPos < mSize && nPos < nSize) {
            matrix[mPos][nPos] = value;

            if (value == 0) {
                zeroOutRow(mPos);
                zeroOutColumn(nPos);
            }
        }
    }

    private void zeroOutRow(int rowNum) {
        for (int colNum = 0; colNum < nSize; colNum++) {
            matrix[rowNum][colNum] = 0;
        }
    }

    private void zeroOutColumn(int colNum) {
        for (int rowNum = 0; rowNum < nSize; rowNum++) {
            matrix[rowNum][colNum] = 0;
        }
    }

    private void print() {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        ZeroMatrix zm = new ZeroMatrix(3, 3);
        zm.insert(1, 0, 0);
        zm.insert(1, 1, 0);
        zm.insert(1, 2, 0);
        zm.insert(1, 0, 1);
        zm.insert(1, 0, 2);
        zm.insert(1, 1, 1);
        zm.insert(1, 1, 2);
        zm.insert(1, 2, 1);
        zm.insert(1, 2, 2);

        zm.insert(0, 1, 1);

        zm.print();
    }
}
