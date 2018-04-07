package ru.job4j.userApplication;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import ru.job4j.models.User;
import ru.job4j.resourses.UserStorage;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateUserServletTest {
    @Test
    public void insertUser() throws ServletException, IOException {
        CreateUserServlet servlet = new CreateUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        String name = "first";
        String login = "loginFirst";

        when(req.getParameter("name")).thenReturn(name);
        when(req.getParameter("login")).thenReturn(login);
        servlet.doPost(req, resp);

        UserStorage storage = UserStorage.getInstance();
        List<User> users = storage.getAllUsers();
        assertThat(users.get(0).getName(), is("first"));
        assertThat(users.get(0).getLogin(), is("loginFirst"));
        storage.deleteUserByNameAndLogin(name, login);
    }
}