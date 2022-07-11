package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public final class SingleTracker {

    private static SingleTracker trackerMethods = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getTrackerMethods() {
        if (trackerMethods == null) {
            trackerMethods = new SingleTracker();
        }
        return trackerMethods;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
