package ru.job4j.lambda.references;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import ru.job4j.lambda.functionalInterface.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MathUtilTest {
    @Test
    public void firstTest() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiply(0, 3, 2,
                MathUtil::add,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(2D, 3D, 4D)));
    }
    @Test
    public void mulTest() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiply(1, 4, 2,
                MathUtil::mul,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(2D, 4D, 6D)));
    }
}