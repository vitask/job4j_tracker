package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreatedItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Test", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new CreateActions(output),
                new ExitActions(output)
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Test"));
    }

    @Test
    public void whenEditItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        String edit = "Edit Test";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), edit, "1"});
        UserAction[] actions = new UserAction[]{
                new EditActions(output),
                new ExitActions(output)
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(edit));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = new UserAction[]{
                new DeleteActions(output),
                new ExitActions(output)
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}