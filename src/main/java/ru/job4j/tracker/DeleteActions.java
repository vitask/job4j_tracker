package ru.job4j.tracker;

public class DeleteActions implements UserAction {
    private final Output out;

    public DeleteActions(Output output) {
        this.out = output;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Successfully removed");
        } else {
            out.println("Removal error. Try again.");
        }
        return true;
    }
}
