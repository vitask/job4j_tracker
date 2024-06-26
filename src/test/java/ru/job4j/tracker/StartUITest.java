package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreatedItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Test", "1"});
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateActions(output),
                new ExitActions(output)
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Test"));
    }

    @Test
    public void whenEditItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        String edit = "Edit Test";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), edit, "1"});
        List<UserAction> actions = Arrays.asList(
                new EditActions(output),
                new ExitActions(output)
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(edit));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = Arrays.asList(
                new DeleteActions(output),
                new ExitActions(output)
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = Arrays.asList(
                new FindByIdActions(output),
                new ExitActions(output)
        );
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "Program closed." + ln
        ));
    }

    @Test
    public void whenShowAllItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(
                new String[]{"0", "1"});
        List<UserAction> actions = Arrays.asList(
                new FindAllActions(output),
                new ExitActions(output)
        );
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "Program closed." + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"});
        List<UserAction> actions = Arrays.asList(
                new FindByNameActions(output),
                new ExitActions(output)
        );
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by name ===" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "Program closed." + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        List<UserAction> actions = Arrays.asList(
                new ExitActions(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 - 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Program closed." + ln
        ));
    }
}