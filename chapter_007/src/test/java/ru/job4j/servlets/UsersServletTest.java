package ru.job4j.servlets;

import org.junit.Test;
import ru.job4j.models.User;
import ru.job4j.resourses.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsersServletTest {
    @Test
    public void postTest() throws IOException, ServletException {
        UsersServlet servlet = new UsersServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        String name = "MyName";
        String login = "MyLogin";
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(req.getParameter("name")).thenReturn(name);
        when(req.getParameter("login")).thenReturn(login);
        when(resp.getWriter()).thenReturn(writer);
        servlet.doPost(req, resp);
        UserStorage storage = UserStorage.getInstance();
        List<User> users = storage.getAllUsers();
        assertThat(users.get(0).getName(), is("MyName"));
        assertThat(users.get(0).getLogin(), is("MyLogin"));
        storage.deleteUserByNameAndLogin(name, login);
    }
}