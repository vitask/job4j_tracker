package ru.job4j.tracker;

import java.util.List;

public class FindByNameActions implements UserAction {
    private final Output out;

    public FindByNameActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = store.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Item with " + name + " name is not found. Try again.");
        }
        return true;
    }
}
