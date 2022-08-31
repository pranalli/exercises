package com.pranalli.portfolio.exercises;

public class TicTacToeResolver {

    private static class Board {
        int[][] grid;
        public Board() {
            this(new int[][]{
                    new int[]{0, 0, 0},
                    new int[]{0, 0, 0},
                    new int[]{0, 0, 0}
            });
        }

        public Board(int[][] grid) {
            this.grid = grid;
        }

        public int rowTotal(int rowNum) {
            return getValue(rowNum, 0) + getValue(rowNum, 1) + getValue(rowNum, 2);
        }

        public int colTotal(int colNum) {
            return getValue(0, colNum) + getValue(1, colNum) + getValue(2, colNum);
        }

        public int diagTotal(int leftCornerStartIndex) {
            int rightCornerEndIndex = leftCornerStartIndex == 1 ? 3 : 1;
            return getValue(leftCornerStartIndex, 0) + getValue(1, 1) + getValue(2, rightCornerEndIndex);
        }

        public int isWinner() {
            for (int i = 0; i < 3; i++) {
                if (rowTotal(i) == 3 || colTotal(i) == 3) {
                    return 1;
                }

                if (rowTotal(i) == -3 || colTotal(i) == -3) {
                    return -1;
                }

                if (i != 1 && diagTotal(i) == 3) {
                    return 1;
                }

                if (i != 1 && diagTotal(i) == -3) {
                    return -1;
                }
            }

            return 0;
        }

        private int getValue(int rowNum, int colNum) {
            return grid[rowNum][colNum];
        }
    }

    public static void main(String[] args) {
        var b = new Board(
                new int[][] {
                        new int[] {1, 1, -1},
                        new int[] {0, -1, 0},
                        new int[] {-1, -1, 0}
                }
        );
        System.out.println(b.isWinner());
    }
}
