package ru.job4j.tracker;

import java.util.Arrays;
import java.util.UUID;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;

    private String generateId() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public void update(Item item) {
        String id = item.getId();
        Item one = this.findById(id);
        for (int i = 0; i < items.length; i++) {
            if ((items[i] != null) && (items[i].getId().equals(one.getId()))) {
                items[i] = item;
                break;
            }
        }
    }

    public void delete(Item item) {
        Item found = this.findById(item.getId());
        for (int i = 0; i < items.length; i++) {
            if ((items[i] != null) && (items[i].getId().equals(found.getId())))
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
        }
    }

    public Item[] findAll() {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null)
                result[count++] = items[i];
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if ((items[i] != null) && (this.items[i].getName().equals(key)))
                result[count++] = items[i];
        }
        return result;
    }

    public Item findById(String id) {
        for (int i = 0; i < items.length; i++) {
            if ((items[i] != null) && (this.items[i].getId().equals(id)))
                return items[i];
        }
        return null;
    }
}
