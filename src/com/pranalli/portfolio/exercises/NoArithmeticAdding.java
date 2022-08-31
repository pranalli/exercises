package com.pranalli.portfolio.exercises;

/**
 * Design an function that adds two integers without using arithmetic operators.
 *
 * Note: This is one of the few exercises where I had to look up a hint.  I knew I needed bitwise
 * operators, specifically XOR, but needed a refresher on the carried value.
 *
 * @author Pasquale Ranalli
 * <a href="mailto:pranalli@gmail.com>pranalli@gmail.com</a>
 */
public class NoArithmeticAdding {
    public static void main(String[] args) {
        int x = 25;
        int y = 50;
        while (y != 0) {
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }

        System.out.println(x);
    }
}
