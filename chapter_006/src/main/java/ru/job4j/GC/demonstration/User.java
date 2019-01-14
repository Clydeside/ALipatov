package ru.job4j.GC.demonstration;

public class User {
    public User() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(System.out.format("DESTROYING %s", this));
    }
}
