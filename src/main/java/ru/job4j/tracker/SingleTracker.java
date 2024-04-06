package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {

    private static SingleTracker trackerMethods = null;

    private Store store = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getTrackerMethods() {
        if (trackerMethods == null) {
            trackerMethods = new SingleTracker();
        }
        return trackerMethods;
    }

    public Item add(Item item) {
        return store.add(item);
    }

    public Item findById(int id) {
        return store.findById(id);
    }

    public List<Item> findAll() {
        return store.findAll();
    }

    public List<Item> findByName(String key) {
        return store.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return store.replace(id, item);
    }

    public void delete(int id) {
         store.delete(id);
    }
}
