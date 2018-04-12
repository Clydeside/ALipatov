package ru.job4j.userApplication;

import org.junit.Test;
import ru.job4j.models.User;
import ru.job4j.resourses.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UpdateUserServletTest {
    @Test
    public void updateServletTest() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        User user = new User("userr", "logg",null, null);
        UserStorage storage = UserStorage.getInstance();
        storage.insertUser(user);
        String name = "user";
        String login = "log";
        String id = Integer.toString(storage.getUserIDByNameAndLogin("userr", "logg"));
        when(req.getParameter("id")).thenReturn(id);
        when(req.getParameter("name")).thenReturn(name);
        when(req.getParameter("login")).thenReturn(login);
        UpdateUserServlet servlet = new UpdateUserServlet();
        servlet.doPost(req, resp);
        List<User> users = storage.getAllUsers();
        assertThat(users.get(0).getName(), is("user"));
        assertThat(users.get(0).getLogin(), is("log"));
        storage.deleteUserByNameAndLogin(name, login);
    }
}