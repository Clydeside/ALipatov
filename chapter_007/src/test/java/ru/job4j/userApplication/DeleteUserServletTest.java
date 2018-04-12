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

public class DeleteUserServletTest {
    @Test
    public void deleteTest() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        DeleteUserServlet servlet = new DeleteUserServlet();
        UserStorage storage = UserStorage.getInstance();
        storage.insertUser(new User("first", "login",null, null));
        int id = storage.getUserIDByNameAndLogin("first", "login");
        when(req.getParameter("id")).thenReturn(Integer.toString(id));
        servlet.doPost(req, resp);
        List<User> users = storage.getAllUsers();
        assertThat(users.isEmpty(), is(true));
    }
}