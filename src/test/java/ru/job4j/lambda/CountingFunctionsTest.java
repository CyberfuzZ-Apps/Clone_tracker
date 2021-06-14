package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountingFunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        CountingFunctions functions = new CountingFunctions();
        List<Double> result = functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        CountingFunctions functions = new CountingFunctions();
        List<Double> result = functions.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        CountingFunctions functions = new CountingFunctions();
        List<Double> result = functions.diapason(5, 8, x -> Math.pow(2D, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}