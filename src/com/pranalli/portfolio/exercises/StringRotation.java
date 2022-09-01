package com.pranalli.portfolio.exercises;

/**
 * I have to admit that I looked up some hints on this one.
 * So simple!
 */
public class StringRotation {
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        s2 += s2;
        return isSubString(s1, s2);
    }

    public static boolean isSubString(String s1, String s2) {
        return s2.contains(s1);
    }
}
