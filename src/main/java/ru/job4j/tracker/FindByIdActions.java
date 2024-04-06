package ru.job4j.tracker;

public class FindByIdActions implements UserAction {
    private final Output out;

    public FindByIdActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = store.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Item with " + id + " id not found. Try again.");
        }
        return true;
    }
}
