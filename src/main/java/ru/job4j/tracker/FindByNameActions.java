package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (Item items : item) {
                out.println(items);
            }
        } else {
            out.println("Item with " + name + " name is not found. Try again.");
        }
        return true;
    }
}
