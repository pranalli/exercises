package com.pranalli.portfolio.exercises;

import com.pranalli.portfolio.structures.Pair;

public class NumberSwapper {

    public static Pair<Integer, Integer> swap(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;

        return new Pair<>(x, y);
    }

    public static void main(String[] args) {
        var pair = new Pair<>(5, 3);
        System.out.println("Before\n" + pair);
        System.out.println("After\n" + swap(pair.left, pair.right));
    }
}
