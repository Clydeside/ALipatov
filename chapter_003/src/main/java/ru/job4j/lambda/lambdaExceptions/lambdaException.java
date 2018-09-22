package ru.job4j.lambda.lambdaExceptions;

import java.util.Arrays;
import java.util.List;

public class lambdaException {
    public static void badMethod() throws Exception {
    }

    public static interface Wrapper<T> {
        T get();
        void set(T value);
        boolean isEmpty();
    }

    public static void main(String[] args) throws Exception {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        final StringBuilder last = new StringBuilder();
        names.forEach(
                n ->  {
                    last.ensureCapacity(0);
                    last.append(n);
                }
        );

        Wrapper<Exception> ex = null;
        names.forEach(n -> {
            try {
                badMethod();
            } catch (Exception e) {
                ex.set(e);
            }
        });
        if (!ex.isEmpty()) {
            throw ex.get();
        }
        System.out.println(names);
    }
}
