package com.pranalli.portfolio.exercises;

import java.util.Arrays;

public class WordFrequency {
    public static long wordCount(String word, String[] book) {
        return Arrays.stream(book).filter(word::equals).count();
    }
}
