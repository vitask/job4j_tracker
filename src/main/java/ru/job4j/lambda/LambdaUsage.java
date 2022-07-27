package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("Oleg", "Stepan", "Seven", "Anna", "Kolya");
        System.out.println(name);
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        name.sort(cmpText);
        System.out.println(name);
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        name.sort(cmpDescSize);
        System.out.println(name);
    }
}
