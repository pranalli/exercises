package com.pranalli.portfolio.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sort version numbers divided by periods i.e., 1.0, 0.3.4, etc.
 *
 * @author Pasquale Ranalli
 * <a href="mailto: pranalli@gmail.com>pranalli@gmail.com</a>
 */
public class VersionNumberSorting {

    public static class VersionComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return compare(s1.split("\\."), s2.split("\\."), 0);
        }

        public int compare(String[] arr1, String[] arr2, int index) {
            if (index >= arr1.length && index >= arr2.length) {
                return 0;
            }

            if (index >= arr1.length) {
                return -1;
            }

            if (index >= arr2.length) {
                return 1;
            }

            if (arr1[index].equals(arr2[index])) {
                return compare(arr1, arr2, index + 1);
            }

            Integer v1 = Integer.parseInt(arr1[index]);
            Integer v2 = Integer.parseInt(arr2[index]);
            return v1.compareTo(v2);
        }
    }

    public static void main(String[] args) {
        List<String> versions = new ArrayList<>();
        versions.add("1.0");
        versions.add("2.1");
        versions.add("2.0");
        versions.add("0.1.5");
        versions.add("1.5.1");
        versions.add("1.5.19");
        versions.add("10");

        versions.sort(new VersionComparator());
        System.out.println(versions.toString());
    }
}
