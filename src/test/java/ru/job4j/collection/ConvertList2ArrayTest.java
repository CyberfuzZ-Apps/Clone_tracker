package ru.job4j.collection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        int[][] result = ConvertList2Array.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when14ElementsThen16() {
        int[][] result = ConvertList2Array.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14),
                4
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 0}
        };
        assertThat(result, is(expect));
    }
}