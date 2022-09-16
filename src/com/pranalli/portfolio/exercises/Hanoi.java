package com.pranalli.portfolio.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hanoi {
    public static int numberOfMoves(Deque<Integer> sourceTower, Deque<Integer> destinationTower, Deque<Integer> auxTower) {
        int moves = 0;

        return moves;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer>[] towers = new ArrayDeque[3];

        ArrayDeque<Integer> tower1 = new ArrayDeque<>();
        tower1.push(3);
        tower1.push(2);
        tower1.push(1);
        towers[0] = tower1;
        towers[1] = new ArrayDeque<>();
        towers[2] = new ArrayDeque<>();
    }
}
