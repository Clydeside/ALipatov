package ru.job4j.lambda.functionalInterface;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void multiplyTest() throws Exception {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiply(1, 4, 1,
                (value, index) -> (double) value * index,
                result -> buffer.add(result)
                );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}