package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                1, -2, 3, 5, -9, -12, 22, 14, -19, 0, 6
        );
        List<Integer> positive = numbers.stream().filter(
                task -> task > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
