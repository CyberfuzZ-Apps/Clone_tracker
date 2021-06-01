package ru.job4j.collection;

import java.util.Comparator;
/*
Вы можете использовать
String.charAt(int index)
Integer.compare(int left, int right),
Character.compare(char left, char right);
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int length = Math.min(o1.length(), o2.length());
        for (int i = 0; i < length; i++) {
            rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        if (o1.length() < o2.length()) {
            rsl = -1;
        } else if (o1.length() > o2.length()) {
            rsl = 1;
        }
        return rsl;
    }
}
