package ru.job4j.models;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
