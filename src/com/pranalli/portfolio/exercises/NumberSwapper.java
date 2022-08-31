package com.pranalli.portfolio.exercises;

public class NumberSwapper {
    public static class Pair<T, R> {
        T left;
        R right;

        Pair(T t, R r) {
            this.left = t;
            this.right = r;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
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
