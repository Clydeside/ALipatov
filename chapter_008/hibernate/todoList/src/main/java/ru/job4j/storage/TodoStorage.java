package ru.job4j.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.Todo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TodoStorage {
    private static final TodoStorage instance = new TodoStorage();
    public static TodoStorage getInstance() {
        return instance;
    }

    public void insertTodo(Todo todo) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(todo);
        todo.setName(todo.getName());
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void deleteTodo(int id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Todo todo = new Todo();
        todo.setId(id);
        session.delete(todo);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public List<Todo> getAllTodos() {
        List<Todo> result = new CopyOnWriteArrayList<>();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        result.addAll(session.createQuery("from Todo").list());
        session.getTransaction().commit();
        session.close();
        factory.close();
        return result;
    }
}