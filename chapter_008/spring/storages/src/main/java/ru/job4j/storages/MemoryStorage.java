package ru.job4j.storages;

import org.springframework.stereotype.Component;
import ru.job4j.interfaces.Storage;
import ru.job4j.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryStorage implements Storage {
    private ArrayList<User> list = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return list;
    }

    @Override
    public void add(User user) {
        list.add(user);
    }
}
