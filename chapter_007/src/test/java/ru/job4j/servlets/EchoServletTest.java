package ru.job4j.servlets;

import org.junit.Test;

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

public class EchoServletTest {
    @Test
    public void postAndGetTest() throws ServletException, IOException {
        EchoServlet servlet = new EchoServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        String login = "loginFirst";
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(req.getParameter("login")).thenReturn(login);
        when(resp.getWriter()).thenReturn(writer);
        servlet.doPost(req, resp);
        List<String> list = servlet.getUsers();
        assertThat(list.get(0), is("loginFirst"));
        assertTrue(stringWriter.toString().contains("Hello, this is a servlet!"));
    }
}