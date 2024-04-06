package ru.job4j.tracker;

public class ExitActions implements UserAction {
    private final Output out;

    public ExitActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("Program closed.");
        return false;
    }
}
