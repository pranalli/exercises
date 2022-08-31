package com.pranalli.portfolio.exercises;

import com.pranalli.portfolio.structures.Pair;

public class BinaryToString {
    public static String binaryToString(double d) {
        assert(d > 0 && d < 1);
        StringBuilder sb = new StringBuilder(".");
        Result res = null;

        for (int exp = -1; exp > -32; exp--) {
            res = getNextBinaryDecimalDigit(d);
            sb.append(res.binary ? "1" : "0");
            if (res.remainder == 0) {
                break;
            }
            d = res.remainder;
        }
        if (res.remainder != 0) {
            System.out.println("ERROR!!!");
        }
        return sb.toString();
    }
    private static Pair<Double, Double> splitByDecimal(double d) {
        double remainder = d % 2;
        if (remainder > 1) {
            remainder -= 1;
        }

        return new Pair<>(d - remainder, remainder);
    }

    private static Result getNextBinaryDecimalDigit(double d) {
        assert (d < 1);

        d *= 2;
        if (d >= 1) {
            return new Result(true, d - 1);
        }
        else {
            return new Result(false, d);
        }
    }

    private static class Result {
        boolean binary;
        double remainder;

        Result(boolean binary, double remainder) {
            this.binary = binary;
            this.remainder = remainder;
        }
    }

    public static void main(String[] args) {
        System.out.println(binaryToString(0.125));
    }
}
