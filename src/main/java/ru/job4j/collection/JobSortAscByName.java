package ru.job4j.collection;

import java.util.Comparator;

public class JobSortAscByName implements Comparator<Job> {

    @Override
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }
}
