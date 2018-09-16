package ru.job4j.interfaces;

import ru.job4j.models.User;

import java.util.List;

public interface Storage {
    List<User> getAll();

    void add(User user);
}
