package ru.job4j.max;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest class.
 *
 * * @author Artem Lipatov
 * */

public class MaxTest {

    /**
     * * Test.
     * *
     * * @author Artem Lipatov
     * */

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 4);
        assertThat(result, is(4));
    }

    /**
     * * Test.
     * *
     * * @author Artem Lipatov
     * */

    @Test
    public void whenFirstLargerThanSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 2);
        assertThat(result, is(5));
    }
}
