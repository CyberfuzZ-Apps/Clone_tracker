package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String o1First = o1.split("/")[0];
        String o2First = o2.split("/")[0];
        int rsl = o2First.compareTo(o1First);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
