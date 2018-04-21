package ru.job4j.tracker.database;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrackerStorage {
    private static final TrackerStorage instance = new TrackerStorage();

    public static TrackerStorage getInstance() {
        return instance;
    }

    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String user = "clydeside";
        String password = "root";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addItem(Item item) {
        String query = "INSERT INTO items (id, name, description, created) VALUES (?, ?, ?, ?)";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getDesc());
            statement.setLong(4, item.getCreated());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Item item) {
        String query = "UPDATE items SET name = ?, description = ?, created = ? WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(4, item.getId());
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setLong(3, item.getCreated());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(Item item) {
        String query = "DELETE FROM items WHERE id = (?)";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> findByName(String name) {
        List<Item> result = new CopyOnWriteArrayList<>();
        String query = "SELECT * FROM items WHERE name = ?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,  name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item("");
                item.setName(resultSet.getString(3));
                item.setDesc(resultSet.getString(4));
                item.setCreated(resultSet.getLong(5));
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Item findById(String id) {
        Item result = new Item("");
        String query = "SELECT * FROM items WHERE id = ?";
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,  id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.setId(id);
                result.setName(resultSet.getString(3));
                result.setDesc(resultSet.getString(4));
                result.setCreated(resultSet.getLong(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Item> findAll() {
        List<Item> result = new CopyOnWriteArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM items";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString(2));
                item.setName(resultSet.getString(3));
                item.setDesc(resultSet.getString(4));
                item.setCreated(resultSet.getLong(5));
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
