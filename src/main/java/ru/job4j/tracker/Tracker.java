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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }
}