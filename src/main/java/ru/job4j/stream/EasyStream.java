package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
/*
В этом задании Вам нужно реализовать каркас упрощенного Stream API.
EasyStream работает только с типом Integer. В нем есть четыре метода

of - получает исходные данные.
map - преобразует число в другое число.
filter - фильтрует поток элементов.
collect - собирает все элементы из source по заданным условиям map и filter.

В этом задании нужно использовать шаблон Builder.
 */
public class EasyStream {
    private List<Integer> list;

    public EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        if (!source.isEmpty()) {
            List<Integer> rslList = new ArrayList<>(source);
            return new EasyStream(rslList);
        }
        return new EasyStream(List.of());
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, fun.apply(list.get(i)));
        }
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        list.removeIf(num -> !fun.test(num));
        return this;
    }

    public List<Integer> collect() {
        return list;
    }
}
