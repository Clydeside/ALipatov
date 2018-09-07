package ru.job4j;

import org.springframework.stereotype.Component;
import ru.job4j.models.User;

@Component
public class MemoryStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("Store to memory!");
    }
}
