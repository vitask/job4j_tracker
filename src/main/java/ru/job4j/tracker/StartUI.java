package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 - " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);

        }
    }

    public void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store store = new SqlTracker()) {
            List<UserAction> actions = Arrays.asList(
                    new CreateManyItems(output),
                    new FindAllActions(output),
                    new EditActions(output),
                    new DeleteAllItems(output),
                    new FindByIdActions(output),
                    new FindByNameActions(output),
                    new ExitActions(output)
            );
            new StartUI(output).init(input, store, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}