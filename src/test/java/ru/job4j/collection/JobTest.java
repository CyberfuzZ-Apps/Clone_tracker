package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Mix bugs", 2);
        Job job3 = new Job("Fix bug", 4);
        Job job4 = new Job("X task", 0);
        List<Job> rsl = Arrays.asList(job1, job2, job3, job4);
        List<Job> expected = Arrays.asList(job4, job2, job1, job3);
        Collections.sort(rsl, new JobDescByName());
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenComparatorByNameAsc() {
        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Mix bugs", 2);
        Job job3 = new Job("Fix bug", 4);
        Job job4 = new Job("X task", 0);
        List<Job> rsl = Arrays.asList(job1, job2, job3, job4);
        List<Job> expected = Arrays.asList(job1, job3, job2, job4);
        Collections.sort(rsl, new JobAskByName());
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Mix bugs", 2);
        Job job3 = new Job("Fix bug", 4);
        Job job4 = new Job("X task", 0);
        List<Job> rsl = Arrays.asList(job1, job2, job3, job4);
        List<Job> expected = Arrays.asList(job3, job2, job1, job4);
        Collections.sort(rsl, new JobDescByPriority());
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Mix bugs", 2);
        Job job3 = new Job("Fix bug", 4);
        Job job4 = new Job("X task", 0);
        List<Job> rsl = Arrays.asList(job1, job2, job3, job4);
        List<Job> expected = Arrays.asList(job4, job1, job2, job3);
        Collections.sort(rsl, new JobAscByPriority());
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Fix bug", 2);
        Job job3 = new Job("Fix bug", 4);
        Job job4 = new Job("X task", 0);
        List<Job> rsl = Arrays.asList(job1, job2, job3, job4);
        List<Job> expected = Arrays.asList(job3, job2, job1, job4);
        Collections.sort(rsl, new JobDescByPriority().thenComparing(new JobDescByName()));
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Job job1 = new Job("Fix bug", 1);
        Job job2 = new Job("Fix bug", 2);
        Job job3 = new Job("Fix bug", 4);
        Job job4 = new Job("X task", 0);
        List<Job> rsl = Arrays.asList(job1, job2, job3, job4);
        List<Job> expected = Arrays.asList(job4, job1, job2, job3);
        Collections.sort(rsl, new JobAscByPriority().thenComparing(new JobAskByName()));
        assertThat(expected, is(rsl));
    }
}