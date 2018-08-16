package ru.job4j.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    private int id;
    private String name;
    private Transmission transmission;
    private Engine engine;
    private Gearbox gearbox;

    public Car() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToOne()

    public Transmission getTransmission() {
        return transmission;
    }

    @OneToOne()
    public Engine getEngine() {
        return engine;
    }

    @OneToOne()
    public Gearbox getGearbox() {
        return gearbox;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transmission_id=" + transmission +
                ", engine_id=" + engine +
                ", gearbox_id=" + gearbox +
                '}';
    }
}
