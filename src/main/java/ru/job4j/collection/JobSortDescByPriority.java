package ru.job4j.collection;

import java.util.Comparator;

public class JobSortDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return Integer.compare(right.getPriority(), left.getPriority());
    }
}
