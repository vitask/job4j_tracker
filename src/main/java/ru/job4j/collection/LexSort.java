package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftC = left.split("\\. ");
        String[] rightC = right.split("\\. ");
        int leftInt = Integer.parseInt(leftC[0]);
        int rightInt = Integer.parseInt(rightC[0]);
        return Integer.compare(leftInt, rightInt);
    }
}
