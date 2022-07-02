package ru.job4j.tracker;

public class ReplaceActions implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Successfully removed");
        } else {
            System.out.println("Removal error. Try again.");
        }
        return true;
    }
}
