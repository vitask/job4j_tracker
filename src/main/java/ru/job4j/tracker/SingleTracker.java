package ru.job4j.tracker;

import java.util.Arrays;

public final class SingleTracker {

    private static SingleTracker trackerMethods = null;

    private SingleTracker() {
    }

    public static SingleTracker getTrackerMethods() {
        if (trackerMethods == null) {
            trackerMethods = new SingleTracker();
        }
        return trackerMethods;
    }

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
