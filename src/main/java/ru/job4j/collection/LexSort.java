package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] str1 = o1.split("\\.", 2);
        String[] str2 = o2.split("\\.", 2);
        int num1 = Integer.parseInt(str1[0]);
        int num2 = Integer.parseInt(str2[0]);
        return Integer.compare(num1, num2);
    }
}
