package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Added a new Item: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Storage is empty. Add item.");
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ===");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(id, name);
                if (tracker.replace(id, item)) {
                    System.out.println("Successfully replaced");
                } else {
                    System.out.println("Replaced error. Try again.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Successfully removed");
                } else {
                    System.out.println("Removal error. Try again.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item with " + id + " id not found. Try again.");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                String name = input.askStr("Enter name: ");
                Item[] item = tracker.findByName(name);
                if (item.length > 0) {
                    for (Item items : item) {
                        System.out.println(items);
                    }
                } else {
                    System.out.println("Item with " + name + " name is not found. Try again.");
                }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Unknown operation.");
            }
        }
    }

    public void showMenu() {
        String[] menu = new String[]{"Add new Item", "Show all items",
                "Edit item", "Delete item", "Find item by id",
                "Find item by name", "Exit Program"};
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
