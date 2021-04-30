package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;

public class PointTest {
    @Test
    public void whenDistance111To333Then3Dot46() {
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(3, 3, 3);
        double result = point1.distance3d(point2);
        double expected = 3.46;
        Assert.assertThat(expected, closeTo(result, 0.01));
    }

    @Test
    public void whenDistance111To555Then6Dot92() {
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(5, 5, 5);
        double result = point1.distance3d(point2);
        double expected = 6.92;
        Assert.assertThat(expected, closeTo(result, 0.01));
    }

    @Test
    public void whenDistance000To953Then10Dot72() {
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(9, 5, 3);
        double result = point1.distance3d(point2);
        double expected = 10.72;
        Assert.assertThat(expected, closeTo(result, 0.01));
    }
}