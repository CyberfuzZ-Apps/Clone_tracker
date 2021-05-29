package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String or : origin) {
            check.add(or.toLowerCase());
        }
        for (String txt : text) {
            if (!check.contains(txt.toLowerCase())) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
