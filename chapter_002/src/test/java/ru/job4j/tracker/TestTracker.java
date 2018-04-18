package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestTracker {
    @Test
    public void add() {
        Tracker tracker = new Tracker();
        Item item = new Item("1", "test","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0).getId(), is(item.getId()));
        tracker.delete(item);
    }

    @Test
    public void update() {
        Tracker tracker = new Tracker();
        Item item = new Item("1","test","testDescription",123L);
        tracker.add(item);
        item.setDesc("Description");
        tracker.update(item);
        String result = "Description";
        assertThat(tracker.findAll().get(0).getDesc(), is(result));
        tracker.delete(item);
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1","test1","testDescription",1234L);
        Item item2 = new Item("2","test2","testDescription",1235L);
        Item item3 = new Item("3","test3","testDescription",1236L);
        Item item4 = new Item("4","test4","testDescription",1237L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item3);
        ArrayList<Item> result = new ArrayList<>(100);
        result.add(item1);
        result.add(item2);
        result.add(item4);
        assertThat(tracker.findAll().get(0).getName(), is("test1"));
        assertThat(tracker.findAll().get(1).getName(), is("test2"));
        assertThat(tracker.findAll().get(2).getName(), is("test4"));
        tracker.delete(item1);
        tracker.delete(item2);
        tracker.delete(item4);
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("1","test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0).getId(), is(item.getId()));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("1","test1","testDescription",1234L);
        Item item2 = new Item("2","test","testDescription",1235L);
        Item item3 = new Item("3","test","testDescription",1236L);
        Item item4 = new Item("4","test2","testDescription",1237L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        ArrayList<Item> result = new ArrayList<>(100);
        result.add(item2);
        result.add(item3);
        assertThat(tracker.findByName("test").size(), is(2));
        tracker.delete(item1);
        tracker.delete(item2);
        tracker.delete(item3);
        tracker.delete(item4);
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item("1","test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
        tracker.delete(item);
    }
}
