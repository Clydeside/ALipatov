package ru.job4j.tracker;

import ru.job4j.tracker.database.TrackerStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Tracker {
    private TrackerStorage storage = TrackerStorage.getInstance();

    private String generateId() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    public Item add(Item item) {
        storage.addItem(item);
        return item;
    }

    public void update(Item item) {
        storage.updateItem(item);
    }

    public void delete(Item item) {
        storage.deleteItem(item);
    }

    public List<Item> findAll() {
        return storage.findAll();
    }

    public List<Item> findByName(String key) {
        return storage.findByName(key);
    }

    public Item findById(String id) {
        return storage.findById(id);
    }
}
