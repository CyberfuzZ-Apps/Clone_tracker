package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String o1First = o1.split("/")[0];
        String o2First = o2.split("/")[0];
        if (o1First.equals(o2First)) {
            rsl = o1.compareTo(o2);
        } else {
            rsl = o2First.compareTo(o1First);
        }
        return rsl;
    }
}
