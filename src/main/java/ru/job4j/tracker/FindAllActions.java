package ru.job4j.tracker;

import java.util.List;

public class FindAllActions implements UserAction {
    private final Output out;

    public FindAllActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Storage is empty. Add item.");
        }
        return true;
    }
}
