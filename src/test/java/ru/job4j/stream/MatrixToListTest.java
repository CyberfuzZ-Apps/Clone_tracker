package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void testConvert() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> rsl = matrixToList.convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(rsl, is(expected));
    }

    @Test
    public void testConvert2() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> rsl = matrixToList.convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(rsl, is(expected));
    }
}