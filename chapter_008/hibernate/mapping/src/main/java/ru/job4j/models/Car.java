package ru.job4j.models;

public class Car {
    private int id;
    private String name;
    private int transmission_id;
    private int engine_id;
    private int gearbox_id;

    public Car() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransmission_id(int transmission_id) {
        this.transmission_id = transmission_id;
    }

    public void setEngine_id(int engine_id) {
        this.engine_id = engine_id;
    }

    public void setGearbox_id(int gearbox_id) {
        this.gearbox_id = gearbox_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTransmission_id() {
        return transmission_id;
    }

    public int getEngine_id() {
        return engine_id;
    }

    public int getGearbox_id() {
        return gearbox_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transmission_id=" + transmission_id +
                ", engine_id=" + engine_id +
                ", gearbox_id=" + gearbox_id +
                '}';
    }
}
