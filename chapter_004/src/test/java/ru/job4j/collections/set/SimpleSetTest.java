package ru.job4j.collections.set;

import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleSetTest {
    @Test
    public void addTest() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(150);
        set.add(78);
        set.add(11);
        set.add(11);
        assertThat(set.toArray(), is(new Integer[] {150, 78, 11}));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(150);
        set.add(78);
        set.add(11);
        set.add(11);

        assertThat(set.hasNext(), is(true));
        assertThat(set.next(), is(150));
        assertThat(set.hasNext(), is(true));
        assertThat(set.next(), is(78));
        assertThat(set.hasNext(), is(true));
        assertThat(set.next(), is(11));
        set.next();
    }
}