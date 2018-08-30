package ru.job4j.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import ru.job4j.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CarStorage {
    private static final CarStorage instance = new CarStorage();

    public static CarStorage getInstance() {
        return instance;
    }

    private final <T> T tx(final Function<Session, T> command) {
        final SessionFactory factory = new Configuration().configure().buildSessionFactory();
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
            factory.close();
        }
    }

    public List<Car> getAllCars() {
        return tx(session -> session.createQuery("from Car").list());
    }

    public List<Car> getAllCarsByMark(String mark) {
        return tx(session -> {
            List<Car> list = session.createQuery("from Car").list();
            List<Car> result = new ArrayList<>();
            for (Car car : list) {
                if (car.getName().toLowerCase().equals(mark.toLowerCase())) {
                    result.add(car);
                }
            }
            return result;
        });
    }

    public void insertCar(Car car) {
        tx(session -> {
            session.saveOrUpdate(car);
            return null;
        });
    }

    public void deleteCar(int id) {
        tx(session -> {
            Car car = new Car();
            car.setId(id);
            session.delete(car);
            return null;
        });
    }
}
