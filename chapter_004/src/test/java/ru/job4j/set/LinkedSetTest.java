package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class LinkedSetTest {
    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        LinkedSet<Integer> set = new LinkedSet<>();
        set.add(150);
        set.add(78);
        set.add(11);
        set.add(11);

        Iterator<Integer> it = set.iterator();

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(78));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(150));
        it.next();
    }
}