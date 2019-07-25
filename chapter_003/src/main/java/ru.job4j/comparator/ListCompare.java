package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = left.length() < right.length() ? left.length() : right.length();
        int rsl = 0;
        for (int index = 0; index != length; index++) {
            rsl = Integer.compare(left.charAt(index), right.charAt(index));
            if (rsl != 0) {
                break;
            }
        }
        return rsl != 0 ? rsl : Integer.compare(left.length(), right.length());
    }
}