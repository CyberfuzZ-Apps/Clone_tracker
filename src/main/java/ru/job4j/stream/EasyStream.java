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

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rslList = new ArrayList<>(list);
        for (int i = 0; i < rslList.size(); i++) {
            rslList.set(i, fun.apply(rslList.get(i)));
        }
        return new EasyStream(rslList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rslList = new ArrayList<>(list);
        rslList.removeIf(num -> !fun.test(num));
        return new EasyStream(rslList);
    }

    public List<Integer> collect() {
        return List.copyOf(list);
    }
}
