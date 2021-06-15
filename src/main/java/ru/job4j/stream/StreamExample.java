package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 4, -3, 5, -1, -4, 6));
        List<Integer> list = arrayList.stream().filter(x -> x >= 0)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
