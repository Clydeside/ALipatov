package ru.job4j.userApplication;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SignOutControllerTest {
    @Test
    public void exitTest() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(req.getRequestDispatcher("/WEB-INF/views/signIn.jsp")).thenReturn(dispatcher);
        when(req.getSession()).thenReturn(session);

        SignOutController controller = new SignOutController();
        controller.doPost(req, resp);
        verify(session, atLeastOnce()).invalidate();
    }
}