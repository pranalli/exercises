package com.pranalli.portfolio.exercises;

/**
 * <h1>Bit Insertion</h1>
 * <p>
 *     This problem is defined as the need to insert bits M into bits N,
 *     at the given indexes J through I.  It assumes there is room for
 *     the bits to fit.
 * </p>
 *
 * @author Pasquale Ranalli
 * <a href="mailto:pranalli@gmail.com>pranalli@gmail.com</a>
 */
public class BitInsertion {

    /**
     * @param destination The int where the bits will be inserted.
     * @param source The int representing the bits to be inserted.
     * @param start The first index to begin insertion.
     * @param end The last index to end insertion.
     * @return The new int value with all bits inserted accordingly.
     */
    public static int insertBits(int destination, int source, int start, int end) {
        int nextSourceBitIndex = 0;
        while (start >= end) {
            boolean nextSourceBit = getBit(source, nextSourceBitIndex);
            destination = updateBit(destination, start - 1, nextSourceBit);
            start--;
            nextSourceBitIndex++;
        }

        return destination;
    }

    /*
     * Retrieve the bit from the given int at the given position.
     */
    public static boolean getBit(int source, int pos) {
        return (source & 1 << pos) != 0;
    }

    /*
     * Update the bit of the given int at the given position by the
     * given value.
     */
    public static int updateBit(int source, int pos, boolean value) {
        int asBit = value ? 1 : 0;
        int bitmask = ~(1 << pos);
        return (source & bitmask) | asBit << pos;
    }

    public static void main(String[] args) {
        int n = 0b10000000000;
        int m = 0b11011;
        int i = 2;
        int j = 6;

        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(insertBits(n, m, j, i)));
    }
}
