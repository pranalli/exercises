package com.pranalli.portfolio.structures;

public class Pair<L, R> {
    public L left;
    public R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Pair(" + left + "," + right + ")";
    }
}
