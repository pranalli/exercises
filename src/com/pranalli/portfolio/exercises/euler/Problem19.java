package com.pranalli.portfolio.exercises.euler;

import java.util.*;
import java.util.function.Function;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19 {

    public static int countSundaysOnFirst() {
        int year = 1900;
        int dayCount = Month.getDaysInYear(year++);
        int sundayCount = 0;
        Deque<Month> months = new ArrayDeque<>(Arrays.asList(Month.values()));
        while (year < 2001) {
            int dayMod = dayCount % 7;
            if (Day.dayByValue(dayMod) == Day.SUN) {
                sundayCount++;
            }

            Month m = months.pop();
            dayCount += m.days.apply(year);
            if (m == Month.DEC) {
                year++;
            }
            months.addLast(m);
        }

        return sundayCount;
    }

    public static void main(String[] args) {
        System.out.println(countSundaysOnFirst());
    }

    private enum Month {
        JAN((year) -> 31),
        FEB((year) -> {
            boolean isCentury = year % 100 == 0;
            if ((isCentury && year % 400 == 0) || (!isCentury && year % 4 == 0)) {
                return 29;
            }

            return 28;
        }),
        MAR((year) -> 31),
        APR((year) -> 30),
        MAY((year) -> 31),
        JUN((year) -> 30),
        JUL((year) -> 31),
        AUG((year) -> 31),
        SEP((year) -> 30),
        OCT((year) -> 31),
        NOV((year) -> 30),
        DEC((year) -> 31);
        private final Function<Integer, Integer> days;
        Month(Function<Integer, Integer> days) {
            this.days = days;
        }

        static int getDaysInYear(int year) {
            return Arrays.stream(Month.values()).map(m -> m.days.apply(year)).reduce(0, Integer::sum);
        }
    }
    private enum Day {
        MON (0),
        TUE (1),
        WED (2),
        THU (3),
        FRI (4),
        SAT (5),
        SUN (6);

        private static final Map<Integer, Day> lookup = new HashMap<>();
        private final int value;
        Day(int value) {
            this.value = value;
        }

        static Day dayByValue(int value) {
            if (lookup.isEmpty()) {
                cache();
            }

            return lookup.get(value);
        }

        private static void cache() {
            for (Day d : Day.values()) {
                lookup.put(d.value, d);
            }
        }
    }
}

