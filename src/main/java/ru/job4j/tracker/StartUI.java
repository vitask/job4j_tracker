package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);

        }
    }

    public void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[] {
                new CreateActions(output),
                new FindAllActions(output),
                new EditActions(output),
                new DeleteActions(output),
                new FindByIdActions(output),
                new FindByNameActions(output),
                new ExitActions(output)
        };
        new StartUI().init(input, tracker, actions);
    }
}
