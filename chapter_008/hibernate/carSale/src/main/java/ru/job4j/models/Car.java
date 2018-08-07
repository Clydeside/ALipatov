package ru.job4j.models;

public class Car {
    private int id;
    private String name;
    private Engine engine;
    private Gearbox gearbox;
    private Transmission transmission;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public Transmission getTransmission() {
        return transmission;
    }
}
