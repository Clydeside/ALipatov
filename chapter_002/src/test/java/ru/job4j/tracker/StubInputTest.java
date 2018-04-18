package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StubInputTest {
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("1");
        String id = item.getId();
        Input input = new StubInput(new String[]{"0", id, "test name", "desc", "6"});
        new StartUI(input, tracker).startWorking();
        assertThat(id, is(tracker.findAll().get(0).getId()));
        tracker.delete(item);
    }

    @Test
    public void updateTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("1");
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "test name", "desc", "6"});
        new StartUI(input, tracker).startWorking();
        assertThat(tracker.findById(id).getName(), is("test name"));
        tracker.delete(item);
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("1"));
        Item item2 = tracker.add(new Item("2"));
        Item item3 = tracker.add(new Item("3"));
        String id = item2.getId();
        Input input = new StubInput(new String[]{"3", id, "6"});
        new StartUI(input, tracker).startWorking();
        assertThat(tracker.findAll().size(), is(2));
        tracker.delete(item1);
        tracker.delete(item3);
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("name1"));
        Item item2 = tracker.add(new Item("name2"));
        Item item3 = tracker.add(new Item("name3"));
        String result = item2.getId();
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).startWorking();
        assertThat(result, is(tracker.findAll().get(1).getId()));
        assertThat(tracker.findById(item2.getId()).getId(), is(result));
        tracker.delete(item1);
        tracker.delete(item2);
        tracker.delete(item3);
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("1", "name"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).startWorking();
        assertThat(tracker.findByName("name").get(0).getName(), is("name") );
        tracker.delete(item);
    }
}
