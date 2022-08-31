package com.pranalli.portfolio.exercises;

import java.util.Arrays;

public class CardShuffle {
    public static int[] shuffle(int[] deck) {
        for (int i = 0; i < deck.length; i++) {
            var rand = (int) (Math.random() * (deck.length));
            if (i != rand) {
                deck[i] = deck[i] + deck[rand];
                deck[rand] = deck[i] - deck[rand];
                deck[i] = deck[i] - deck[rand];
            }
        }

        return deck;
    }

    private static int[] getDeck() {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i + 1;
        }

        return deck;
    }

    public static void main(String[] args) {
        int[] d = getDeck();
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(shuffle(d)));

    }
}
