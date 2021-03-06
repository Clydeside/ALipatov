package ru.job4j.resourses;

import ru.job4j.models.Role;
import ru.job4j.models.User;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStorage {
    private static final UserStorage instance = new UserStorage();
    private List<User> result = getAllUsers();

    private UserStorage() {
        result.add(new User("Admin", "root", null, new Role("admin", "root")));
    }

    public boolean isCredential(String login, String password) {
        boolean exist = false;
        for (User user : result) {
            if (user.getLogin().equals(login) && user.getRole().getPassword().equals(password)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public static UserStorage getInstance(){
        return instance;
    }

    private Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/java_a_to_z";
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

    public void insertUser(User user) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO users (name, login) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            Connection connection = getConnection();
            String query = "UPDATE users set name = ?, login = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setInt(3, user.getId());

            statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUserByNameAndLogin(String name, String login) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM users WHERE name = ? AND login = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, login);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getUserIDByNameAndLogin(String name, String login) {
        int id = 0;
        try {
            Connection connection = getConnection();
            String query = "SELECT id FROM users WHERE name = ? AND login = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, login);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<User> getAllUsers() {
        List<User> result = new CopyOnWriteArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));

                result.add(user);
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
