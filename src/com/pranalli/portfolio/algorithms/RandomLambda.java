package com.pranalli.portfolio.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class RandomLambda {

    public static List<Integer> randomSublist(List<Integer> list) {
        return list.stream().filter((i) -> Math.random() >= 0.5).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, Integer> counts = new TreeMap<>();
        for (int i = 0; i < 100000; i++) {
            var res = randomSublist(nums).toString();
            var value = counts.getOrDefault(res, 0);
            counts.put(res, ++value);
//            counts.compute(res, (key, value) -> value == null ? 1 : value++);
        }

        counts.forEach((key, value) -> System.out.println(value + " -- " + key));
    }
}
