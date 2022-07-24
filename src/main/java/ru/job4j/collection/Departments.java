package ru.job4j.collection;

import java.util.*;

import static java.util.Collections.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.isEmpty() ? el :  start + "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> element) {
        element.sort(Comparator.naturalOrder());

    }

    public static void sortDesc(List<String> element) {
        element.sort(new DepDescComp());
    }
}
