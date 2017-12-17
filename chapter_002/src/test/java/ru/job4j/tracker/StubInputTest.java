package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StubInputTest {
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        String result = item.getId();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(result, is(tracker.findAll()[0].getId()));
    }

    @Test
    public void updateTest() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1"));
        Item item2 = tracker.add(new Item("name2"));
        Item item3 = tracker.add(new Item("name3"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item2.getId()), is(nullValue()));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1"));
        Item item2 = tracker.add(new Item("name2"));
        Item item3 = tracker.add(new Item("name3"));
        String result = item2.getId();
        Input input = new StubInput(new String[]{"4", item2.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(result, is(tracker.findAll()[1].getId()));
        assertThat(tracker.findById(item2.getId()).getId(), is(result));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name"));
        Item[] result = new Item[100];
        result[0] = item;
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("name"), is(result) );
    }
}
