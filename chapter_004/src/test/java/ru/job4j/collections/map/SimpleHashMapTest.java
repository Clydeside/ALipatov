package ru.job4j.collections.map;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMapTest {
    @Test
    public void addAndContainsAndRemoveTest() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertThat(map.get(1), is("one"));
        assertThat(map.get(2), is("two"));
        assertThat(map.get(3), is("three"));
        map.remove(3);
        assertThat(map.containsKey(1), is(true));
        assertThat(map.containsKey(2), is(true));
        assertThat(map.containsKey(3), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        Iterator it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("three"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}