package ru.job4j.lambda.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {
    public void multiply(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; ++index) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiply(1, 11, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiply %s * %s = %s\n", value, index, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
