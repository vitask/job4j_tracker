package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JobTest {

    @Test
    public void whenAscByName() {
        Comparator<Job> jobComparator = new JobSortAscByName();
        int result = jobComparator.compare(
                new Job("Oleg", 0),
                new Job("Stepan", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> jobComparator = new JobSortAscByPriority();
        int result = jobComparator.compare(
                new Job("Oleg", 0),
                new Job("Stepan", 1)
        );
        assertThat(result).isLessThan(0);
     }

    @Test
    public void whenDescByName() {
        Comparator<Job> jobComparator = new JobSortDescByName();
        int result = jobComparator.compare(
                new Job("Oleg", 0),
                new Job("Stepan", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> jobComparator = new JobSortDescByPriority();
        int result = jobComparator.compare(
                new Job("Oleg", 0),
                new Job("Stepan", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenSortByDescNameAndDescPriority() {
        Comparator<Job> jobComparator = new JobSortDescByName().thenComparing(new JobSortDescByPriority());
        int result = jobComparator.compare(
                new Job("Oleg", 0),
                new Job("Oleg", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenSortByAscNameAndDescPriority() {
        Comparator<Job> jobComparator = new JobSortAscByName().thenComparing(new JobSortDescByPriority());
        int result = jobComparator.compare(
                new Job("Oleg", 0),
                new Job("Oleg", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

}