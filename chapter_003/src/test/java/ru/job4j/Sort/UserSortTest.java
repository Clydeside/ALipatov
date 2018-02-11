package ru.job4j.Sort;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;

public class UserSortTest {
    @Test
    public void userSortTest() {
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(
                new User("C", 3),
                new User("A", 4),
                new User("E", 1),
                new User("D", 2),
                new User("B", 5)
        ));

        Set<User> result = new SortUser().sort(list);
        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(
                new User("D", 2),
                new User("E", 1),
                new User("C", 3),
                new User("A", 4),
                new User("B", 5)
        ));
        assertThat(result, is(expected));
    }
}
