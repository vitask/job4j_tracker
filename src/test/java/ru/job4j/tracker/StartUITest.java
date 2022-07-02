package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Test");
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId()),
                "Edited test"};
        StartUI.editItem(new StubInput(answer), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("Edited test"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Test");
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answer), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);

    }
}