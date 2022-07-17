package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item("Pavel"),
                new Item("Dima"),
                new Item("Vlad"),
                new Item("Oleg")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Dima"),
                new Item("Oleg"),
                new Item("Pavel"),
                new Item("Vlad")

        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item("Pavel"),
                new Item("Dima"),
                new Item("Vlad"),
                new Item("Oleg")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Vlad"),
                new Item("Pavel"),
                new Item("Oleg"),
                new Item("Dima")

        );
        assertThat(items).isEqualTo(expected);
    }
}