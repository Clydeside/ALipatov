package ru.job4j.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarTest {
    @Test

    public void carTest() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Car> list = session.createQuery("from Car").list();
        for (Car elem : list) {
            System.out.println(elem + "");
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}