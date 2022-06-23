package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemResult = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                itemResult[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemResult, size);
    }

    public Item[] findByName(String key) {
        Item[] itemResult = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                if (key.equals(item.getName())) {
                    itemResult[size] = item;
                    size++;
                }
            }
        }
        return Arrays.copyOf(itemResult, size);
    }
}
