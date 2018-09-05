package ru.job4j.storage;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.models.Car;
import ru.job4j.models.Engine;
import ru.job4j.models.Gearbox;
import ru.job4j.models.Transmission;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CarStorageTest {
    private final CarStorage storage = CarStorage.getInstance();

    @Test
    public void getInstance() throws Exception {

    }

    @Test
    public void getAllCarsByMark() throws Exception {
    }

    @Test
    public void getAllCars() throws Exception {
    }

    @Ignore
    @Test
    public void insertCar() throws Exception {
        Car car = new Car();
        car.setName("Ford");
        storage.insertCar(car);
        assertThat(storage.findCarById(car.getId()), is(car));
    }

    @Test
    public void deleteCar() throws Exception {
    }

}