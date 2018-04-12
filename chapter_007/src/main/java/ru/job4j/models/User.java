package ru.job4j.models;

public class User {
    private int id;
    private String name;
    private String login;
    private String country;
    private Role role;

    public User() {
    }

    public User(String name, String login, String country, Role role) {
        this.name = name;
        this.login = login;
        this.country = country;
        this.role = role;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getCountry() {
        return country;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return name + login;
    }
}
