package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void convert() {
        List<Student> studentList = List.of(
                new Student(50, "Ivan"),
                new Student(30, "Alex"),
                new Student(90, "Evgeniy"),
                new Student(50, "Ivan"),
                new Student(30, "Alex")
        );
        ListToMap listToMap = new ListToMap();
        Map<String, Student> rsl = listToMap.convert(studentList);
        Map<String, Student> expected = Map.of(
                "Ivan", new Student(50, "Ivan"),
                "Alex", new Student(30, "Alex"),
                "Evgeniy", new Student(90, "Evgeniy")
        );
        assertThat(rsl, is(expected));
    }
}