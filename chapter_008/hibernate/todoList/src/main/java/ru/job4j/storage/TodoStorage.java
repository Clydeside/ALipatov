package ru.job4j.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.Todo;

import java.util.List;
import java.util.function.Function;

public class TodoStorage {
    private static final TodoStorage instance = new TodoStorage();

    public static TodoStorage getInstance() {
        return instance;
    }

    private <T> T tx(final Function<Session, T> command) {
        final SessionFactory factory = new Configuration().configure().buildSessionFactory();
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
            factory.close();
        }
    }

    public List<Todo> getAllTodos() {
        return tx(session -> session.createQuery("from Todo").list());
    }

    public void insertTodo(Todo todo) {
        tx(session -> {
            session.saveOrUpdate(todo);
            return null;
        });
    }

    public void deleteTodo(int id) {
        tx(session -> {
            Todo todo = new Todo();
            todo.setId(id);
            session.delete(todo);
            return null;
        });
    }
}