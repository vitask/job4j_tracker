package ru.job4j.tracker;

public class FindByNameActions implements UserAction {
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (Item items : item) {
                System.out.println(items);
            }
        } else {
            System.out.println("Item with " + name + " name is not found. Try again.");
        }
        return true;
    }
}
