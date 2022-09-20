package com.pranalli.portfolio.utils;

public class MathUtils {
    public static boolean isFactor(long target, long divisor) {
        return target % divisor == 0;
    }

    public static boolean isPrime(long target, long divisor) {
        if (target != 2 && isEven(target)) {
            return false;
        }

        if (target > 100) {
            target = (long) Math.sqrt(target);
        }

        while (divisor > 1) {
            if (isFactor(target, divisor)) {
                return false;
            }

            --divisor;
        }

        return true;
    }

    public static boolean isEven(long target) {
        return target % 2 == 0;
    }

    public static boolean isOdd(long target) {
        return !isEven(target);
    }
}
