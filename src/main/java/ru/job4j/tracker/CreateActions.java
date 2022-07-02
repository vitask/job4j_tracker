package ru.job4j.tracker;

public class CreateActions implements UserAction {
    private final Output out;

    public CreateActions(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Added a new Item: " + item);
        return true;
    }
}
