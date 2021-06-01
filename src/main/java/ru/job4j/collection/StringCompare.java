package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int length = Math.min(o1.length(), o2.length());
        for (int i = 0; i < length; i++) {
            int rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return o1.length() < o2.length() ? -1 : o1.length() - o2.length() == 0 ? 0 : 1;
    }
}
