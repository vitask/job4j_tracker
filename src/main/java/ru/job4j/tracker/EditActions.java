package ru.job4j.tracker;

public class EditActions implements UserAction {
    private final Output out;

    public EditActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            out.println("Successfully replaced");
        } else {
            out.println("Replaced error. Try again.");
        }
        return true;
    }
}
