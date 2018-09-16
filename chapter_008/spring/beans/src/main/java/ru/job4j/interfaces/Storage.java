package ru.job4j.interfaces;

import org.springframework.stereotype.Component;
import ru.job4j.models.User;

@Component
public interface Storage {
    void add(User user);
}
