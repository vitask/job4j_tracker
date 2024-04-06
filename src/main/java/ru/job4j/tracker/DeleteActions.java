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
    public boolean execute(Input input, Store store) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        Item item = store.findById(id);
        store.delete(id);
        out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
        return true;
    }
}
